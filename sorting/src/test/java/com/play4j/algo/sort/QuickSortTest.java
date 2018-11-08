package com.play4j.algo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by
 *
 * @Author: lis, Igor, foxigs%gmail.com
 * Date: 03.11.2018  * Time: 12:14
 */
class QuickSortTest {
    @Test
    void run() {
        int[]expect = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[]a = {3, 0, 1, 8, 7, 2, 5, 4, 9, 6};

        Sorting sorting = new QuickSort();
        int[] result = sorting.sort(a);
        assertArrayEquals(expect, result);
    }

    @Test
    void testLonger() {
        int[]expect = {0, 1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9, 13, 20};
        int[]a = {3, 0, 1, 8, 7, 2, 5, 13, 4, 9, 6, 20, 3, 5};

        Sorting sorting = new QuickSort();
        int[] result = sorting.sort(a);
        assertArrayEquals(expect, result);
    }

}