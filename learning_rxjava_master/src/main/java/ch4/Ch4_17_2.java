package ch4;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.GroupedObservable;

public class Ch4_17_2 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<GroupedObservable<Integer, String>> byLengths =
                //按长度进行分组
                source.groupBy(s -> s.length());
        byLengths.subscribe(new Consumer<GroupedObservable<Integer, String>>() {
            @Override
            public void accept(GroupedObservable<Integer, String> integerStringGroupedObservable) {
//                todo GroupedObservable的数据结构是什么
//                integerStringGroupedObservable.
                System.out.println(integerStringGroupedObservable.getKey());
            }
        });
    }
}