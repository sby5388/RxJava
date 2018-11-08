package ch4;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Ch4_8_1 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
//        source.flatMap(s -> Observable.fromArray(s.split("")), (s, r) -> s + "-" + r)
//                .subscribe(System.out::println);

        source.flatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String string) throws Exception {
                return Observable.fromArray(string.split(""))
                        .map(new Function<String, String>() {
                            @Override
                            public String apply(String s) throws Exception {
                                return string + "-" + s;
                            }
                        });
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
    }
}