package ch3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Ch3_38_2 {
    public static void main(String[] args) {
        Observable<String> stringObservable = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon");
        //根据条件转换成多个Map
        Single<Map<Integer, Collection<String>>> mapSingle = stringObservable.toMultimap(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        mapSingle.subscribe(new Consumer<Map<Integer, Collection<String>>>() {
            @Override
            public void accept(Map<Integer, Collection<String>> integerCollectionMap) throws Exception {
                Set<Integer> keySet = integerCollectionMap.keySet();
                for (Integer key : keySet) {
                    Collection<String> collection = integerCollectionMap.get(key);
                    Iterator<String> iterator = collection.iterator();
                    System.out.println("key = " + key);
                    while ((iterator.hasNext())) {
                        System.out.println(iterator.next());
                    }
                }
            }
        });
    }
}