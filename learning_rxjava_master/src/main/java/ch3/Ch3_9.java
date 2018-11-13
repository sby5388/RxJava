package ch3;

import io.reactivex.Observable;

public class Ch3_9 {
    public static void main(String[] args) {
        Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1)
                //去重，直到发生变化，即相邻2个不能相同
                .distinctUntilChanged()
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}