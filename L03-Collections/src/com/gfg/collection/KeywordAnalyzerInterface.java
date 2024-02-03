package com.gfg.collection;

import java.util.List;

public interface KeywordAnalyzerInterface {

    void recordKeyword(String keyword);
    List<String> getAllKeywords();

    default List<KeywordAndFrequency> getAllKeywordsWithFreq(){
        return null;
    }

//    List<KeywordAndFrequency> getAllKeywordsWithFreq();
}
