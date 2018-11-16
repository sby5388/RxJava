package ch3;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Ch3_35_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMap(new Function<String, Character>() {
                    @Override
                    public Character apply(String s) throws Exception {
                        return s.charAt(0);
                    }
                })
                .subscribe(s -> System.out.println("Received: " + s));
    }
}