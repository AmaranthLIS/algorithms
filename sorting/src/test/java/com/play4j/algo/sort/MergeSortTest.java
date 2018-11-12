package com.play4j.algo.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by
 *
 * @Author: lis, Igor, foxigs%gmail.com
 * Date: 13.11.2018  * Time: 00:15
 */
class MergeSortTest {
    @Test
    void sort() {
        int[]expect = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[]a = {3, 0, 1, 8, 7, 2, 5, 4, 9, 6};

        Sorting sorting = new MergeSort();
        int[] result = sorting.sort(a);
        assertArrayEquals(expect, result);
    }

    @Test
    void testLonger() {
        int[]expect = {0, 1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9, 13, 20, 33};
        int[]a = {3, 0, 1, 8, 33, 7, 2, 5, 13, 4, 9, 6, 20, 3, 5};

        Sorting sorting = new MergeSort();
        int[] result = sorting.sort(a);
        assertArrayEquals(expect, result);
    }

    @Test
    void testMerge() {
        int[]expect = {0, 1, 2, 3, 4, 5, 7, 7, 8, 8, 20, 33};
        int[]a = {0, 1, 3, 7, 8, 33};
        int[]b = {2, 4, 5, 7, 8, 20};

        MergeSortExt sorting = new MergeSortExt();
        int[] result = sorting.mergeSortedArray(a, b);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(expect, result);
    }

    @Test
    void testMerge2() {
        int[]expect = {1, 3, 4, 5, 7, 7, 8, 8, 20, 33, 44, 55};
        int[]a = {1, 3, 7, 8, 33};
        int[]b = {4, 5, 7, 8, 20, 44, 55};

        MergeSortExt sorting = new MergeSortExt();
        int[] result = sorting.mergeSortedArray(a, b);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(expect, result);
    }

    @Test
    void testSeparate() {
        int[]expect =  {0, 1, 33, 3, 4, 5};
        int[]expect2 = {7, 7, 8, 20, 13};
        int[]a = {0, 1, 33, 3, 4, 5, 7, 7, 8, 20, 13};

        MergeSortExt sorting = new MergeSortExt();
        int[][] result = sorting.separate(a);
        System.out.println(Arrays.toString(result[0]));
        assertNotNull(result);
        assertArrayEquals(expect, result[0]);
        assertArrayEquals(expect2, result[1]);
    }


}

class MergeSortExt extends MergeSort {
    int[][] testSeparate(int[]source) {
        return separate(source);
    }
    int[] testMerge(int[]source, int[] source2) {
        return mergeSortedArray(source, source2);
    }
}