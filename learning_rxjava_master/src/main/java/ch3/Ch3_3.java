package ch3;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch3_3 {
    public static void main(String[] args) {
        //每隔300毫秒 发送一个
        Observable.interval(300, TimeUnit.MILLISECONDS)
                //连续发送3秒钟（一共10个）
                .take(3, TimeUnit.SECONDS)
                //处理发送的数据
                .subscribe(i -> System.out.println("RECEIVED: " + i));
        //程序运行五秒后结束，保证上面的三秒持续时间能够完成发送任务
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