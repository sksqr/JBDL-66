package com.gfg.collection;

public class CollectionDemo {
    public static void main(String[] args) {

//        KeywordAnalyzerInterface keywordAnalyzer = new KeywordAnalyzerImpl();
//        KeywordAnalyzerInterface keywordAnalyzer = new UniqueKeywordAnalyzerImpl();

        KeywordAnalyzerInterface keywordAnalyzer = new FreqBasedKeywordAnalyzerImp();

        keywordAnalyzer.recordKeyword("TWS");
        keywordAnalyzer.recordKeyword("Laptop");
        keywordAnalyzer.recordKeyword("Mobile");
        keywordAnalyzer.recordKeyword("Pen Drive");
        keywordAnalyzer.recordKeyword("Mobile");
        keywordAnalyzer.recordKeyword("iPhone");
        keywordAnalyzer.recordKeyword("TWS");

        System.out.println(keywordAnalyzer.getAllKeywords());


        System.out.println(keywordAnalyzer.getAllKeywordsWithFreq());

    }
}
