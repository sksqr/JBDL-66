package com.example.L20paymentgatewaydemo.controller;

import com.example.L20paymentgatewaydemo.entity.Merchant;
import com.example.L20paymentgatewaydemo.entity.Transaction;
import com.example.L20paymentgatewaydemo.repo.MerchantRepo;
import com.example.L20paymentgatewaydemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/payment-page")
public class PaymentPageController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private MerchantRepo merchantRepo;

    @GetMapping("/{txnId}")
    public ModelAndView getMenu(@PathVariable String txnId){
        ModelAndView modelAndView = new ModelAndView("paymentpage.html");

        Transaction transaction = transactionService.getTransaction(txnId);
        Merchant merchant = merchantRepo.findById(transaction.getMerchantId()).get();
        modelAndView.getModelMap().put("merchantName",merchant.getName());
        modelAndView.getModelMap().put("amount",transaction.getAmount());
        modelAndView.getModelMap().put("txnId",txnId);
        modelAndView.getModelMap().put("actionUrl","/pg-service/doPayment/"+txnId);

        return modelAndView;

    }
}
