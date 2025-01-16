import java.util.*;
class Disjointset{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public Disjointset(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int FindUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp=FindUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void UnionByRank(int u,int v){
        int ulp_u=FindUPar(u);
        int ulp_v=FindUPar(v);
        if(ulp_u ==ulp_v){
            return;
        }
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
    public void UnionBySize(int u,int v){
        int ulp_u=FindUPar(u);
        int ulp_v=FindUPar(v);
        if(ulp_u == ulp_v){
            return;
        }
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
    }
}
    class Solution{
    public static void main(String args[]){
        Disjointset ds = new Disjointset(7);
        ds.UnionByRank(1, 2);
        ds.UnionByRank(2, 3);
        ds.UnionByRank(4, 5);
        ds.UnionByRank(6, 7);
        ds.UnionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.FindUPar(3) == ds.FindUPar(7)) {
            System.out.println("Same");
        } else{
            System.out.println("Not Same");
        }
        ds.UnionBySize(3, 7);
        if (ds.FindUPar(3) == ds.FindUPar(7)) {
            System.out.println("Same");
        } else{
            System.out.println("Not Same");
        }
    }
}