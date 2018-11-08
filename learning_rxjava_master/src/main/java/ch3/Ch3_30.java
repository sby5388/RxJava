package ch3;

import io.reactivex.Observable;

public class Ch3_30 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                //-->容器类：集合
                .toList()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}