package ch4;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class Ch4_6_1 {
    public static void main(String[] args) {
//        Observable<String> source =
//                Observable.just("521934/2342/FOXTROT",112+"");
//        source.flatMap(s -> Observable.fromArray(s.split("/")))
//                //use regex to filter integers
//                .filter(s -> s.matches("[0-9]+"))
//                .map(Integer::valueOf)
//                .subscribe(System.out::println);

        Observable<String> stringObservable = Observable.just("123/12/2ff/44");
        stringObservable.flatMap((String item)->{
            return Observable.fromArray(item.split("/"));
        } ).filter(new Predicate<String>() {
            @Override
            public boolean test(String s) throws Exception {
                return s.matches("[0-9]+");
            }
        }).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return Integer.valueOf(s);
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });



    }
}