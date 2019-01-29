package ch3;

import io.reactivex.Observable;

public class Ch3_50 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                //下一步继续之前，对数据简单处理，没有返回值
                .doOnNext(s -> System.out.println("Processing: " + s))
                .map(String::length)
                .subscribe(i -> System.out.println("Received: " + i));
    }
}