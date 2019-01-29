package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Ch3_41_1 {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return 10 / integer;
                    }
                })
                //发生错误时后续的不再接收，处理
                .subscribe(new Consumer<Integer>() {
                               @Override
                               public void accept(Integer integer) {
                                   System.out.println("RECEIVED: " + integer);
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) {
                                   System.out.println("RECEIVED ERROR: " + throwable);
                               }
                           }
                );
    }
}