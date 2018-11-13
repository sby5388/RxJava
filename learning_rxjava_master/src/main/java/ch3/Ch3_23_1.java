package ch3;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class Ch3_23_1 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                //初始值
                //0：初始值
                .scan(stringBuilder.append("start: "), new BiFunction<StringBuilder, String, StringBuilder>() {
                    @Override
                    public StringBuilder apply(StringBuilder sb, String s) throws Exception {
                        return sb.append(s).append(" ");
                    }
                })
                //.scan(0, (total, next) -> total + 1)
                .subscribe(s -> System.out.println("Received: " + s.toString()));
    }
}