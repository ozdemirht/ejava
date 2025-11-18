package dsa;


import java.util.Arrays;

/**
 * Problem: Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays
 *
 * Error Cases
 *
 * Happy Path
 *
 * ALG-1: merge-sort, then find median
 *        Time Complexity : O(n+m)
 *        Space Complexity: O(n+m)
 *
 * ALG-2: find ((m+n)/2)th element
 *         Time Complexity: O(n+m)
 *         Space Complexity: O(1)
 */
public class prob_p3 {

    public float solve(int[] num1, int[] num2){
        float ret = 0;
        int[] merged = new int[num1.length+num2.length];
        int i=0, j=0, k=0;
        while(i<num1.length && j<num2.length){
            if(num1[i]<num2[j]){
                merged[k] = num1[i];
                i++; k++;
            } else {
                merged[k] = num2[j];
                j++; k++;
            }
        }
        while(i<num1.length) {
            merged[k] = num1[i];
            i++; k++;
        }
        while(j<num2.length){
                merged[k] = num2[j];
                j++; k++;
        }
        k=num1.length+num2.length;
        if((k%2)==0){
            k=num1.length+(num2.length-num1.length)/2;
            ret=(merged[k]+merged[k+1])/2;
        } else {
            k=num1.length+(num2.length-num1.length)/2;
            ret=merged[k];
        }
        return ret;
    }
    float getFromArray(int[] num1,  int[] num2, int prev_idx, int idx){
        float ret=0;
        if(idx<num1.length){
            ret = (num1[prev_idx]+num1[idx])/2;
        } else {
            idx -= num1.length;
            prev_idx -= num1.length;
            ret = (num2[prev_idx] + num2[idx]) / 2;
        }
        return ret;

    }
    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public float solve2(int[] num1, int[] num2) {
        float ret = 0;
        int mlength = num1.length+num2.length;
        int prev_idx, idx;

        if((mlength%2)==1){
            prev_idx=idx=mlength/2;
        } else {
            prev_idx=mlength/2;
            idx=prev_idx+1;
        }
        if(num1[num1.length-1]<=num2[0]){
            ret=getFromArray(num1,  num2, prev_idx,idx);
            return ret;
        }
        if(num2[num2.length-1]<=num1[0]){
            ret = getFromArray(num2,  num1, prev_idx,idx);
            return ret;
        }
        int idx_value=-1;
        int prev_idx_value=-1;
        int found = 0;
        int i=0, j=0, k=0;
        while (found < 3 && i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                //merged[k]=num1[i];
                if (k == prev_idx) {
                    prev_idx_value = num1[i];
                    found += 1;
                }
                if (k == idx) {
                    idx_value = num1[i];
                    found += 2;
                }
                i++;
                k++;
            } else {
                //merged[k] = num2[j];
                if (k == prev_idx) {
                    prev_idx_value = num2[j];
                    found += 1;
                }
                if (k == idx) {
                    idx_value = num2[j];
                    found += 2;
                }
                j++;
                k++;
            }
        }
        while (found < 3 && i < num1.length) {
            //merged[k] = num1[i];
            if (k == prev_idx) {
                prev_idx_value = num1[i];
                found += 1;
            }
            if (k == idx) {
                idx_value = num1[i];
                found += 2;
            }
            i++;
            k++;
        }
        while (found < 3 && j < num2.length) {
            //merged[k] = num2[j];
            if (k == prev_idx) {
                prev_idx_value = num2[j];
                found += 1;
            }
            if (k == idx) {
                idx_value = num2[j];
                found += 2;
            }

            j++;
            k++;
        }
        if(found==3) ret=(prev_idx_value+idx_value)/2;
        else ret=-1;
        return ret;
    }

    /**
     *
     */
    public void run_tests(){
        int[][] test_num1 = {{1,2,3,4,5}, {1,2,3,4,5}};
        int[][] test_num2 = {{3,4,5,6,7,8},{3,4,5,6,7}};
        float[] test_expected = {4,4};
        float[] test_result = new float[test_expected.length];

        for(int i=0;i<test_expected.length;i++){
            //test_result[i] = solve(test_num1[i],test_num2[i]);
            test_result[i] = solve2(test_num1[i],test_num2[i]);
            System.out.println("===== TEST ["+i+"] ===========================");
            System.out.println("test_num1["+i+"]     = "+Arrays.toString(test_num1[i]));
            System.out.println("test_num2["+i+"]     = "+Arrays.toString(test_num2[i]));
            System.out.println("test_result["+i+"]   = "+test_result[i]);
            System.out.println("test_expected["+i+"] = "+test_expected[i]);

        }
    }
    public static void main(String[] args){
        prob_p3 solver = new prob_p3();
        solver.run_tests();
    }
}
