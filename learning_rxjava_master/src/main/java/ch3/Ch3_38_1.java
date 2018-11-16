package ch3;

import java.util.Collection;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Ch3_38_1 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                //根据条件转换成Map<Integer, Collection<String>>
                //TODO 可以用来做分类！
                .toMultimap(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        return s.length();
                    }
                })
                .subscribe(new Consumer<Map<Integer, Collection<String>>>() {
                    @Override
                    public void accept(Map<Integer, Collection<String>> s) throws Exception {
                        System.out.println("Received: " + s);
                    }
                });
    }
}