package ch2;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Ch2_27 {
    public static void main(String[] args) {
        //fromCallable 与just() 不同的是，subscribe 可以对Observable的异常进行捕获
        Observable.fromCallable(() -> 1 / 0)
                .subscribe(i -> System.out.println("Received: " + i),
                        e -> System.out.println("Error Captured: " + e));

        Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1/0;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {
                System.err.println(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}