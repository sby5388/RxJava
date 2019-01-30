package ch6;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

public class Ch6_5_2 {
    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) {
                int count = 20;
                for (int i = 0; i < count; i++) {
                    e.onNext(i);
                    sleep(1000);
                }
                e.onComplete();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });


//
//        Observable.interval(1, TimeUnit.SECONDS)
//                .map(l -> intenseCalculation((l)))
//                .subscribe(System.out::println);
        sleep(20000);
//        sleep(Integer.MAX_VALUE);
    }

    public static <T> T intenseCalculation(T value) {
//        sleep(ThreadLocalRandom.current().nextInt(3000));
        sleep(1000);
        return value;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}