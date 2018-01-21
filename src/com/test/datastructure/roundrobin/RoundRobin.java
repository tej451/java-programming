package com.test.datastructure.roundrobin;

import java.util.ArrayList;
import java.util.List;

public class RoundRobin {
    
    int [] temp;
    int [] tempWaitinTime;
    int commBT, k, tq; // commBT total cpu execution for all process, k is the current cpu execution, tq is quantum
    int[][] d;
    int btcache;
    
    void start( ){
        for (int i = 0; i < d.length; i++) {
            int bt  = d[i][1]; //  cpu executed per process
            if( bt > 0){
                if( bt <= tq){
                    temp[i] = btcache+bt;
                    btcache = temp[i];
                    k += bt;
                    bt -= bt;
                    
                }
                else{
                    temp[i] = btcache+tq;
                    btcache = temp[i];
                    bt -= tq;
                    k += tq;
                }
                
                d[i][1] = bt;
                
            }
        }
        if( k!= commBT) // all cpu has not been executed
        start();
    }
    
    private void display(List<Job> jobList) {
        float avgTurnArroundTime = 0;
        float avgWaitigTime = 0;
        int c = 1;
        System.out.println("============================================ ");
        System.out.println("Process ID | Turnaround time | Waiting time ");
        System.out.println("============================================ ");
        Object[] job = jobList.toArray();
        for (int i : temp) {
            Job job1 = (Job) job[c-1];
            System.out.println( "    " + c + "       |     " + i +"           |   "+(i-job1.getCpuTime()));
            System.out.println("----------------------------------------");
            avgTurnArroundTime += i;
            avgWaitigTime += (i-job1.getCpuTime());
            c++;
        }
        System.out.println("===============================================");
        System.out.println( "Avg waiting time = " + avgWaitigTime/temp.length);
        System.out.println("===============================================");
        System.out.println( "Avg turn round time = " + avgTurnArroundTime/temp.length);
        System.out.println("===============================================");
    }
    public void run(List<Job> jobList, int quantum) {
        
        int pcount = jobList.size();
        d = new int[pcount][2];
        
        temp = new int[pcount];
        int count = 0;
        for(Job job:jobList){
            d[count][0] = count;
            
            int m = job.getCpuTime();
            d[count][1] = m;
            
            commBT += m;
            count++;
        }
        
        tq = quantum;
        start();
        display(jobList);
        
    }
}

/* implement this class for all three strategies */

abstract class AllocationStrategy {
    protected List<Job> Jobs;
    protected ArrayList<Job> Queue;
    
    public AllocationStrategy(List<Job> jobs) {
        super();
        Jobs = jobs;
    }
    
    public abstract void run();
    // update current job by 1 tick
    // check if the job queue might need to be changed.
    // check for jobs to add to the queue
}

interface JobFinishEvent {
    public void onFinish(Job j);
}





