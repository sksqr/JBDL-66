package com.gfg.collection;

import java.util.*;

public class FreqBasedKeywordAnalyzerImp implements KeywordAnalyzerInterface{
    private Map<String, KeywordAndFrequency> dataStore;

    Map<String, Integer> dataStore2;

    public FreqBasedKeywordAnalyzerImp() {
        this.dataStore = new HashMap<>();
    }

    @Override
    public void recordKeyword(String keyword) {
        if(dataStore.containsKey(keyword)){
           KeywordAndFrequency keywordAndFrequency = dataStore.get(keyword);
           keywordAndFrequency.setFrequency(keywordAndFrequency.getFrequency()+1);
        }
        else {
            dataStore.put(keyword,new KeywordAndFrequency(keyword,1));
        }
    }

    @Override
    public List<String> getAllKeywords() {
        return dataStore.keySet().stream().toList();
    }

//    @Override
//    public List<KeywordAndFrequency> getAllKeywordsWithFreq(){
//        return  dataStore.values().stream().toList();
//    }


    @Override
    public List<KeywordAndFrequency> getAllKeywordsWithFreq(){
        return  dataStore.values().stream().sorted(new Comparator<KeywordAndFrequency>() {
            @Override
            public int compare(KeywordAndFrequency o1, KeywordAndFrequency o2) {
                int compare = o1.getFrequency() - o2.getFrequency();
                if(compare == 0){
                    compare = o1.getKeyword().compareTo(o2.getKeyword());
                }
                return compare;
            }
        }).toList();
    }


//    @Override
//    public Map<String,Integer> getAllKeywordsWithFreqDataStore2(){
//        //dataStore2
//        // logic for sorting based on value
//    }
}
/*
1. based on freq.
2. If freq based on keyword
 */