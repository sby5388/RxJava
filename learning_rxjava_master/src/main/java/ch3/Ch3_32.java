package ch3;

import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.Observable;

public class Ch3_32 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .toList(CopyOnWriteArrayList::new)
                .subscribe(s -> System.out.println("Received: " + s));
        //TODO 多线程 并发容器之CopyOnWriteArrayList
        //每次对容器A的操作是先复制一个容器对象Cp，然会对Cp进行操作，完成之后把A的引用指向Cp
        //参考：https://www.cnblogs.com/dolphin0520/p/3938914.html
    }
}