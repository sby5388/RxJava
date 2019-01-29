package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class Ch3_26_1 {
    public static void main(String[] args) {
        Observable.just(5, 3, 7, 10, 2, 14)
                .sorted()
                .reduce("", new BiFunction<String, Integer, String>() {
                    @Override
                    public String apply(String s, Integer integer) {
                        return s + (s.equals("") ? "" : ",") + integer;
                    }
                })
                //.reduce("", (total, next) -> total + (total.equals("") ? "" : ",") + next)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}