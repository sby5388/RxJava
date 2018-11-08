package ch2;

import io.reactivex.Observable;

public class Ch2_22 {
    public static void main(String[] args) {
        //直接抛出一个异常
        Observable.error(new Exception("Crash and burn!"))
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
    }
}