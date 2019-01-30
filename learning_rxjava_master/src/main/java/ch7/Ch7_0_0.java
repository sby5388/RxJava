package ch7;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @author by5388  on 2019/1/30.
 */

class Ch7_0_0 {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println(aLong);
                    }
                });
        sleep(5000);
    }
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
