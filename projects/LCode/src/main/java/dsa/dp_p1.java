package dsa;

import java.util.HashMap;
import java.util.Map;

/**
 * There are n stairs, and a person standing at the bottom wants to climb stairs to reach the top.
 * The person can climb either 1 stair or 2 stairs at a time,
 * the task is to count the number of ways that a person can reach at the top.
 *
 * solve(n,memo)
 *   return solve(n-1,memo)+solve(n-2,memo);
 */
public class dp_p1 {
    /**
     *
     * @param n
     * @param memo
     * @return
     */
    public int solve(int n, Map<Integer,Integer> memo){
        //System.out.println("n: "+n+" memo: "+memo.size());
        if(n<1) return 0;
        if(memo.containsKey(n))
            return memo.get(n);
        // Recursive
        int step_1 = (n>1?solve(n-1, memo):0);
        int step_2 = (n>2?solve(n-2, memo):0);
        // add to memoization
        memo.put(n,step_1+step_2);
        return step_1+step_2;
    }

    /**
     *
     * @param n
     * @return
     */
    public int solve_tabulation(int n){
        int[] dp = new int[n+1];
        dp[0] = 1; // 0 steps => 1 way
        dp[1] = 1; // 1 steps => 1 way
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     *
     * @param n
     * @return
     */
    public int solve_tabulation2(int n){
        //int[] dp = new int[n+1];
        int prev1 = 1; // 0 steps => 1 way
        int prev2 = 1; // 1 steps => 1 way
        int current =prev2;
        for(int i=2; i<=n; i++){
            current = prev1+prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }

    public void run_tests(){

        int[][] test = {{2,2}, {1,1}, {3,3},{4,5},{5,8}}; //[[2,2], [1,1], [3,5]];

        int ans = 0;
        System.out.println();
        for(int i=0;i<test.length;i++) {
            Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
            memo.put(1,1);
            memo.put(2,2);
            ans = solve(test[i][0],memo);
            System.out.println(   " n          : " + test[i][0]
                                + " Answer.....: " + ans
                                + " Expected...: " + test[i][1]
                                + " Tabulation.: " + solve_tabulation(test[i][0])
                                + " Tabulation2: " + solve_tabulation2(test[i][0]));
        }

    }

    public static void main(String[] args){
        dp_p1 solver = new dp_p1();
        solver.run_tests();
    }
}
