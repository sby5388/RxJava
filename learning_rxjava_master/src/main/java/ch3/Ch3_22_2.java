package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class Ch3_22_2 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6)
                // TODO 累积
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer*integer2;
                    }
                })
//                .scan((accumulator, next) -> accumulator + next)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}