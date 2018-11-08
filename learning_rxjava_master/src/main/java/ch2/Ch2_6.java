package ch2;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

import java.util.Arrays;
import java.util.List;

public class Ch2_6 {
    public static void main(String[] args) {
        List<String> items =
                Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<String> source = Observable.fromIterable(items);
        source.map(String::length).filter(i -> i >= 5)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
        source.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) throws Exception {
                return s.length() >= 5;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.err.println(s);
            }
        });
    }
}