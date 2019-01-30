package ch5;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

public class Ch5_24_1 {
    public static void main(String[] args) {
        Consumer<String> consumer1 = s -> System.out.println("Observer 1: " + s);
        Consumer<String> consumer2 = s -> System.out.println("Observer 2: " + s);
        Subject<String> subject = ReplaySubject.create();
//        Subject<String> subject =

        //代码的执行顺序与代码的先后位置并不是完全完全一致的
        subject.subscribe(consumer1);
        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();
        subject.subscribe(consumer2);
        subject.subscribe(consumer1);
    }
}