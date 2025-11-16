package dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers cost[] of length n, where cost[i]
 * is the cost of the ith step on a staircase.
 * Once the cost is paid, we can either climb one or two steps.
 * We can either start from the step with index 0, or the step with index 1.
 * The task is to find the minimum cost to reach the top.
 *
 * d[i] = min(d[i-1],d[i-2])+c[i]
 * Error Case
 *  Input-E1 : {}, expected: 0
 *
 *  Happy Path
 *  Input-H1 : {10}, expected:0
 *  Input-H2 : {1,10}, expected:1
 *  Input-H3 : {1,10,1}, expected:2  , 1 step and 2 step
 */
public class dp_p2 {

    public int solve_memo(
            int[] cost,
            int n,
            Map<Integer,Integer> memo
    ){
        if(cost.length<2) return 0;
        // base cases
        if(n<0) return 0;
        // sub-problem
        if(memo.containsKey(n))
            return memo.get(n);
        // need to solve
        int by2 = solve_memo(cost, n-2, memo);
        int by1 = solve_memo(cost, n-1, memo);
        int min_cost = Math.min(by1,by2)+cost[n];
        //System.out.println("n:"+n+" by2:"+ by2+" by1:"+by1+" min cost: "+min_cost);
        memo.put(n,min_cost);
        return min_cost;
    }

    public int solve_tabulation(int[] cost){
        int[] d = new int[cost.length+1];
        Arrays.fill(d, 0);
        if(cost.length<1) return 0;
        d[0]=0;
        d[1]=cost[0];
        for(int i=1;i<cost.length;i++){
            d[i+1]=Math.min(d[i],d[i-1])+cost[i];
        }
        return Math.min(d[cost.length],d[cost.length-1]);
    }

    /**
     *
     * @param cost
     * @return
     */
    public int solve_tabulation2(int[] cost){
        if(cost.length<1) return 0;
        int cost2n=0;
        int by2 = 0;
        int by1 = cost[0];
        for(int i=1;i<cost.length;i++){
            //System.out.println("i:"+i+" by1:"+by1+" by2:"+by2+" cost["+i+"]:"+cost[i]);
            cost2n=Math.min(by1,by2)+cost[i];
            by2=by1;
            by1=cost2n;

        }
        return cost2n;
    }

    public void run_tests(){
        int[][] test_costs = {
                 {10, 15, 20,0}
                ,{}
                ,{10}
                ,{ 16, 19, 10, 12, 18,0 }
                ,{1, 100, 1, 1, 1, 100, 1, 1, 100, 1,0}
                ,{1,10,0}
                ,{1,10,1,0}
                };
        int[]   test_expected = {15,0,0,31,6,1,2};
        for(int i=0;i<test_costs.length;i++) {
            Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
            if(test_costs[i].length>0) memo.put(0,test_costs[i][0]);
            if(test_costs[i].length>1) memo.put(1,test_costs[i][1]);
            int ans = solve_memo(test_costs[i],test_costs[i].length-1,memo);
            System.out.println(
                      "\n Cost       : " + Arrays.toString(test_costs[i])
                    + "\n Answer.....: " + ans
                    + " Expected...: " + test_expected[i]
                    + " Tabulation.: " + solve_tabulation(test_costs[i])
                    + " Tabulation.: " + solve_tabulation2(test_costs[i]));
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        dp_p2 solver = new dp_p2();
        solver.run_tests();
    }

}
