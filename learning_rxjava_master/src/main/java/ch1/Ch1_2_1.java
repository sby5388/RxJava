package ch1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Ch1_2_1 {
    public static void main(String[] args) {
        final String[] source = {"Alpha", "Beta", "Gamma", "Delta", "Epsilon"};
//        todo 这种List<>只能是常量，不能增删
        final List<String> stringList = Arrays.asList(source);

        Observable<String> myStrings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        myStrings.map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return s.length();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                //System.out.println(integer);
            }
        });

        Observable.fromArray(source)
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        return s.length();
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });

        Observable.fromIterable(stringList)
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        //对数据进行排序
                        return o2.compareTo(o1);
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });


//        myStrings.map(
// S vcadty;
//
// lyut\   ring::length)
//                .subscribe(System.out::println);
    }
}