package ch2;

import io.reactivex.Completable;

public class Ch2_32_1 {

    public static void main(String[] args) {
        //来自一个子线程
        Completable.fromRunnable(() -> runnable.run())
                .subscribe(() -> System.out.println("Done!"));

    }

    ;


    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("runnable");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                System.err.println(e.getLocalizedMessage());
            }
        }
    };

    public static void runProcess() {
//run process here
        System.out.println("Done!----");
    }
}