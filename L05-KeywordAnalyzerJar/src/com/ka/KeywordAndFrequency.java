package com.ka;

public class KeywordAndFrequency {
    private String keyword;

    private Integer frequency;

    public KeywordAndFrequency(String keyword, Integer frequency) {
        this.keyword = keyword;
        this.frequency = frequency;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "KeywordAndFrequency{" +
                "keyword='" + keyword + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
