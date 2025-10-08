package lc;

import java.util.Arrays;

/**
 * 3101. Count Alternating Subarrays
 */
public class LC_202510B {

    public boolean isAlternatingSubarray(int[] nums, int i, int j){
        boolean ret = true;
        int k;
        for(k=i;ret && k<j;k++)
            if(nums[k]==nums[k+1]) ret = false;
        //System.out.println(Arrays.toString(Arrays.copyOfRange(nums,i,j+1))+ " is "+(ret?"":"not ")+"subarray");
        return ret;
    }
    public long countAlternatingSubarrays(int[] nums) {
        long ret = nums.length;
        int i, j;
        for(i=0;i<nums.length;i++){
            j=i+1;
            while(j<nums.length){
                if(isAlternatingSubarray(nums,i,j)) {
                    ret++;
                    j++;
                } else
                    j=nums.length;
            }
        }
        return ret;
    }

    public long solve(int[] nums){
        return countAlternatingSubarrays(nums);
    }
    public void run_tests(){
        int[] test = {0,1,1,1};
        int[] expected = {5};

        test = new int[] {0, 1, 1, 1};
        System.out.println("Input....: "+ Arrays.toString(test));
        long ans = solve(test);
        System.out.println("Output...: "+ans);
        System.out.println("Expected.: "+5);

        test = new int[] {1, 0, 1, 0};
        System.out.println("Input....: "+ Arrays.toString(test));
        ans = solve(test);
        System.out.println("Output...: "+ans);
        System.out.println("Expected.: "+10);

        int[] huge_test = new int[100000];
        for(int i=0;i<huge_test.length;i++) huge_test[i]=i%2;
        ans = solve(huge_test);
        System.out.println("Output...: "+ans);


    }

    public static void main(String[] args){
        LC_202510B solver = new LC_202510B();
        solver.run_tests();
    }
}
