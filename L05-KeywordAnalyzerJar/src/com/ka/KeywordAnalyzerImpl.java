package com.ka;

import java.util.ArrayList;
import java.util.List;

public class KeywordAnalyzerImpl implements KeywordAnalyzerInterface{

    private List<String> dataStore;

    public KeywordAnalyzerImpl() {
        this.dataStore = new ArrayList<>();
    }

    @Override
    public void recordKeyword(String keyword) {
        dataStore.add(keyword);
    }

    @Override
    public List<String> getAllKeywords() {
        return dataStore;
    }
}
