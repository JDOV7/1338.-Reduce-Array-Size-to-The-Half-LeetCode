/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.Collections;

public class ReduceArraySizetoTheHalf1338 {

    public void ReduceArraySizetoTheHalf1338() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Map<Integer, Integer> mList = new HashMap();
        Vector<Numbers> vList = new Vector();
        int iCounterSet = 0;
        int iSumRepeat = 0;
        for (int i : arr) {
            if (mList.get(i) == null) {
                mList.put(i, 1);
            } else {
                mList.put(i, mList.get(i) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mList.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            vList.add(new Numbers(value, key));
        }
        Collections.sort(vList);
        for (Numbers numbers : vList) {
            if (iSumRepeat + numbers.getiRepeat() < arr.length / 2) {
                iSumRepeat += numbers.getiRepeat();
                iCounterSet += 1;
            } else {
                iCounterSet += 1;
                break;
            }
        }
        System.out.println(iCounterSet);
    }

    public class Numbers implements Comparable<Numbers> {

        int iRepeat;
        int iNumber;

        public int getiRepeat() {
            return iRepeat;
        }

        public int getiNumber() {
            return iNumber;
        }

        public Numbers(int iRepeat, int iNumber) {
            this.iRepeat = iRepeat;
            this.iNumber = iNumber;
        }

        public int compareTo(Numbers nData) {
            if (nData.getiRepeat() > getiRepeat()) {
                return 1;
            }
            if (nData.getiRepeat() < getiRepeat()) {
                return -1;
            }
            return 0;
        }
    }
}
