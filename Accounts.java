import java.time.temporal.TemporalAccessor;
import java.util.*;

class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    List<Integer> size= new ArrayList<>();
    public DisjointSet(int n){
      for(int i=0;i<n;i++){
        rank.add(0);
        parent.add(i);
        size.add(1);
      }
    }
    public int findUPar(int node){
        if(node ==parent.get(node)){
            return node ;
        }
        int ulp=findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);

    }
    public void unionByRank(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u ==ulp_v){
            return;
        }
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }else{
            parent.set(ulp_v,ulp_u);
            int rankU=rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
    public void unionBySize(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v){
           return ;
        }
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Accounts{
    public static List<List<String>> Accountsmerge(List<List<String>> Details){
        int n=Details.size();
        DisjointSet ds=new DisjointSet(n);
       HashMap<String,Integer> mapnode=new HashMap<>();
       for(int i=0;i<n;i++){
        for(int j=0;j<Details.get(i).size();j++){
            String mail=Details.get(i).get(j);
            if(mapnode.containsKey(mail)==false){
                mapnode.put(mail,i);
            }else{
                ds.unionBySize(i, mapnode.get(mail));
            }
        }
       }
      ArrayList<String>[] mergedmail =new ArrayList[n];
      for(int i=0;i<n;i++){
        mergedmail[i]=new ArrayList<>();
      }
      for(Map.Entry<String,Integer> it: mapnode.entrySet()){
        String mail=it.getKey();
        int node=ds.findUPar(it.getValue());
        mergedmail[node].add(mail);

      }
      List<List<String>> ans=new ArrayList<>();
      for(int i=0;i<n;i++){
        if(mergedmail[i].size()==0){ continue;}
        List<String> temp=new ArrayList<>();
        temp.add(Details.get(i).get(0));
        for(String st:mergedmail[i]){
            temp.add(st);
        }
        ans.add(temp);
      }
      return ans;
    }
    public static void main(String args[]){
        List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };
        List<List<String>> ans = Accountsmerge(accounts);
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }

            System.out.println("");
    }
}}