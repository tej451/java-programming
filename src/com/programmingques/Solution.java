package com.programmingques;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    static Stack<Integer> aStack = new Stack<Integer>();
    static Stack<Integer> bStack = new Stack<Integer>();

    static int printDays(Stack aStack){
        int objectsRemoved=-1;
        int countLoops=0;

        while(objectsRemoved!=0) {

            objectsRemoved=0;

            int prevValue=0;
            int curValue=0;

            while(!aStack.isEmpty()) {

                curValue = (int)aStack.pop();

                   if(!aStack.isEmpty()){
                        int tempValue = (int)aStack.pop();
                        if(curValue<=tempValue){
                            bStack.push(curValue);
                        }
                        else{
                            objectsRemoved++;
                            //System.out.println("Removed " + curValue);
                        }
                        aStack.push(tempValue);
                   }
                   else{
                       bStack.push(curValue);
                   }

            }


            while(!bStack.isEmpty()) {
                aStack.push(bStack.pop());
            }

         if(objectsRemoved!=0){
             countLoops++;
         }

        }

        return countLoops;
    }
    
    static int simulateDays(final int[] plants){
        if (plants.length <= 1) return 0;
        int plantSize = plants.length, days = 0, i, lastDying = 1;
        while (true) {      // simulate as many days as needed
            // Search for first plant to die today
            for (i = lastDying; i < plantSize; ++i) {
                if (plants[i-1] < plants[i]) break;
            }
            if (i == plantSize) return days;  // no plant found to be dying
            lastDying = i;      // optimize the initial search next day
            int removed = 1;    // the one found (plants[i]) will die
            // Now search remaining plants for any other dying today and also remove all of them
            for (++i; i < plantSize; ++i) {
                if (plants[i-1] < plants[i]) {  // plant[i] dies, count+skip it.
                    ++removed;
                } else {                        // plant[i] survives, move it to last living one
                    plants[i-removed] = plants[i];
                }
            }
            plantSize -= removed;               // adjust total number of remaining plants
            ++days;                             // let's see another day
        }
    }
    
    private static int numberDaysNoD(List<Integer> arr){
        int nDays = 0;
        boolean haveKilled = true;
        while(haveKilled){
            haveKilled = false;
            for(int i = arr.size()-1; i>0; i--){
                if(arr.get(i)>arr.get(i-1)){
                    arr.remove(i);
                    haveKilled = true;
                }
            }
            nDays++;
        }
        return (nDays-1);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       // Scanner in = new Scanner(System.in);
        
       // int t = in.nextInt();
        int[] plants = {23,12,5,6,90};
        List arr = (ArrayList) Arrays.asList(plants);
        /*for(int a0 = 0; a0 < t; a0++){
        	int input = in.nextInt();
            aStack.push(input);
            plants[a0] = input;
            arr.add(input);
        }*/

        System.out.println(printDays(aStack));
        System.out.println(simulateDays(plants));
        System.out.println(numberDaysNoD(arr));
    }
}
