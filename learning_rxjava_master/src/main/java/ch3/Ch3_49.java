package ch3;

import io.reactivex.Observable;

public class Ch3_49 {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                //重复尝试2次：共3次，与repeat()重复不同，
                .retry(2)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}