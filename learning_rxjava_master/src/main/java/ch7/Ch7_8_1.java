package ch7;

import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Ch7_8_1 {
    static int count = 0;

    public static void main(String[] args) {

        Observable<Integer> integerObservable = Observable.range(1, 50);
        final int width = 8;
        //每width个item 生成一个List<T>的Observable<List<T>>类型的发布者
        Observable<Observable<Integer>> window = integerObservable.window(width);
        Observable<String> stringObservable =
                window.flatMapSingle(new Function<Observable<Integer>, SingleSource<String>>() {
                    @Override
                    public SingleSource<String> apply(Observable<Integer> integerObservable) {
                        return integerObservable.reduce("", new BiFunction<String, Integer, String>() {
                            @Override
                            public String apply(String s, Integer integer) {
                                return s + ("".equals(s) ? "" : "|") + integer;
                            }
                        });
                    }
                });
        stringObservable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) {
                count++;
                System.out.println("count = " + count);
                System.out.println(s);
            }
        });

//        window.flatMapSingle(obs -> obs.reduce("",
//                (total, next) -> total + (total.equals("") ? "" : "|") + next))
//                .subscribe(System.out::println);
    }
}