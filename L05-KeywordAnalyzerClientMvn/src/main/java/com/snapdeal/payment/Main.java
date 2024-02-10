package com.snapdeal.payment;

import com.snapdeal.shipping.KeywordAnalyzerInterface;
import com.snapdeal.shipping.RandomImp;
import com.snapdeal.shipping.UniqueKeywordAnalyzerImpl;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        KeywordAnalyzerInterface keywordAnalyzerInterface = new UniqueKeywordAnalyzerImpl(new HashSet<>());

        KeywordAnalyzerInterface keywordAnalyzerInterface1 = new RandomImp();


    }
}