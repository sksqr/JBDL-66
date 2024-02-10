package com.kaclient;

import com.ka.KeywordAnalyzerInterface;
import com.ka.NewKeywordAnalyzerImpl;
import com.ka.UniqueKeywordAnalyzerImpl;

import java.util.HashSet;

public class KeywordAnalyzerClientMain {

    public static void main(String[] args) {
        KeywordAnalyzerInterface keywordAnalyzer = new UniqueKeywordAnalyzerImpl(new HashSet<>());

        KeywordAnalyzerInterface keywordAnalyzerInterface = new NewKeywordAnalyzerImpl();

        keywordAnalyzer.recordKeyword("laptop");
        keywordAnalyzer.recordKeyword("pen");
        keywordAnalyzer.recordKeyword("laptop");

        System.out.println(keywordAnalyzer.getAllKeywords());
    }
}
