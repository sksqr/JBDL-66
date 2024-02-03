package com.gfg.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtilDemo {
    public static void main(String[] args) {


        int[] arr = {10,5,1,12,7};
        Arrays.sort(arr);
        System.out.println(arr);
        System.out.println(arr[0]);

        List<Integer> list = Arrays.asList(1,6,0,10,5);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);


    }
}
