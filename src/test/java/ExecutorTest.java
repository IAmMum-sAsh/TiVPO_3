package test3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

public class ExecutorTest {
    @Test
    public void testRun() throws InterruptedException, ExecutionException {
        Executor executor = new Executor(new PlayerThread());
        executor.run();
        assertEquals(0L, executor.delay);
    }

    @Test
    public void testSetDelay() {
        (new Executor(new PlayerThread())).setDelay("42", "42");
    }

    @Test
    public void testSetDelay1() {
        Executor executor = new Executor(new PlayerThread());
        executor.setDelay("42", "11");
        Timer timer = new Timer();
        assertEquals(timer.count("42", "11"), executor.delay);
    }

    @Test
    public void testStop() {
        Executor executor = new Executor(new PlayerThread());
        executor.stop();
        assertEquals(0L, executor.delay);
    }
}

