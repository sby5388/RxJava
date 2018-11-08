package ch2;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Ch2_36 {
    public static void main(String[] args) {
        Observable<Integer> source =
                Observable.create(observableEmitter -> {
                    try {
                        //TODO ??? 根本停不下来
                        for (int i = 0; i < 1000; i++) {
                            while (!observableEmitter.isDisposed()) {
                                observableEmitter.onNext(i);
                            }
                            if (observableEmitter.isDisposed()) {
                                return;
                            }
                        }
                        observableEmitter.onComplete();
                    } catch (Throwable e) {
                        observableEmitter.onError(e);
                    }
                });
        source.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });
    }
}