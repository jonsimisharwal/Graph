import java.util.*;
class Pair{
    String word;
    int num;
    public Pair(String word,int num){
        this.word=word;
        this.num=num;
    }
}
class WordladderI {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String > ll=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            ll.add(wordList.get(i));
        }
        ll.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().word;
            int steps=q.peek().num;
            q.remove();
            if(word.equals(endWord)==true){ return steps;}
        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char Stringreplaceword[]=word.toCharArray();
                Stringreplaceword[i]=ch;
                String replaceword=new String(Stringreplaceword);
                if(ll.contains(replaceword)==true){
                    ll.remove(replaceword);
                    q.add(new Pair(replaceword,steps+1));
                }
            }
        }
        }
        return 0;
    }
    public static void main(String args[]){
        String beginword="hit";
        String endword="cog";
        List<String> WordList=new ArrayList<>();
        WordList.add("hot");
        WordList.add("dot");
        WordList.add("dog");
        WordList.add("lot");
        WordList.add("log");
        WordList.add("cog");
        int ans=ladderLength(beginword,endword,WordList);
        System.out.println("ans is:"+ ans);

    }
}