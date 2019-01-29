package ch4;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Ch4_11_1 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        //一个发布者 变成多个 发布者？

        Observable<String> concatMap =
                source.concatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String s) throws Exception {
                return Observable.fromArray(s.split(""));
            }
        });
        concatMap.subscribe(System.out::println);

//        source.concatMap(s -> {
//            // System.out.println("-----");
//            return Observable.fromArray(s.split(""));
//        })
//                .subscribe(System.out::println);
    }
}