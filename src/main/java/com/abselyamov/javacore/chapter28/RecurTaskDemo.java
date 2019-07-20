package com.abselyamov.javacore.chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * A simple example that uses RecursiveTask<V>.
 */
// A RecursiveTask that computes the summation of an array of doubles.
class SumRecursTask extends RecursiveTask<Double> {
    // The sequential threshold value.
    final int seqThresHold = 500;

    //  Array to be accessed.
    double[] data;

    // Determines what part of data to process.
    int start, end;

    public SumRecursTask(double[] vals, int start, int end) {
        this.data = vals;
        this.start = start;
        this.end = end;
    }

    // Find the summation of an array of doubles.
    @Override
    protected Double compute() {
        double sum = 0;

        // If number of elements is below the sequential threshold,
        // then process sequentially.
        if ((end - start) < seqThresHold) {
            //  Sum the elements.
            for (int i = start; i < end; i++)
                sum += data[i];
        } else {
            // Otherwise, continue to break the data into smaller pieces.
            // Find the midpoint.
            int middle = (start + end) / 2;

            // Invoke new tasks, using the subdivided data.
            SumRecursTask subTaskA = new SumRecursTask(data, start, middle);
            SumRecursTask subTaskB = new SumRecursTask(data, middle, end);

            // Start each subtask by forking.
            subTaskA.fork();
            subTaskB.fork();

            // Wait for the subtasks to return, and aggregate the results.
            sum = subTaskA.join() + subTaskB.join();
//            sum = subTaskA.join() + subTaskB.invoke();
//            sum = subTaskA.join() + subTaskB.compute();
        }
        // Return the final sum.
        return sum;
    }
}

public class RecurTaskDemo {
    public static void main(String[] args) {
        // Create a task pool.
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        double[] nums = new double[5000];

        // Initialize nums with values that alternate between
        // positive and negative.
        for (int i = 0; i < nums.length; i++)
            nums[i] = (double) (((i % 2) == 0) ? i : -i);

        SumRecursTask task = new SumRecursTask(nums, 0, nums.length);

        // Start the ForkJoinTasks.  Notice that, in this case,
        // invoke() returns a result.
        double summation = forkJoinPool.invoke(task);

        System.out.println("Summation " + summation);
    }
}
