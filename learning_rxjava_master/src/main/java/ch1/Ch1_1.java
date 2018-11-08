package ch1;

import io.reactivex.Observable;

public class Ch1_1 {
    public static void main(String[] args) {
        Observable<String> myStrings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        myStrings.subscribe(System.out::println);
    }
}