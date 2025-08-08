class TrieNode{
    boolean isEnd;
    TrieNode[] children;

    TrieNode(){
        this.isEnd = false;
        this.children = new TrieNode[26];
        
        for(int i=0;i<26;i++){
            this.children[i] = null;
        }
    }
}

public class Trie{
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        insert(root, "apple");
        insert(root, "app");

        System.out.println(search(root, "apple"));
        System.out.println(search(root, "app"));
    }

    static void insert(TrieNode root, String word){
        TrieNode crawl = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(crawl.children[idx] == null){
                crawl.children[idx] = new TrieNode();
            }
            crawl = crawl.children[idx];
        }

        crawl.isEnd = true;
    }

    static boolean search(TrieNode root, String word){
        TrieNode crawler = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(crawler.children[idx] == null){
                return false;
            }
            crawler = crawler.children[idx];
        }

        return crawler.isEnd == true;
    }
}