package ch3;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Ch3_46_1 {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                //todo 发生异常，更换为一个空的发布者
                .onErrorResumeNext(new Function<Throwable, ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Throwable throwable)  {
                        return Observable.empty();
                    }
                })
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}