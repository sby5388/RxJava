package ch4;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Ch4_15_1 {
    public static void main(String[] args) {
        Observable<Long> source1 =
                Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> source2 =
                Observable.interval(1, TimeUnit.SECONDS);
        //如果另一个A还没有发送数据，则利用A上一次推送的数据作为本次的发送数据
        Observable.combineLatest(source1, source2,
                (l1, l2) -> "SOURCE 1: " + l1 + " SOURCE 2: " + l2)
                .subscribe(System.out::println);
        sleep(3000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}