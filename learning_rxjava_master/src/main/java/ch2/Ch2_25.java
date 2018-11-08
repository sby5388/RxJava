package ch2;

import io.reactivex.Observable;

class Ch2_25 {
    private static int start = 1;
    private static int count = 5;

    public static void main(String[] args) {
        //defer 修饰的作用：对count 修改后直接起作用，与Ch2_24的差别
        Observable<Integer> source =
                Observable.defer(() ->
                Observable.range(start, count));
        source.subscribe(i -> System.out.println("Observer 1: " + i));
        //modify count
        count = 10;
        source.subscribe(i -> System.out.println("Observer 2: " + i));
    }
}