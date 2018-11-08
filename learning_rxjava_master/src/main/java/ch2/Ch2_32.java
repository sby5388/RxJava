package ch2;

import io.reactivex.Completable;

public class Ch2_32 {
    public static void main(String[] args) {
        //来自一个子线程
        Completable.fromRunnable(() -> runProcess())
                .subscribe(() -> System.out.println("Done!"));
    }

    public static void runProcess() {
//run process here
        System.out.println("Done!----");
    }
}