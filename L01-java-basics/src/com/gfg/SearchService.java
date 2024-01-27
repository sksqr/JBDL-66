package com.gfg;

import java.util.ArrayList;
import java.util.List;

public class SearchService {

    private ISortingInterface sortingService;

    public SearchService(ISortingInterface sortingService) {
        this.sortingService = sortingService;
    }

    public List<String> getListData(String key){
        // fetched data from database
        List<String> data = new ArrayList<>();

        return sortingService.sort(data);
    }
}
