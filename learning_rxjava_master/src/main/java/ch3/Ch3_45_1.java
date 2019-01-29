package ch3;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Ch3_45_1 {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                //todo 发生错误时，执行更换发布者，停止当前数据的发射
                .onErrorResumeNext(new Function<Throwable, ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Throwable throwable) {
                        return Observable.just(-1).repeat(2);
                    }
                })
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}