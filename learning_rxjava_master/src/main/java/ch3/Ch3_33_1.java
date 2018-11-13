package ch3;

import io.reactivex.Observable;

public class Ch3_33_1 {
    public static void main(String[] args) {
        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                //->集合 并排序,相同于
                //.toSortedList()
                .sorted()
                .toList()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}