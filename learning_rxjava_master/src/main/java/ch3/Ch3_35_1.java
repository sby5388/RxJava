package ch3;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Ch3_35_1 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                //TODO  见2个接口声明
                // final Function<? super T, ? extends K> keySelector
                //T:参数类型，K:生成Map的key 的类型
                //final Function<? super T, ? extends V> valueSelector
                //T:参数类型，V:生成的Map的value 的类型
                .toMap(new Function<String, Character>() {
                           @Override
                           public Character apply(String s) throws Exception {
                               return s.charAt(0);
                           }
                       },
                        new Function<String, Integer>() {
                            @Override
                            public Integer apply(String s) throws Exception {
                                return s.length();
                            }
                        })
                .subscribe(new Consumer<Map<Character, Integer>>() {
                    @Override
                    public void accept(Map<Character, Integer> characterIntegerMap) throws Exception {
                        System.out.println("Received: " + characterIntegerMap);
                    }
                });
    }
}
