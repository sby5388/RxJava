package ch3;

import io.reactivex.Observable;

public class Ch3_4 {
    public static void main(String[] args) {
        //从1开始，发送100个数字
        Observable.range(1, 100)
                //跳过前面的九十个
                .skip(90)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}