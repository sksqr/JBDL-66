package com.gfg.controller;


import com.gfg.dto.TxnRequestDto;
import com.gfg.dto.TxnStatusDto;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/txn")
public class TransactionController {


    private static Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @PostMapping
    public ResponseEntity<String> doTransaction(@RequestBody @Valid TxnRequestDto txnRequestDto){
        LOGGER.info("Starting transaction : {}",txnRequestDto);
        //
        return ResponseEntity.accepted().body("1234");
    }

    @GetMapping("/status/{txnId}")
    public ResponseEntity<TxnStatusDto> getTxnStatus(@PathVariable String txnId){
        return null;
    }

}
