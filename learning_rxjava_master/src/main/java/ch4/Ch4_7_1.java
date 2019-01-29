package ch4;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Ch4_7_1 {
    public static void main(String[] args) {
        Observable<Integer> intervalArguments =
                Observable.just(2, 3, 10, 7);
        Observable<Long> longObservable = intervalArguments.flatMap(new Function<Integer, ObservableSource<Long>>() {
            @Override
            public ObservableSource<Long> apply(Integer integer) throws Exception {
                return Observable.interval(integer, TimeUnit.SECONDS);
            }
        });
        Observable<String> map = longObservable.map(new Function<Long, String>() {
            @Override
            public String apply(Long i) throws Exception {
                return i + "s interval: " + ((i + 1) * i) + " seconds elapsed";
            }
        });
        //map.subscribe(System.out::println);

        intervalArguments.flatMap(i ->
                Observable.interval(i, TimeUnit.SECONDS)
                        .map(i2 -> i + "s interval: " + ((i + 1) * i) + " seconds elapsed")
        ).subscribe(System.out::println);
        sleep(12000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}