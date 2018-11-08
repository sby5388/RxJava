package ch4;

import io.reactivex.Observable;

public class Ch4_9 {
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<String> source2 =
                Observable.just("Zeta", "Eta", "Theta");
        //2个发布者合并成一个发布者
        Observable.concat(source1, source2)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}