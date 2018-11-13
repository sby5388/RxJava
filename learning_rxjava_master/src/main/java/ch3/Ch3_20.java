package ch3;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

import static java.util.Comparator.reverseOrder;

public class Ch3_20 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                //延迟3秒发送
                .delay(3, TimeUnit.SECONDS)
                //String 逆序
                .sorted(reverseOrder())
                .subscribe(s -> System.out.println("Received: " + s));
        //5秒后结束运行
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