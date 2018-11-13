package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class Ch3_6_1 {
    public static void main(String[] args) {
        Observable.range(1, 30)
                .skipWhile(getBiggerThan20())
                //FIXME  为何 小于的限制就不起作用
                .skipWhile(getSmallerThan15())
                .subscribe(integer -> System.out.println(integer),
                        throwable -> System.err.println(throwable.getLocalizedMessage()));
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