package ch3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Ch3_12_1 {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
//        Observable.just("1/3/2016", "5/9/2016", "10/12/2016")
//                .map(s -> LocalDate.parse(s, dtf))
//                .subscribe(i -> System.out.println("RECEIVED: " + i));
        Observable.just("1/3/2016", "5/9/2016", "10/12/2016")
                .map(new Function<String, LocalDate>() {
                    @Override
                    public LocalDate apply(String s) throws Exception {
                        return LocalDate.parse(s, dtf);
                    }
                })
                .subscribe(new Consumer<LocalDate>() {
                    @Override
                    public void accept(LocalDate localDate) throws Exception {
                        System.out.println(localDate);
                    }
                });
    }


}