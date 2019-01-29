package ch3;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

public class Ch3_30_1 {
    public static void main(String[] args) {

        /**
         * TODO toList 返回的结果是Single<List<T>>:
         * Single 与Observable 不同的是：
         * Single只有一个返回结果，
         * 而Observable可以连续返回多个结果，直到onComplete 或者 onError 出现，
         * 中间可以多次执行onNext(t:T)来实现发送多个数据
         */
        Single<List<String>> single = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .sorted()
                //-->容器类：集合
                //返回的结果是Single
                .toList();
        single.subscribe(new BiConsumer<List<String>, Throwable>() {
            @Override
            public void accept(List<String> strings, Throwable throwable) {
                if (throwable != null) {
                    System.out.println(throwable.getLocalizedMessage());
                }
                for (String s : strings) {
                    System.out.println(s);
                }

            }
        });
        single.subscribe(new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) {

            }
        });
    }
}