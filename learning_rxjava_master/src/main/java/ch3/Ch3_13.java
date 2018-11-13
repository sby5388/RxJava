package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Ch3_13 {
    public static void main(String[] args) {
        Observable<String> menu =
                Observable.just("Coffee", "Tea", "Espresso", "Latte");
//print menu
        //如同对发射的数据 在0位置上插入一个新的数据
        menu.startWith("COFFEE SHOP MENU")
                //
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        return s.length();
                    }
                })
                //
                .subscribe(System.out::println);
    }
}