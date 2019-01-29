package ch3;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class Ch3_30_2 {
    public static void main(String[] args) {
        Observable<Integer> integerObservable =
                Observable.just(45, 96, 89, 12, 66, 84, 22, 22, 55, 88);
        integerObservable = integerObservable.sorted();
        //-->容器类：集合
        Single<List<Integer>> interListSingle = integerObservable.toList();
        interListSingle.subscribe(s -> System.out.println("Received: " + s));
    }
}