package ch1;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Ch1_2 {
    public static void main(String[] args) {
        Observable<String> myStrings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        myStrings.map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return s.length();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });
//        myStrings.map(
// S vcadty;
//
// lyut\   ring::length)
//                .subscribe(System.out::println);
    }
}