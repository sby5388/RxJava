package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * scan操作符是遍历源Observable产生的结果，
 * 再按照自定义规则进行运算，依次输出每次计算后的结果给订阅者:
 * <p>
 * call 回掉第一个参数是上次的结算结果，第二个参数是当此的源observable的输入值
 * 注意:当执行原Observable输入的第一个时,并不会回掉call函数，也就是说第一次并不参与运算，直接输给订阅者:
 */
public class Ch3_22_1 {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(5, 3, 7, 10, 2, 14);

        //扫描遍历：不带初始值，第一次遍历把第一个参数作为初始值，然后遍历下一个
        observable.scan(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) throws Exception {
                //累加操作
                return a + b;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer result) throws Exception {
                System.out.println("Received : " + result);
            }
        });

        //默认值，初始值
        int initialValue = 5;
        Observable.just(3, 7, 10, 2, 14)
                //TODO 扫描？累加？带有初始值的遍历
                .scan(initialValue, new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                })
                .subscribe(s -> System.out.println("Received: " + s));
    }
}