package com.abselyamov.javacore.chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * A simple program that lets you experiment with the effects of
 * changing the threshold and parallelism of a ForkJoinTask.
 */
// A ForkJoinTask (via RecursiveAction) that performs a
// a transform on the elements of an array of doubles.
class Transform extends RecursiveAction {
    // Sequential threshold, which is set by the constructor.
    int seqThreshold;

    // Array to be accessed.
    double[] data;

    // Determines what part of data to process.
    int start, end;

    public Transform(double[] vals, int start, int end, int threshold) {
        this.data = vals;
        this.start = start;
        this.end = end;
        this.seqThreshold = threshold;
    }

    // This is the method in which parallel computation will occur.
    @Override
    protected void compute() {
        // If number of elements is below the sequential threshold,
        // then process sequentially.
        if ((end - start) < seqThreshold) {
            // The following code assigns an element at an even index the
            // square root of its original value. An element at an odd
            // index is assigned its cube root. This code is designed
            // to simply consume CPU time so that the effects of concurrent
            // execution are more readily observable.
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0)
                    data[i] = Math.sqrt(data[i]);
                else
                    data[i] = Math.cbrt(data[i]);
            }
        } else {
            // Otherwise, continue to break the data into smaller pieces.

            // Find the midpoint.
            int middle = (start + end) / 2;

            // Invoke new tasks, using the subdivided data.
            invokeAll(new Transform(data, start, middle, seqThreshold),
                    new Transform(data, middle, end, seqThreshold));
        }
    }
}

// Demonstrate parallel execution.
public class FJExperiment {
    public static void main(String[] args) {
        int pLevel;
        int threshold;

        if (args.length != 2) {
            System.out.println("Usage: FJExperiment parallelism threshold ");
            return;
        }

        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);

        // These variables are used to time the task.
        long beginT, endT;

        // Create a task pool. Notice that the parallelism level is set.
        ForkJoinPool forkJoinPool = new ForkJoinPool(pLevel);

        double[] nums = new double[1_000_000];

        for (int i = 0; i < nums.length; i++)
            nums[i] = (double) i;

        Transform task = new Transform(nums, 0, nums.length, threshold);

        //  Starting timing.
        beginT = System.nanoTime();

        //  Start the main ForkJoinTask.
        forkJoinPool.invoke(task);

        //  End timing.
        endT = System.nanoTime();

        System.out.println("Level of parallelism: " + pLevel);
        System.out.println("Sequential threshold: " + threshold);
        System.out.println("Elapsed time: " + (endT - beginT) + " ns");
        System.out.println();

        /*
            Level of parallelism: 1
            Sequential threshold: 1000
            Elapsed time: 59000100 ns

            Level of parallelism: 2
            Sequential threshold: 1000
            Elapsed time: 41133500 ns

            Level of parallelism: 4
            Sequential threshold: 1000
            Elapsed time: 34077000 ns

            Level of parallelism: 6
            Sequential threshold: 1000
            Elapsed time: 29651100 ns
         */
    }
}
