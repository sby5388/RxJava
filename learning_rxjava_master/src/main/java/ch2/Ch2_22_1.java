package ch2;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Ch2_22_1 {
    public static void main(String[] args) {
        //直接抛出一个异常
//        Observable.error(new Exception("Crash and burn!"))
//                .subscribe(i -> System.out.println("RECEIVED: " + i),
//                        Throwable::printStackTrace,
//                        () -> System.out.println("Done!"));
        Observable<Exception> exceptionObservable = getErrorObservable();
        exceptionObservable.subscribe(new Observer<Exception>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Exception e) {
                System.out.println(e.getLocalizedMessage());
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("done");
            }
        });
    }


    private static Observable<Exception> getErrorObservable() {
        return Observable.create(new ObservableOnSubscribe<Exception>() {
            @Override
            public void subscribe(ObservableEmitter<Exception> e) throws Exception {
                e.onNext(new IOException());
                e.onError(new IOException());
                e.onComplete();
            }
        });
        //return Observable.error(new IOException());
    }
}