package ch3;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Function;

public class Ch3_34_1 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                //Function<V,K> 与HashMap<K,V>顺序相反
                .toMap(new Function<String, Character>() {
                    @Override
                    public Character apply(String s) throws Exception {
                        return s.charAt(0);
                    }
                })
                .subscribe(new BiConsumer<Map<Character, String>, Throwable>() {
                    @Override
                    public void accept(Map<Character, String> characterStringMap, Throwable throwable) throws Exception {
                        System.out.println("Received: " + characterStringMap);
                    }
                });
    }
}