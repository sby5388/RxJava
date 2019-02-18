package ch10;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;

public class Ch10_1_1 {
    @Test
    public void testBlaockingSubscribe() {
        AtomicInteger hitCount = new AtomicInteger();

        Observable<Long> source = Observable.interval(1,
                TimeUnit.SECONDS)
                .take(5);
        source.subscribe(i -> hitCount.incrementAndGet());
        assertTrue(hitCount.get() == 5);
    }

    @Test
    public void myTest() {
        String ABC = "ABC";
        assertTrue(ABC.equals(getString()));
    }

    private String getString() {
        return "ABC";
    }
}
