package ch2;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class Ch2_15 {
    public static void main(String[] args) {
        //从1开始，连续发送10个
        Observable.range(0, 10)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
        List<String> list = new ArrayList<>();
        list.add("by0");
        list.add("by1");
        list.add("by2");
        list.add("by3");
        list.add("by4");

        Observable.range(0, list.size())
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return list.get(integer);
                    }
                }).subscribe(System.out::println);
    }
}