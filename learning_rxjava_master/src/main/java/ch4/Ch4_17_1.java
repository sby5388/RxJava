package ch4;

import java.util.Comparator;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.GroupedObservable;

public class Ch4_17_1 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("iii", "Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<GroupedObservable<Integer, String>> byLengths =
                source.groupBy(s -> s.length());

        source.sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}