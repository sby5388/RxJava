package ch1;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

public class Ch1_3 {
    public static void main(String[] args) {
//        Interval每隔一定时间发射一个整数，从0开始
        Observable<Long> secondIntervals = Observable.interval(500, TimeUnit.MILLISECONDS);
        secondIntervals.subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println(aLong);
            }
        });
        /* Hold main thread for 5 secondsso Observable above has chance to fire */
        /**
         * todo 保持主线程5秒，因此才有机会观察到以上数据发射
         */
        sleep(500000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}