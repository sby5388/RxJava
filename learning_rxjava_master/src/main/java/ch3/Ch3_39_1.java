package ch3;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;

public class Ch3_39_1 {
    public static void main(String[] args) {

        //todo 根据Lambda 表达式 来推断出原来 函数（完整的接口）
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .collect(new Callable<Set<String>>() {
                    @Override
                    public Set<String> call() {
                        return new HashSet<>(10);
                    }
                }, new BiConsumer<Set<String>, String>() {
                    @Override
                    public void accept(Set<String> set, String s) {
                        set.add(s);
                    }
                })
                //.collect(HashSet::new, HashSet::add)
                .subscribe(new BiConsumer<Set<String>, Throwable>() {
                    @Override
                    public void accept(Set<String> set, Throwable throwable) throws Exception {
                        System.out.println("Received: " + set);
                    }
                });
    }
}