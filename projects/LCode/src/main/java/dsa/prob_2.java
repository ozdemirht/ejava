package dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. Add
 *
 * Error Case
 * Input-E1: List-1:[], List-2:[], Expected: []
 * Input-E2: List-1:[], List-2:[1], Expected: [1]
 *
 * Happy Cases:
 * Input-H1: List-1:[1], List-2:[8], Expected: [9]
 * Input-H2: List-1:[1], List-2:[9], Expected: [1,0]
 *
 */
public class prob_2 {
    /**
     *
     */
    void drain_list(
            Stack<Integer> num,
            List<Integer> ans,
            int carry
    ){
        int sum = 0; int digit = 0;
        if(num == null || ans == null || carry<0){
            return;
        }
        while(!num.isEmpty()){
            digit =  num.pop();
            sum = carry + digit;
            carry = sum/10;
            ans.add(0,sum%10);
        }
        if(carry>0) ans.add(0,carry);
    }
    /**
     *
     * @param A
     * @param B
     * @return
     */
    public List<Integer> solve(List<Integer> A, List<Integer> B) {
        if(A.size()==0 || B.size()==0){
            if(A.size()>0){
                return A;
            } else if(B.size()>0){
                return B;
            } else
                return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack_A = new Stack<>();
        Stack<Integer> stack_B = new Stack<>();
        for(int i=0;i<A.size();i++) stack_A.push(A.get(i));
        for(int i=0;i<B.size();i++) stack_B.push(B.get(i));
        int carry = 0;
        int digit_A =0;
        int digit_B =0;
        int sum;
        while(!stack_A.isEmpty() && !stack_B.isEmpty()){
            digit_A =  stack_A.pop();
            digit_B = stack_B.pop();
            sum = carry + digit_A + digit_B;

            carry = sum/10;
            //System.out.println("A:"+digit_A+" B:"+digit_B+" sum:"+sum+" carry:"+carry);
            ans.add(0,sum%10);
        }//
        if(stack_A.isEmpty() && stack_B.isEmpty()){
            if(carry>0) ans.add(0,carry);
        } else {
            if (!stack_A.isEmpty())
                drain_list(stack_A, ans, carry);
            if (!stack_B.isEmpty())
                drain_list(stack_B, ans, carry);
        }
        return ans;
    }

    /**
     *
     */
    void run_test(List<Integer> test_A, List<Integer> test_B, List<Integer> test_expected){
        List<Integer> test_ans = solve(test_A, test_B);
        System.out.println("\n====================================================");
        System.out.println("A : "+test_A);
        System.out.println("B : "+test_B);
        System.out.println("Ouput    : "+test_ans);
        System.out.println("Expected : "+test_expected);
    }
    /**
     *
     */
    public void run_tests(){
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        List<Integer> test1_A = new ArrayList<>();
        List<Integer> test1_B = new ArrayList<>();
        List<Integer> test1_expected = new ArrayList<>();
        run_test(test1_A, test1_B, test1_expected);

        List<Integer> test2_A = new ArrayList<>();
        List<Integer> test2_B = new ArrayList<>();
        List<Integer> test2_expected = new ArrayList<>();
        test2_B.add(1);
        test2_expected.add(1);
        run_test(test2_A, test2_B, test2_expected);

        List<Integer> test3_A = new ArrayList<>();
        List<Integer> test3_B = new ArrayList<>();
        List<Integer> test3_expected = new ArrayList<>();
        test3_A.add(1);
        test3_B.add(8);
        test3_expected.add(9);
        run_test(test3_A, test3_B, test3_expected);

        List<Integer> test4_A = new ArrayList<>();
        List<Integer> test4_B = new ArrayList<>();
        List<Integer> test4_expected = new ArrayList<>();
        test4_A.add(1);
        test4_B.add(9);
        test4_expected.add(1);
        test4_expected.add(0);
        run_test(test4_A, test4_B, test4_expected);

        List<Integer> test5_A = new ArrayList<>();
        List<Integer> test5_B = new ArrayList<>();
        List<Integer> test5_expected = new ArrayList<>();
        for(int i=0;i<4;i++) test5_A.add(9);
        test5_B.add(1);
        test5_expected.add(1);
        for(int i=0;i<4;i++) test5_expected.add(0);
        run_test(test5_A, test5_B, test5_expected);

        System.out.println("\n====================================================");
    }

    public static void main(String[] args){
        prob_2 solver = new prob_2();
        solver.run_tests();
    }
}
