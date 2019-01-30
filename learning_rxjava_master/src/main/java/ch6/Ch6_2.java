package ch6;

import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.Observable;

public class Ch6_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .map(s -> intenseCalculation((s)))
                .subscribe(System.out::println);
        Observable.range(1, 6)
                .map(s -> intenseCalculation((s)))
                .subscribe(System.out::println);
    }

    public static <T> T intenseCalculation(T value) {
        int sleepTime = ThreadLocalRandom.current().nextInt(2000);
        System.out.println("睡眠时间 : " + sleepTime);
        sleep(sleepTime);
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