package ch3;

import io.reactivex.Observable;

public class Ch3_48 {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 16 / i)
                //todo 遇到异常时，重新开始发送，
                // todo  没有异常时（把0更换），正常发送
                .retry()
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}