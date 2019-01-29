package ch4;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Ch4_16_1 {
    public static void main(String[] args) {
        Observable<Long> source1 =
                Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> source2 =
                Observable.interval(1, TimeUnit.SECONDS);
        //等到2个都有数据产生时，才会进行一次数据推送
        source2.withLatestFrom(source1,
                (l1, l2) -> "SOURCE 2: " + l1 + " SOURCE 1: " + l2
        ).subscribe(System.out::println);
        sleep(10000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}