package ch3;

import io.reactivex.Observable;

public class Ch3_24 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                //统计个数
                .count()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}