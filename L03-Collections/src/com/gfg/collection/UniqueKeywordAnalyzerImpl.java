package com.gfg.collection;

import java.util.*;

public class UniqueKeywordAnalyzerImpl implements KeywordAnalyzerInterface{

    private Set<String> dataStore;

    public UniqueKeywordAnalyzerImpl(Set<String> dataStore) {
       this.dataStore = dataStore;
    }

    @Override
    public void recordKeyword(String keyword) {
        dataStore.add(keyword);
    }

    @Override
    public List<String> getAllKeywords() {
        return dataStore.stream().toList();
    }
}
