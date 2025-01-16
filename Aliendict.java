import java.util.*;

class Aliendict{
    public static List<Integer> Toposort(int k,List<List<Integer>> adj){
        int indegree[]=new int[k];
        for(int i=0;i<k;i++){
            for(int node:adj.get(i)){
                indegree[node]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return topo;
    }
    public static String findorder(String[] dict,int n,int k){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<k;i++){
          adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            String s1=dict[i];
            String s2=dict[i+1];
            int len=Math.min(s1.length(),s2.length());
            for(int ptr=0;ptr<len;ptr++){
                if(s1.charAt(ptr)!=s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }
            }
        }
        List<Integer> topo=Toposort(k,adj);
        String ans="";
        for(int it:topo){
            ans=ans+(char)(it+ (int)('a'));
        }
        return ans;
    }
    public static void main(String args[]){
      String dict[]={"baa", "abcd", "abca", "cab", "cad"};
      int n=5;
      int k=4;
      String ans = findorder(dict, n, k);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }
}