package ch3;

import io.reactivex.Observable;

public class Ch3_47 {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                //作用同 ch3_45 可以对异常进行处理
                .onErrorResumeNext((Throwable e) -> Observable.just(-1).repeat(3))
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}