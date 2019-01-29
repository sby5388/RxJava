package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class Ch3_51 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .doOnComplete(() -> System.out.println("Source is done emitting!发送完成"))
                .map(String::length)
                .subscribe(i -> System.out.println("Received: " + i), new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("Receiver Done 接收完成");
                    }
                });
    }
}