package com.interview;

import java.util.ArrayList;
import java.util.List;

public class PECS {

    //both methods have same erasure
    public void add(List<Integer> list) {
        //https://habr.com/ru/post/559268/
        //Согласно принципу PECS, мы не можем ничего положить в данный лист, он будет являться только поставщиком данных.
        final List<? extends Number> listPecs = new ArrayList<>();
        listPecs.add(1);
        listPecs.add(new Double(123));

    }

    public void add(List<String> list) {

    }

}
