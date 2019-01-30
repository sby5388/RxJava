package ch5;

import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.Observable;

public class Ch5_8 {
    public static void main(String[] args) {
        Observable<Integer> threeRandoms = Observable.range(1, 3)
                .map(i -> randomInt())
                .publish()
                .autoConnect(2);
        //Observer 1 - print each random integer
        threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));
        //Observer 2 - sum the random integers, then print
                threeRandoms.reduce(0, (total, next) -> total + next)
                        .subscribe(i -> System.out.println("Observer 2: " +
                                i));
        //Observer 3 - receives nothing
        //超过了autoConnect()所限制的订阅者数量，不会接收到数据
        threeRandoms.subscribe(i -> System.out.println("Observer 3:" + i));
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}