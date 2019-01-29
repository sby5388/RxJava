package ch4;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Ch4_7_1 {
    public static void main(String[] args) {
        Observable<Integer> intervalArguments =
                Observable.just(2, 3, 10, 7);
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