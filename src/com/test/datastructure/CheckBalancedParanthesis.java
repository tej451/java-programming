package com.test.datastructure;

import java.util.Stack;

public class CheckBalancedParanthesis {
    public static void main (String [] args)
    {
        String test_good = "()(){}{}{()}";
        String test_bad = "((({}{}))()";
        String test_good1 = "(3+4";
        String test = "a+(b*c)+(d/e)";

        System.out.println(checkBalanced(test));
        //System.out.println(checkBalanced(test_bad));
    }

    public static boolean checkBalanced(String check)
    {
        Stack<Character> S = new Stack<Character>();
        for(int a = 0; a < check.length(); a++)
        {
            char let = check.charAt(a);
            if(let == '[' || let == '{' || let == '(')
                S.push(let);
            else if(let == ']' || let == '}' || let == ')')
            {
                if(S.empty())
                    return false;
                switch(let)
                {
                    // Opening square brace
                    case ']':
                        if (S.pop() != '[')
                            return false;
                        break;
                    // Opening curly brace
                    case '}':
                        if (S.pop() != '{')
                            return false;
                        break;
                    // Opening paren brace
                    case ')':
                        if (S.pop() != '(')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        if(S.empty())
            return true;
        return false;
    }
}
