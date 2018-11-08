package ch2;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Ch2_26_1 {
    public static void main(String[] args) {
//        try {
            Observable.just(1 / 0)
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) throws Exception {
                            System.out.println(integer);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            System.err.println(throwable.getLocalizedMessage());
                        }
                    });
//        }catch (Exception e){
//            System.err.println(e);
//        }
    }
}