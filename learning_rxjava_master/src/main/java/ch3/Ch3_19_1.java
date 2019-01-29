package ch3;

import java.util.Comparator;
import java.util.function.ToIntFunction;

import io.reactivex.Observable;

public class Ch3_19_1 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                //按长度进行排序
//                .sorted((x, y) -> Integer.compare(x.length(), y.length()))
                //Comparator.comparingInt(String::length)
                .sorted(Comparator.comparingInt(new ToIntFunction<String>() {
                    @Override
                    public int applyAsInt(String value) {
                        return value.length();
                    }
                }))
                .subscribe(System.out::println);
    }
}