package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Ch3_34_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "By5388",
                "Epsilon")
                //Map 生成HashMap??
                //todo 是生成一个HashMap，一个k,对应一个value,前面的value会被后面的替换掉
                .toMap(new Function<String, Character>() {
                    @Override
                    public Character apply(String s) throws Exception {
                        return s.charAt(0);
                    }
                })
                .subscribe(s -> System.out.println("Received: " + s));
    }
}