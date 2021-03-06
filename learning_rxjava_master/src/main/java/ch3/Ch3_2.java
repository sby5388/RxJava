package ch3;

import io.reactivex.Observable;

public class Ch3_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                //取前3个
                .take(3)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}