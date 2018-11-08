package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ch3_16_1 {
    public static void main(String[] args) {

//        Observable.just("Alpha", "Beta", "Gamma", "Delta",
//                "Epsilon")
//                .filter(s -> s.startsWith("Z"))
//                .switchIfEmpty(Observable.just("Zeta", "Eta", "Theta"))
//                .subscribe(i -> System.out.println("RECEIVED: " + i),
//                        e -> System.out.println("RECEIVED ERROR: " + e)
//                );

        List<String> strings = new ArrayList<>(5);
        strings.add("Alpha");
        strings.add("Beta");
        strings.add("Gamma");
        strings.add("Delta");
        strings.add("Epsilon");
        Observable<List<String>> observable = Observable.just(strings);
        observable.doOnNext(new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) throws Exception {
                  strings.stream().filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.length() == 5;
                    }
                });
            }
        }).subscribe(new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) throws Exception {
                System.out.println(strings.toString());
            }
        });

    }
}