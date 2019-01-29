import com.google.common.base.Optional;

import org.junit.Test;


/**
 * @author by5388  on 2018/12/6.
 */

public class GuavaTest {
    @Test
    public void testGuava1() {
        Integer invalidInput = null;
        Optional<Integer> a = Optional.of(invalidInput);
        Optional<Integer> b = Optional.of(new Integer(10));


        System.out.println(add(a, b));

    }

    public Integer add(Integer a, Integer b) {
        return a + b;
    }


    public Integer add(Optional<Integer> a, Optional<Integer> b) {
        return a.get() + b.get();
    }
}
