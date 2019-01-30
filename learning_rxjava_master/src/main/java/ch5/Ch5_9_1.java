package ch5;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Ch5_9_1 {
    public static void main(String[] args) {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .publish()
                        //TODO 没有数量限制时 ，为1个
                        .autoConnect();
//        todo 其实不是很理解：前面的订阅者数量超过限制时，后面新增加的订阅者
//         会接收不到数据；但是这里的限制数量是1，但是有2个订阅者时
//         依然能够接收到正确的数据

//Observer 1
        seconds.subscribe(i -> System.out.println("Observer 1: " + i));
        sleep(3000);
//Observer 2
        seconds.subscribe(i -> System.out.println("Observer 2: " + i));
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