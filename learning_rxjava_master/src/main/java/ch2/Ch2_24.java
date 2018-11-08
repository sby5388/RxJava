package ch2;

import io.reactivex.Observable;

public class Ch2_24 {
    private static int start = -20;
    private static int count = 6;

    public static void main(String[] args) {
        //从start开始,连续发送count个，没有时间间隔
        Observable<Integer> source = Observable.range(start, count);
        source.subscribe(i -> System.out.println("Observer 1: " + i + 222));
//modify count
        count = 10;
        source.subscribe(i -> System.out.println("Observer 2: " + i));
        Observable<Integer> source2 = Observable.range(start, count);
        source2.subscribe(i -> System.out.println("Observer 3: " + i));
    }
}