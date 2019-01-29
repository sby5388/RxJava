package ch7;

import java.util.List;

import io.reactivex.Observable;

public class Ch7_1_1 {
    public static void main(String[] args) {
        Observable<List<Integer>> listObservable =
                Observable.range(1, 50)
                        //每8个生成一个集合
                        .buffer(8);
        listObservable.subscribe(System.out::println);
    }
}