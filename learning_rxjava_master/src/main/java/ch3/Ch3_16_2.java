package ch3;

import io.reactivex.Observable;

public class Ch3_16_2 {
    public static void main(String[] args) {
        Observable<String> observableA = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon");
        Observable<String> observableB = Observable.just("Zeta", "Eta", "Theta");

        observableA
                .filter(s -> s.startsWith("Z"))
                //筛选结果为空时，更换被观察者（数据源）
                .switchIfEmpty(observableB)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}