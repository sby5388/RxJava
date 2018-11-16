package ch3;

import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.Observable;

public class Ch3_36 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMap(s -> s.charAt(0), String::length,
                        ConcurrentHashMap::new)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}