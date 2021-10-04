package test3;

import org.junit.Test;

import java.util.Date;
import static org.junit.Assert.assertTrue;

public class TimerTest {
    @Test
    public void testCount() {
        Date date = new Date();
        (new Timer()).count("42", "42");
    }

    @Test
    public void testCount1() {
        Date date = new Date();
        long res = (new Timer()).count(String.valueOf(date.getHours()+1), String.valueOf(date.getMinutes()));
        assertTrue((3540000 <= res && res <= 3600000));
    }

    @Test
    public void testCount2() {
        Date date = new Date();
        long res = (new Timer()).count(String.valueOf(date.getHours()), String.valueOf(date.getMinutes()+5));
        assertTrue((240000 <= res && res <= 300000));
    }
}

