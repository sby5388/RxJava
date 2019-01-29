package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Ch3_44_1 {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        //内部对异常做了处理
                        //TODO  由数据源对异常进行了处理，发送给接收者的是-1，并不是异常标志，
                        //发送不会终止
                        try {
                            return 10 / integer;
                        } catch (ArithmeticException e) {
                            return -1;
                        }
                    }
                })
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}