package dsa;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Problem: Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * Additions
 * If there are not 2 numbers, return [-1, -1]
 *
 * Cases
 * Input-1: [2] and target=2 expected output: [-1 -1]
 * Input-2: [] and target=2 expected output: [-1 -1]
 * Input-3: [2,3] and target=4 expected output: [-1, -1]
 * Input-4: [2,3] and target=5 expected output: [0, 1]
 *
 * Alg-1: for i for j , Time Complexity: O(n^2), Space Complexity: O(1)
 *
 * Alg-2:
 *     a) sort Time Complexity: O(n log n),
 *
 *     b) search on sorted array, another index array
 *        Time Complexity : n times binary search, find_index_of(i,j,new_target) where new_target=target-a[i]
 *        Time Complexity : O(n log n)
 *     a&b) Time Complexity: O( n log n)
 *     a&b) Space complexity: O(n)
 *
 */
public class prop_1 {

    public int [] solve(int[] nums, int target){
        int[] ret = {-1,-1};
        if(nums.length<2) return ret;
        if(nums.length==2){
            if(target==(nums[0]+nums[1])) {
                ret[0]=0;
                ret[1]=1;
            }
            return ret;
        }
        int i=0, j=0;
        boolean found = false;
        for(i=0; i<nums.length && !found; i++)
            for(j=i; j<nums.length && !found; j++){
                if((nums[i]+nums[j])==target){
                    ret[0]=i;
                    ret[1]=j;
                    found=true;
                }
            }
        return ret;
    }

    public int[] sort_idx(int[] nums){
        int[] idx = new int[nums.length];
        for(int i=0; i<nums.length; i++)idx[i]=i;
        int i, j;
        for(i=0; i<nums.length-1; i++)
            for(j=i+1; j<nums.length; j++)
                if(nums[idx[i]]>nums[idx[j]]){
                    int tmp_idx=idx[i];
                    idx[i]=idx[j];
                    idx[j]=tmp_idx;
                }
        return idx;
    }

    /**
     * Binary Search
     * @param nums
     * @param idx
     * @param start
     * @param end
     * @param target
     * @return
     */
    int find_index_of(
            int[] nums,
            int[] idx,
            int start,
            int end,
            int target
    ){
        int ret=-1;
        if(start>end) return ret;
        if(start==end){
            ret=(nums[idx[start]]==target?idx[start]:-1);
        } else { // start<end
            if(nums[idx[start]]==target){
                ret=idx[start];
            } else if(nums[idx[end]]==target){
                ret=idx[end];
            } else {
                // split
                int middle = start+((end-start)/2);
                if(nums[idx[middle]]==target){
                    ret=idx[middle];
                } else if(nums[idx[middle]]>target){
                    ret=find_index_of(nums, idx, start+1, middle, target);
                } else {
                    ret=find_index_of(nums, idx, middle, end-1, target);
                }
            }
        }
        return ret;
    }

    public int [] solve1(@NotNull int[] nums, int target){
        int[] ret = {-1,-1};
        if(nums.length<2) return ret;
        if(nums.length==2){
            if(target==(nums[0]+nums[1])) {
                ret[0]=0;
                ret[1]=1;
            }
            return ret;
        }
        int i=0, j=0;
        int[] idx = sort_idx(nums);
        boolean found = false;
        for(i=0; i<(nums.length-1) && !found; i++){  // O(n)
            j=-1;
            if((target-nums[i])>0)
                // O(log n)
                j=find_index_of(nums,idx,i+1,nums.length-1,target-nums[i]);
            if(j!=-1){
                found=true;
                ret[0]=i;
                ret[1]=j;
            }
        }
        return ret;
    }

    public void run_test(
        int[] test_0_input,
        int   test_0_target,
        int[] test_0_output
    ){
        //int[] ans = solve(test_0_input, test_0_target);
        int[] ans = solve1(test_0_input, test_0_target);
        System.out.println("\n====================================================");
        System.out.println("Input Array :"+Arrays.toString(test_0_input));
        System.out.println("Input Target:"+test_0_target);
        System.out.println("Output      :"+Arrays.toString(ans));
        System.out.println("Expected    :"+Arrays.toString(test_0_output));
        System.out.println("PASS/FAIL   :"+(ans[0]==test_0_output[0] && ans[1]==test_0_output[1]?"PASSED":"FAILED"));
    }

    public void run_tests(){
        int[] test_0_input = {};
        int[] test_0_output = {-1,-1};
        int  test_0_target = 5;

        run_test(test_0_input, test_0_target, test_0_output);

        int[] test_1_input = {5};
        int[] test_1_output = {-1,-1};
        int  test_1_target = 5;
        run_test(test_1_input, test_1_target, test_1_output);

        int[] test_2_input = {2,3};
        int[] test_2_output = {-1,-1};
        int  test_2_target = 4;
        run_test(test_2_input, test_2_target, test_2_output);

        int[] test_3_input = {2,3};
        int[] test_3_output = {0,1};
        int  test_3_target = 5;
        run_test(test_3_input, test_3_target, test_3_output);

        int[] test_4_input = {2,3,9,11,13,17,5,8};
        int[] test_4_output = {1,6};
        int  test_4_target = 8;
        run_test(test_4_input, test_4_target, test_4_output);

        System.out.println("\n====================================================");

        System.out.println("Input Array :"+Arrays.toString(test_4_input));
        int[] ans = sort_idx(test_4_input);
        int i=0;
        System.out.print("Sorted Array :[");
        for(i=0; i<(ans.length-1); i++)
            System.out.print(test_4_input[ans[i]]+", ");
        System.out.print(test_4_input[ans[i]]+"]\n");
        i=0;
        System.out.print("Index Array :[");
        for(i=0; i<(ans.length-1); i++)
            System.out.print(ans[i]+", ");
        System.out.print(ans[i]+"]");
    }

    public static void main(String[] args){
        prop_1 solver = new prop_1();
        solver.run_tests();
    }
}
