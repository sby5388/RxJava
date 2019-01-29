import org.junit.Test;

import java.util.Optional;


/**
 * @author by5388  on 2018/12/6.
 */

public class GuavaTest2 {
    @Test
    public void testGuava1() {
        Integer invalidInput = 20;
        Optional<Integer> a = Optional.of(invalidInput);
        Optional<Integer> b = Optional.of(10);


        System.out.println(add(a, b));

    }

    public Integer add(Integer a, Integer b) {
        return a + b;
    }


    private Integer add(Optional<Integer> a, Optional<Integer> b) {
        return a.get() + b.get();
    }
}
