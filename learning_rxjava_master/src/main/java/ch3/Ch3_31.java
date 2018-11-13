package ch3;

import io.reactivex.Observable;

public class Ch3_31 {
    public static void main(String[] args) {
        Observable.range(1, 10)
                //默认长度，不会影响结果
                .toList(10)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}