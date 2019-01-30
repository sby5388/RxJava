package ch5;

import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.Observable;

public class Ch5_7_1 {
    public static void main(String[] args) {
        Observable<Integer> threeRandoms = Observable.range(1, 3)
                .map(i -> randomInt())
                //推迟
                .publish()
                //TODO 当订阅者数量达到count(2)时，自动执行 connect();
                // 如果订阅者一直没有到达count时，则不会推送任何数据
                // 如果订阅者的数量大于count，那么也只有前面的count个订阅者能接收到数据
                .autoConnect(2);

//Observer 1 - print each random integer
        threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));

//Observer 2 - sum the random integers, then print
                threeRandoms.reduce(0, (total, next) -> total + next)
                        .subscribe(i -> System.out.println("Observer 2: " + i));
                threeRandoms.reduce(0, (total, next) -> total + next)
                        .subscribe(i -> System.out.println("Observer 3: " + i));
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}