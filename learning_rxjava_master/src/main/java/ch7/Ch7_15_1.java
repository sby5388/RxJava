package ch7;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Ch7_15_1 {
    public static void main(String[] args) {
        Observable<String> items = Observable.just("Alpha", "Beta",
                "Gamma", "Delta", "Epsilon",
                "Zeta", "Eta", "Theta", "Iota");
        //对每一个数据单元发射前都进行延时
//delay each String to emulate an intense calculation
        Observable<String> processStrings2 = items.concatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String s) {
                return Observable.just(s)
                        .delay(1000,TimeUnit.MILLISECONDS);
            }
        });
        Observable<String> processStrings = items.concatMap(s ->
                Observable.just(s)
                        .delay(randomSleepTime(),
                                TimeUnit.MILLISECONDS)
        );
//run processStrings every 5 seconds, and kill eachprevious instance to start next
        Observable.interval(5, TimeUnit.SECONDS)
                .switchMap(i ->
                        processStrings
                                .doOnDispose(() ->
                                        System.out.println("Disposing! Starting next"))
                ).subscribe(System.out::println);
//keep application alive for 20 seconds
        sleep(20000);
    }

    public static int randomSleepTime() {
//returns random sleep time between 0 to 2000 milliseconds
        return ThreadLocalRandom.current().nextInt(2000);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}