package ch4;

import io.reactivex.Observable;

public class Ch4_1_1 {
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<String> source2 =
                Observable.just("Zeta", "Eta", "Theta");
        //2个观察对象组成一个
        Observable.merge(source1, source2)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}