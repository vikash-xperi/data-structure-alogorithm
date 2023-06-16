package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxAndMinArray {

    public static void main(String[] args) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
//        Pair minmax = getMinMax(arr, 0, arr.length - 1);
//        Pair minmax = compareInPairs(arr);
        Pair minmax = usingHeap(arr);
        System.out.println("Minimum: "+ minmax.min);
        System.out.println("Maximum: "+ minmax.max);
    }

    /**
     * get minimum and maximum values of arrays in O(n) time complexity
     * @param arr  arrays
     * @param p  first index of array
     * @param q  last index of array
     * @return an object contains minimum and maximum values of arrays
     */
    private static Pair getMinMax(int[] arr, int p, int q) {
        Pair minmax = new Pair();
        Pair mml = new Pair();
        Pair mmr = new Pair();

        //if array has only one element
        if (p == q) {
            minmax.min = arr[p];
            minmax.max = arr[p];
            return minmax;
        }
        //if array has two elements
        else if (q == p + 1) {
            if (arr[p] > arr[q]) {
                minmax.min = arr[q];
                minmax.max = arr[p];
            }
            else {
                minmax.min = arr[p];
                minmax.max = arr[q];
            }
            return minmax;
        }

        //if array has more than two elements
        int mid = (p + q) / 2;
        mml = getMinMax(arr, p, mid);
        mmr = getMinMax(arr, mid + 1, q);

        //check minimum of two parts
        if (mml.min > mmr.min) {
            minmax.min = mmr.min;
        }
        else {
            minmax.min = mml.min;
        }

        //check maximum of two parts
        if (mml.max > mmr.max) {
            minmax.max = mml.max;
        }
        else {
            minmax.max = mmr.max;
        }
        return minmax;
    }

    private static Pair compareInPairs(int[] arr) {
        Pair minmax = new Pair();
        int i = 0;
        if (arr.length % 2 != 0) {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
        }
        else {
            if (arr[0] > arr[1]) {
                minmax.min = arr[1];
                minmax.max = arr[0];
            }
            else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
        }

        for (; i < arr.length; i += 2) {
            if (arr[i] > arr[i + 1]) {
                if (minmax.min > arr[i + 1]) {
                    minmax.min = arr[i + 1];
                    if (minmax.max < arr[i]) {
                        minmax.max = arr[i];
                    }
                }
            }
            else {
                if (minmax.max < arr[i + 1]) {
                    minmax.max = arr[i + 1];
                    if (minmax.min > arr[i]) {
                        minmax.min = arr[i];
                    }
                }
            }
        }
        return minmax;
    }

    private static Pair usingHeap(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        Arrays.stream(arr).forEach(x -> {
            minHeap.add(x);
            maxHeap.add(x);
        });
        return new Pair(minHeap.peek(), maxHeap.peek());
    }

}
