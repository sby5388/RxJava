package ch7;

import io.reactivex.Observable;

public class Ch7_2 {
    public static void main(String[] args) {
        Observable.range(1, 10)
                //TODO 每2个生成一个List<Integer>,且跳过第三个数据
                .buffer(2, 3)
                .subscribe(System.out::println);
    }
}