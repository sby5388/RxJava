package ch6;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Ch6_5_1 {
    public static void main(String[] args) {
//        Observable.range(-20, 30)
//                .flatMap(new Function<Integer, ObservableSource<Integer>>() {
//                    @Override
//                    public ObservableSource<Integer> apply(Integer integer) throws Exception {
//                        return Observable.just(integer).delay(1, TimeUnit.SECONDS);
//                    }
//                })
//                .sorted(Comparator.reverseOrder())
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer aLong) throws Exception {
//                        System.out.println(aLong);
//                    }
//                });


        Observable.interval(1, TimeUnit.SECONDS)
                .map(l -> intenseCalculation((l)))
                .subscribe(System.out::println);
        sleep(20000);
//        sleep(Integer.MAX_VALUE);
    }

    public static <T> T intenseCalculation(T value) {
//        sleep(ThreadLocalRandom.current().nextInt(3000));
        sleep(1000);
        return value;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}