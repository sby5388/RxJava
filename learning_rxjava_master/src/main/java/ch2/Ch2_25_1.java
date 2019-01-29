package ch2;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

class Ch2_25_1 {
    private static int start = 1;
    private static int count = 5;

    public static void main(String[] args) {
        //defer 修饰的作用：对count 修改后直接起作用，与Ch2_24的差别
        Observable<Integer> source =
                Observable.defer(new Callable<ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> call(){
                        return Observable.range(start, count);
                    }
                });
        source.subscribe(i -> System.out.println("Observer 1: " + i));
        //modify count
        count = 10;
        source.subscribe(i -> System.out.println("Observer 2: " + i));
    }
}