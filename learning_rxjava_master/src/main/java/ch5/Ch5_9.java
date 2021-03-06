package ch5;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch5_9 {
    public static void main(String[] args) {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .publish()
                        //TODO 没有数量限制时 ，为1个
                        .autoConnect();
//Observer 1
        seconds.subscribe(i -> System.out.println("Observer 1: " + i));
        sleep(3000);
//Observer 2
        seconds.subscribe(i -> System.out.println("Observer 2: " + i));
        sleep(3000);
        System.out.println("9000");
        sleep(9000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}