package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class Ch3_6_1_2 {
    public static void main(String[] args) {
        Observable.range(1, 30)
                .skipWhile(getBiggerThan20())
                //FIXME  为何 小于的限制就不起作用
//                .skipWhile(getSmallerThan15())
                //只会执行一次：如果想筛选出大于等于15且小于等于20 的，应当使用filter方法
                .skipWhile(get15To20())
                .subscribe(integer -> System.out.println(integer));

        Observable.range(1, 30)
                .filter(get15To20())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("filter :" + integer);
                    }
                });
    }


    /**
     * 大于20的
     * skipWhile: 条件不满足时执行
     * 输出 大于 20的，所以条件就应当为小于等于20的
     */
    private static Predicate<Integer> getBiggerThan20() {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer <= 20;
            }
        };
    }

    private static Predicate<Integer> get15To20() {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer <= 20 && integer >= 15;
            }
        };
    }

    /**
     * 小于15的
     * skipWhile: 条件不满足时执行
     * 输出 小于15的，所以条件就应当为大于等于15的
     */
    private static Predicate<Integer> getSmallerThan15() {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer >= 15;
            }
        };
    }
}