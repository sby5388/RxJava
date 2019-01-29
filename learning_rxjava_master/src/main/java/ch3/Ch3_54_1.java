package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class Ch3_54_1 {
    public static void main(String[] args) {
        Observable.just(5, 3, 7, 10, 2, 14)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                })
                .doOnSuccess(i -> System.out.println("Emitting: " + i))
                .subscribe(i -> System.out.println("Received: " + i));
    }
}