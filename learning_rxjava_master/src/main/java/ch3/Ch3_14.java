package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Ch3_14 {
    public static void main(String[] args) {
        Observable<String> menu =
                Observable.just("Coffee", "Tea", "Espresso", "Latte");
//print menu
        //在头部插入数组
        menu.startWithArray("COFFEE SHOP MENU", "----------------")
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        //System.out.println(s);
                        return s.length();
                    }
                })
                .subscribe(System.out::println);
    }
}