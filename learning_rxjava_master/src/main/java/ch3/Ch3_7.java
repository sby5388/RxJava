package ch3;

import io.reactivex.Observable;

public class Ch3_7 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .map(String::length)
                //类似于数据库查询的去重
                .distinct()
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}