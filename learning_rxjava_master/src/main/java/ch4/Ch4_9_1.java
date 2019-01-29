package ch4;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class Ch4_9_1 {
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<String> source2 =
                Observable.just("Zeta", "Eta", "Theta");
        //2个发布者合并成一个发布者
        //TODO contact 与 merge 2个之间的差别 此外还有 zip的操作
        //TODO contact :前后按顺序发送，如发送完source1 才会发送 source2
        //TODO merge: 当多个 Observable 的发送间隔不一致时，会交叉发送，这个例子没有体现,看ch4_10_1
        //TODO zip 取多个发布者中 数量最少的一个 来作为发送的总个数
        Observable.concat(source1, source2).subscribe(i -> System.out.println("contact: " + i));
        Observable.merge(source1, source2).subscribe(i -> System.out.println("merge: " + i));
        Observable.zip(source1, source2, new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) throws Exception {
                return s + " - " + s2;
            }
        }).subscribe(i -> System.out.println("zip: " + i));
    }
}