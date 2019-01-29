package ch1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * 把Observable<List<String>> 变成Observable<String>>
 *
 * @author by5388  on 2019/1/28.
 */

class List2Item<T> {


    public static void main(String[] args) {
        final String[] source = {"Alpha", "Beta", "Gamma", "Delta", "Epsilon"};
//        todo 这种List<>只能是常量，不能增删
        final List<String> stringList = Arrays.asList(source);
        final Observable<List<String>> listObservable = Observable.just(stringList);
        Observable<String> stringObservable = list2item(listObservable);
        stringObservable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        List2Item<String> item = new List2Item<>();
        Observable<String> myObservable = item.list2Items(listObservable);
        myObservable
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.length() == 5;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println("item = " + s);
                    }
                });


    }

    /**
     * TODO 把List<T>集合类观察者 变成单个T类型的观察者
     */
    private static Observable<String> list2item(Observable<List<String>> listObservable) {
        return listObservable.flatMap(new Function<List<String>, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(List<String> strings) {
                //类型转换
                return Observable.fromIterable(strings);
            }
        }).sorted(new Comparator<String>() {
            //排序
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }).filter(new Predicate<String>() {
            //过滤
            @Override
            public boolean test(String s) {
                return s.length() >= 5;
            }
        });
    }

    /**
     * TODO 把List<T>集合类观察者 变成单个T类型的观察者
     */
    private Observable<T> list2Items(Observable<List<T>> listObservable) {
        return listObservable.flatMap((Function<List<T>, ObservableSource<T>>) Observable::fromIterable);
    }


    //    TODO 接收多个Observable<T>  转换成一个Observable<List<T>>的结果
    //fixme  函数还没有返回值！！！
//    private Observable<List<T>> item2List(Observable<T> itemObservable) {
//        Single<List<T>> listSingle = itemObservable.toList();
//        itemObservable.to
//    }
}
