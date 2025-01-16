// Problem Statement (Course Schedule): There are a total of n tasks you have to pick,
// labeled from 0 to n-1. Some tasks may have prerequisites tasks, for example, to pick
 // task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
import java.util.*;

class CoursescheduleI{
    public static int[] Courseschedule(int n,int m,ArrayList<ArrayList<Integer>> prerequisites){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }
        int indegree[]=new int[n];
        for(int i=0;i<n;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        int topo[]=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int index=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo[index++]=node;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                   q.add(it);
                }
            }
            if (index == n){ return topo;
            }
        }
       
        
        int[] arr = {};
        return arr;

    }
    public static void main(String args[]){
         int n=4;
         int m=3;
         ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
         for(int i=0;i<n;i++){
            arr.add(i,new ArrayList<>());
         }
         arr.get(0).add(0);
         arr.get(0).add(1);
 
         arr.get(1).add(1);
         arr.get(1).add(2);
 
         arr.get(2).add(2);
         arr.get(2).add(3);
         int ans[]=Courseschedule(n, m, arr);
         for(int task:ans){
            System.out.print(task +" ");
         }
         System.out.println();
    }
}