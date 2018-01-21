package com.programmingques;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class MinCost {

	public static int[][] steps=null;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        steps=new int[N][N];
        char[][] board=new char[N][N];
        for(int i=0; i<N; i++) {
            String s=sc.next();
            board[i]=s.toCharArray();
            Arrays.fill(steps[i], -1);
        }
        int a=sc.nextInt(), b=sc.nextInt(), c=sc.nextInt(), d=sc.nextInt();
        System.out.println(getSteps(board, a, b, c, d));
    }
    public static int getSteps(char[][] board, int a, int b, int c, int d) {
        // a,b  --> c,d
        Queue<MinCost.D> que=new java.util.LinkedList<>();
        Queue<MinCost.D> nextlevel;
        que.offer(new D(c, d));
        int s=0, n=board.length;
        while(!que.isEmpty()) {
            nextlevel=new java.util.LinkedList<>();
            while(!que.isEmpty()) {
                D cur=que.poll();
                int x=cur.x, y=cur.y;
                if(a==x && b==y)
                    return s;
                steps[x][y]=s;
                for(int j=y-1; j>=0; j--) { //left
                    if(board[x][j]=='X')
                        break;
                    nextlevel.offer(new D(x, j));
                    board[x][j]='X';
                }
                for(int j=y+1; j<n; j++) { //right
                    if(board[x][j]=='X')
                        break;
                    nextlevel.offer(new D(x, j));
                    board[x][j]='X';
                }
                for(int i=x-1; i>=0; i--) { //up
                    if(board[i][y]=='X')
                        break;
                    nextlevel.offer(new D(i, y));
                    board[i][y]='X';
                }
                for(int i=x+1; i<n; i++) {
                    if(board[i][y]=='X')
                        break;
                    nextlevel.offer(new D(i, y));
                    board[i][y]='X';
                }
            }
            s+=1;
            que=nextlevel;
        }
        return s;
    }
static class D{
    int x;
    int y;
    public D(int x, int y) {
        this.x=x; 
        this.y=y;
    }
}
}
