package lc;

import java.util.Arrays;

public class LC_202510A {
    public int maxBottlesDrunk(int numFullBottles,int numEmptyBottles, int numExchange) {
        int totalBottlesDrunk = 0;
        int totalNumberOfEmptyBottles = numFullBottles + numEmptyBottles;
        System.out.println(  " numFullBottles: "+numFullBottles
                            +" numEmptyBottles: "+numEmptyBottles
                            +" numExchange: "+numExchange
                            +" totalNumberOfEmptyBottles: "+totalNumberOfEmptyBottles
                            +" totalBottleDrunk : "+totalBottlesDrunk);
        // Can we drink and exchange?
        while(totalNumberOfEmptyBottles>=numExchange) {
            // First Drink All
            totalBottlesDrunk += numFullBottles;
            // Add to Empty Bottles Count
            numEmptyBottles += numFullBottles;
            // Reset Full Bottles Count
            numFullBottles=0;
            // Can we exchange based on current exchange cost
            while(numEmptyBottles>=numExchange) {
                numEmptyBottles -= numExchange;
                numExchange++;
                numFullBottles++;
                System.out.println(  " numFullBottles: "+numFullBottles
                        +" numEmptyBottles: "+numEmptyBottles
                        +" numExchange: "+numExchange
                        //+" totalNumberOfEmptyBottles: "+totalNumberOfEmptyBottles
                        +" totalBottleDrunk : "+totalBottlesDrunk);
            }
            // Remaining potential
            totalNumberOfEmptyBottles = numFullBottles + numEmptyBottles;
            System.out.println(  " numFullBottles: "+numFullBottles
                    +" numEmptyBottles: "+numEmptyBottles
                    +" numExchange: "+numExchange
                    +" totalNumberOfEmptyBottles: "+totalNumberOfEmptyBottles
                    +" totalBottleDrunk : "+totalBottlesDrunk);

        }
        return totalBottlesDrunk+numFullBottles;
    }
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        return maxBottlesDrunk(numBottles,0,numExchange);
    }
    public int solve(int numBottles, int numExchange){
        return maxBottlesDrunk( numBottles, numExchange);
    }
    public void run_tests(){
        int[][] test = {{13,6,15},{10,3,13}};
        for(int[] testCase : test){
            System.out.println("Input: "+ Arrays.toString(testCase));
            int ans = solve(testCase[0],testCase[1]);
            System.out.println("Output: "+ans);
            System.out.println("Expected: "+testCase[2]);
        }
    }

    public static void main(String[] args){
        LC_202510A solver = new LC_202510A();
        solver.run_tests();
    }
}
