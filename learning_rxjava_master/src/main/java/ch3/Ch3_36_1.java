package ch3;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Ch3_36_1 {
    public static void main2(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")


                .toMap(s -> s.charAt(0), String::length,
                        ConcurrentHashMap::new)
                .subscribe(s -> System.out.println("Received: " + s));
    }

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMap(new Function<String, Character>() {
                           @Override
                           public Character apply(String s) throws Exception {
                               //TODO
                               return s.charAt(0);
                           }
                       },
                        new Function<String, Integer>() {
                            @Override
                            public Integer apply(String s) throws Exception {
                                return s.length();
                            }
                        }, new Callable<ConcurrentHashMap<Character, Integer>>() {
                            @Override
                            public ConcurrentHashMap<Character, Integer> call() throws Exception {
                                return new ConcurrentHashMap<>(10);
                            }
                        })
                .subscribe(new Consumer<Map<Character, Integer>>() {
                    @Override
                    public void accept(Map<Character, Integer> s) throws Exception {
                        System.out.println("Received: " + s);
                    }
                });
    }
}