package ch4;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Ch4_14_1 {
    public static void main(String[] args) {
        Observable<String> strings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .map(new Function<Long, Long>() {
                            @Override
                            public Long apply(Long aLong) throws Exception {
                                return aLong + 10;
                            }
                        });
        Observable.zip(strings, seconds, (s, l) -> s)
                .subscribe(s ->
                        System.out.println("Received " + s +
                                " at " + LocalTime.now())
                );
        sleep(6000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}