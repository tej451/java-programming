package com.programmingques;

public class HourGlass {

    public static void main(String[] args) {
       // Scanner sc = new Scanner(System.in);
        int[][] numArray = {{1,1,1,0,0,0}, {0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,1,2,4,0}};
        int largestSum = 0;
        /*int largestSum = 0;
        for(int i=0; i<6; i++){
            numArray[i]=sc.nextLine().split(" ");
        }*/
        
        for(int i=0;i<=3;i++){
            for(int j=0;j<=3;j++){
                int sum = numArray[i][j]+numArray[i][j+1]+numArray[i][j+2]+numArray[i+1][j+1]+numArray[i+2][j]+numArray[i+2][j+1]+numArray[i+2][j+2];
                if(i==0 && j==0){
                    largestSum=sum;
                }else{
                    if(sum>largestSum){
                        largestSum=sum;
                    }
                }
            }
        }
        System.out.println(largestSum);
    }
}
