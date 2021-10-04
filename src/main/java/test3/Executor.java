package test3;

import java.util.concurrent.*;

public class Executor {
    PlayerThread playerThread;
    long delay;

    public Executor(PlayerThread playerThread){
        this.playerThread = playerThread;
    }

    public void run() throws ExecutionException, InterruptedException {
        ScheduledExecutorService se = Executors.newScheduledThreadPool(5);
        ScheduledFuture sf = se.schedule(new Callable() {
            public Object call() throws Exception {
                return true;
            }
        }, this.delay, TimeUnit.MILLISECONDS);
        sf.get();
        se.shutdown();
        playerThread.start();
    }

    public void setDelay(String hour, String minute){
        Timer timer = new Timer();
        this.delay = timer.count(hour, minute);
    }

    public void stop(){
        playerThread.stop();
    }
}
