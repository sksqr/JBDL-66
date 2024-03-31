package com.gfg;

import com.gfg.config.AddMoneyResponse;
import com.gfg.entity.Wallet;
import com.gfg.repo.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/wallet-service")
public class WalletController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello from wallet-service";
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WalletRepo walletRepo;

    @GetMapping("/add-money-status/{pgTxnId}")
    public ResponseEntity<String> addMoneyStatus(@PathVariable String pgTxnId){
        PGPaymentStatusDTO pgPaymentStatusDTO = restTemplate.getForObject("http://localhost:9090/pg-service/payment-status/"+pgTxnId, PGPaymentStatusDTO.class);
        if( pgPaymentStatusDTO.getStatus().equalsIgnoreCase("SUCCESS")){
            Wallet wallet = walletRepo.findByUserId(pgPaymentStatusDTO.getUserId());
            wallet.setBalance(wallet.getBalance() + pgPaymentStatusDTO.getAmount());
            walletRepo.save(wallet);
            return ResponseEntity.ok("Wallet Updated");
        }
        return ResponseEntity.ok("PG Txn Failed");

    }

    @PostMapping("/add-money")
    public ResponseEntity<AddMoneyResponse> addMoney(@RequestBody AddMoneyRequest addMoneyRequest){
        addMoneyRequest.setMerchantId(1l);
        AddMoneyResponse addMoneyResponse = restTemplate.postForObject("http://localhost:9090/pg-service/init-payment", addMoneyRequest, AddMoneyResponse.class);
        return ResponseEntity.ok(addMoneyResponse);
    }

}
