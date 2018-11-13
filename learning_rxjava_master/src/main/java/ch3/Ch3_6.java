package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.Predicate;

public class Ch3_6 {
    public static void main(String[] args) {
        Observable.range(1, 100)
                //skipWhile ：当条件不满足时执行
                //跳过小于等于95的
//                .skipWhile(i -> i <= 95)
                //TODO 当2个条件时 ，过滤失败
//                .skipWhile(integer -> (integer >= 8 || integer <= 4))
                .skipWhile(integer -> integer <= 40)
                .skipWhile(integer -> integer <= 80)
                .skipWhile(integer -> integer >= 90)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}