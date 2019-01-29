package ch3;

import io.reactivex.Observable;

public class Ch3_8 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                //每一种长度单词仅保留一个
                .distinct(String::length)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}