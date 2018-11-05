package com.play4j.algo.sort;


import com.play4j.algo.domain.Tuple;


/**
 * Created by
 *
 * @Author: lis, Igor, foxigs@mail.ru
 * Date: 23.09.2018  * Time: 23:30
 * O(n log n)
 */
public class QuickSort implements Sorting {

    @Override
    public int[] sort(int[] source) {
        int point = 0;
        int last = source.length-1;

//        System.out.println("arr="+ Arrays.toString(source));
        makeSort(source, new Tuple(point, last));//init start

        return source;
    }

    private Tuple makeSort(int[] s, Tuple findPoint)
    {
        if (null == findPoint) {
            return null;
        }
        if (findPoint.startPoint > findPoint.startLast) {
            return null;
        }
        Tuple localPoint = findPoint;

        while (!(-1 == findPoint.startPoint && -1 == findPoint.startLast))
        {
            int point = (-1 == findPoint.startPoint)? 0: findPoint.startPoint;
            int last = findPoint.startLast;
            int findPosition = sortHere(s, point, last);

            if (findPosition >= s.length || findPosition <= 0) {
                return null;
            }
//            System.out.println("arr="+ Arrays.toString(s));
            if (findPosition-1 < 0) {
                return null;
            }
            if (null != localPoint && findPosition != localPoint.startLast) {
                localPoint = new Tuple(findPosition + 1, localPoint.startLast);
            } else {
                localPoint = null;
            }

            findPoint = makeSort(s, new Tuple(findPoint.startPoint, findPosition - 1));

            if (null == findPoint && null != localPoint) {
                findPoint = localPoint;
//                localPoint = null;
            } else if (null == findPoint) {
                return null;
            }
        }

        return null;
    }

    private int sortHere(int[] s, int point, int last) {
        boolean right = true;
        while (point != last)
        {
            if (right) {
                if (s[point] > s[last]) {
                    int valRaw = s[last];
                    s[last] = s[point];
                    s[point] = valRaw;

                    int temp = point;
                    point = last;//take new id of point
                    last = temp;
                    right = false;//change direction
                    last++;
                } else {
                    last--;
                }
            } else {
                if (s[point] < s[last]) {
                    //change value
                    int valRaw = s[last];
                    s[last] = s[point];
                    s[point] = valRaw;

                    //change index
                    int temp = point;
                    point = last;//take new id of point
                    last = temp;
                    right = true;//change direction
                    last--;
                } else {
                    last++;
                }
            }

            if (last >= s.length || last <= 0) {
                return -1;
            }
            if (point == last) {
                return point;
            }
        }
        return point;
    }
}