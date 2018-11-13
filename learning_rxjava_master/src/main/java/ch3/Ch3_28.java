package ch3;

import java.time.LocalDate;

import io.reactivex.Observable;

public class Ch3_28 {
    public static void main(String[] args) {
        Observable.just("2016-01-01", "2016-05-02", "2016-09-12",
                "2016-04-03")
                .map(LocalDate::parse)
                //any：只要有一个满足条件
                //与all:操作符相对应
                .any(dt -> dt.getMonthValue() >= 6)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}