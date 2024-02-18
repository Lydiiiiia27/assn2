package comp533;

import gradingTools.comp533s19.assignment0.AMapReduceTracer;

public class Joiner extends AMapReduceTracer {
    private final int total;
    private int finished = 0;

    public Joiner(int total) {
        this.total = total;
        traceJoinerCreated(this, total);
    }

    public static Joiner getJoiner(int numThreads){
        return new Joiner(numThreads);
    }

    public synchronized void finished() {
        finished++;
        traceJoinerFinishedTask(this, total, finished);
        if (finished >= total) {
            notifyAll();
            traceJoinerRelease(this, total, finished);
        }
    }

    public synchronized void join() {
        while (finished < total) {
            traceJoinerWaitStart(this, total, finished);
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            traceJoinerWaitEnd(this, total, finished);
        }
        finished = 0; // Reset for reuse
    }

    @Override
    public String toString() {
        return JOINER;
    }
}
