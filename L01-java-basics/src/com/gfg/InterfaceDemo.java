package com.gfg;

public class InterfaceDemo {

    public static void main(String[] args) {
        TataTiago tataTiago = new TataTiago();
        System.out.println(tataTiago.getPUC());

//        SearchService searchService = new SearchService(new MergeSortService());
        SearchService searchService = new SearchService(new CountSortServcie());
        searchService.getListData("Java");
    }
}
