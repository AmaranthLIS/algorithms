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

        int[][]twoBaseArr = split(source);
        source = mergeSortedArray(makeSort(twoBaseArr[0]), makeSort(twoBaseArr[1]));//each argument could be parallel count

        return source;
    }

    private int[] makeSort(int[] source) {
        if (source.length < 2) return source;

        int[][] separatedArr = split(source);
        if (1 > separatedArr.length)
            return new int[]{};
        int[]result, result2;
        if (2 > separatedArr[0].length)
            result = separatedArr[0];
        else
            result = makeSort(separatedArr[0]);

        if (2 > separatedArr[1].length)
            result2 = separatedArr[1];
        else
            result2 = makeSort(separatedArr[1]);

        result = mergeSortedArray(result, result2);
        return result;
    }

    int[][] split(int[] source) {
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
        int[] result = new int[source.length + source2.length];
        int n = 0, startSource2 = 0;
        for (int element : source) {
            for (int j = startSource2; j < source2.length; j++) {
                if (element > source2[j]) {
                    result[n++] = source2[j];
                    startSource2 = j + 1;
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
