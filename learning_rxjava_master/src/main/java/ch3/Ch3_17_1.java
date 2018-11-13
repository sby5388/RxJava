package ch3;

import java.util.Comparator;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Ch3_17_1 {
    public static void main(String[] args) {

        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                //排序？
                .sorted()
                .subscribe(System.out::println);

        //string 长度排序
        Observable<String> items =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        items
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.length() - o2.length();
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
    }
}