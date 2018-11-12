package com.play4j.algo.sort;

import java.util.Arrays;










/**
 * Created by
 *
 * @Author: lis, Igor, foxigs%gmail.com
 * Date: 08.11.2018  * Time: 23:13
 * O(n log n)
 * it use more memory then quickSort
 */
public class MergeSort implements Sorting {
    @Override
    public int[] sort(int[] source) {
        int point = 0;
        int last = source.length-1;

        int[][]twoBaseArr = separate(source);
        source = mergeSortedArray(makeSort(twoBaseArr[0]), makeSort(twoBaseArr[1]));

        return source;
    }

    private int[] makeSort(int[] source) {
        //todo check length of source
        int[][] separatedArr = separate(source);
        if (1 > separatedArr.length)
            return new int[]{};
        if (2 > separatedArr[1].length)
            return separatedArr[0];
        int[]result = makeSort(separatedArr[0]);
        //todo continue develop here
//        source = separatedArr[1];
        return result;
    }

    int[][] separate(int[] source) {
        int[][]result = {};
        if (source.length < 1) return result;
        if (source.length < 2) {
            result = new int[1][];
            result[0] = Arrays.copyOf(source, source.length);
            return result;
        }
        int lengthFirstArr = source.length / 2;
        if (source.length-lengthFirstArr > lengthFirstArr) lengthFirstArr = source.length-lengthFirstArr;
        result = new int[2][];
        result[0] = Arrays.copyOfRange(source, 0, lengthFirstArr);
        result[1] = Arrays.copyOfRange(source, lengthFirstArr, source.length);
        return result;
    }

    int[] mergeSortedArray(int[] source, int[] source2) {
        //todo check little arrays
        int[] result = new int[source.length + source2.length];
        int n = 0, startSource2 = 0;
        for (int i = 0; i < source.length; i++) {
            int element = source[i];
            for (int j = startSource2; j < source2.length; j++) {
                if (element > source2[j]) {
                    result[n++] = source2[j];
                    startSource2 = j+1;
                } else {
                    result[n++] = element;
                        break;
                }
            }
        }

        if (startSource2 != source2.length) {
            System.arraycopy(source2, startSource2, result, n, source2.length-startSource2);
        } else if (n != result.length) {
            result[n] = source[source.length-1];
        }

        return result;
    }
}
