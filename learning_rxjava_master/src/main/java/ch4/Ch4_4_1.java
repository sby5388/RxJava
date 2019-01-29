package ch4;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Ch4_4_1 {
    public static void main(String[] args) {
        //emit every second 每一秒发一次
        Observable<String> source1 =
                //interval 一定时间，发送数据，从0开始
                Observable.interval(1, TimeUnit.SECONDS)
                        // emit elapsed seconds
                        .map(l -> l + 1)
                        .map(l -> "Source1: " + l + " seconds");
        //emit every 300 milliseconds 每300毫秒 发送一次
        Observable<String> source2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        // emit elapsed milliseconds
                        .map(l -> (l + 1) * 300)
                        .map(l -> "Source2: " + l + " milliseconds");
        //merge and subscribe
        Observable.merge(source1, source2)
                .subscribe(System.out::println);
        //keep alive for 3 seconds
        //
        sleep(3000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}