package ch3;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;

public class Ch3_39_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .collect(new Callable<Set<String>>() {
                    @Override
                    public Set<String> call() throws Exception {
                        return new HashSet<>(10);
                    }
                }, new BiConsumer<Set<String>, String>() {
                    @Override
                    public void accept(Set<String> strings, String s) throws Exception {
                        strings.add(s);
                    }
                })
                .subscribe(s -> System.out.println("Received: " + s));
    }
}