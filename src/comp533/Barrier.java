package comp533;

import gradingTools.comp533s19.assignment0.AMapReduceTracer;

public class Barrier extends AMapReduceTracer {
    private int count;
    private int waiting = 0; // Number of threads currently waiting
    private final int initialCount;

    public Barrier(int count) {
        this.count = count;
        this.initialCount = count;
        traceBarrierCreated(this, count);
    }

    public static Barrier getBarrier(int numThreads){
        return new Barrier(numThreads);
    }

    public synchronized void barrier() {
        waiting++;
        traceBarrierWaitStart(this, initialCount, waiting);
        if (waiting < count) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            waiting = 0; // Reset for reuse
            count = initialCount; // Reset count if needed
            notifyAll();
            traceBarrierReleaseAll(this, initialCount, waiting);
        }
        traceBarrierWaitEnd(this, initialCount, waiting);
    }

    @Override
    public String toString() {
        return BARRIER;
    }
}
