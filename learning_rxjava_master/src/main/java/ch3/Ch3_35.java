package ch3;

import io.reactivex.Observable;

public class Ch3_35 {
    /**
     * 函数原型见 Ch3_25_1.java
     *
     * @param args
     * @see Ch3_35_1
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                //类似于toList ,把多个Observable 组合成一个Observable
                .toMap(s -> s.charAt(0), String::length)
                .subscribe(s -> System.out.println("Received: " + s));
    }


}