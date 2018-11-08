package ch3;

import io.reactivex.Observable;

import java.util.Comparator;

public class Ch3_19 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                //按长度进行排序
//                .sorted((x, y) -> Integer.compare(x.length(), y.length()))
                .sorted(Comparator.comparingInt(String::length))
                .subscribe(System.out::println);
    }
}