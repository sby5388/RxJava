package ch3;

import io.reactivex.Observable;

public class Ch3_42_1 {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                //异常时，以-1代替异常e，结束接收
                .onErrorReturnItem(-1)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}