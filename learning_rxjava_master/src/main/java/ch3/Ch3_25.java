package ch3;

import io.reactivex.Observable;

/**
 * scan和reduce都是把操作的观察序列的上一次操作的结果做为第二次的参数传递给第二次Observable使用，
 * 但两者有区别:
 * scan:每次操作之后先把数据输出，然后在调用scan的回调函数进行第二次操作
 * reduce：把所有的操作都操作完成之后在调用一次观察者，把数据一次性输出
 * ---------------------
 * 作者：cangck_x
 * 来源：CSDN
 * 原文：https://blog.csdn.net/cangck_x/article/details/75305454
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class Ch3_25 {
    public static void main(String[] args) {
        Observable.just(5, 3, 7, 10, 2, 14)
                //todo 遍历，类似于 scan 操作符，但只有一个输出值
                .reduce((total, next) -> total + next)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}