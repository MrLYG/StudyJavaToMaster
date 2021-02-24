package DataStructureAndAlgorithm;

import java.util.Stack;

public class Leetcode402 {
//    Given a non-negative integer num represented as a string, remove k digits from the number so that the new number
//    is the smallest possible.
//    Note:
//    The length of num is less than 10002 and will be ≥ k.
//    The given num does not contain any leading zero.
//
//    Example 1:
//
//    Input: num = "1432219", k = 3
//    Output: "1219"
//    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
//    Example 2:
//
//    Input: num = "10200", k = 1
//    Output: "200"
//    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
//            Example 3:
//
//    Input: num = "10", k = 2
//    Output: "0"
//    Explanation: Remove all the digits from the number and it is left with nothing which is 0.

    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack();
        int nums[] = new int[num.length()];
        for(int i = 0; i < num.length(); i++){
            nums[i]=num.charAt(i)-'0';
        }

        for(int i = 0; i < nums.length; i++){
            while(k>0 && !stack.isEmpty() && nums[i] < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(nums[i]);
        }

        while(k>0){
            stack.pop();
            k--;
        }

        Stack<Integer> resStack = new Stack();
        while(!stack.isEmpty()){
            resStack.push(stack.pop());
        }
        StringBuilder res = new StringBuilder();
//        List resL = new ArrayList();
        Boolean flag = true;
        while(!resStack.isEmpty()){
            if(resStack.peek()==0 && flag){
                resStack.pop();
                continue;
            }
            flag = false;
            res.append(resStack.pop());
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}
