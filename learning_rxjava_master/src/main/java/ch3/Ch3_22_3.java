package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class Ch3_22_3 {
    public static void main(String[] args) {
        Observable.just(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
                // TODO 累积
                .scan(new BiFunction<Double, Double, Double>() {
                    @Override
                    public Double apply(Double aDouble, Double aDouble2) throws Exception {
                        return aDouble*aDouble2;
                    }
                })
//                .scan((accumulator, next) -> accumulator + next)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}