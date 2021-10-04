package preparation.tree;

public class Test53Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("the");
        trie.insert("though");
        trie.insert("there");
        System.out.println(trie.search("the"));
        System.out.println(trie.search("ther"));
        System.out.println(trie.search("there"));
    }
}


//think like a tree...trie will have root..root will have n childern...each children will have n more children
class Trie{
    Node root;

    Trie(){
        this.root = new Node();
    }

    public void insert(String word) {
        Node crawl = root;
        for(int i=0;i<word.length();i++){
            Node indexNode = crawl.children[word.charAt(i)-'a'];
            if(indexNode==null){
                indexNode = new Node();
                indexNode.content=word.charAt(i)+"";
                crawl.children[word.charAt(i)-'a'] = indexNode;
            }
            crawl = indexNode;
        }
        crawl.endOfWord = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for(int i =0;i<word.length();i++){
            Node tempNode = curr.children[word.charAt(i)-'a'];
            if(tempNode==null){
                return false;
            }else{
                curr = tempNode;
            }
        }

        if(curr.endOfWord==false)
            return false;

        return true;
    }
}

class Node{
    Node[] children;
    String content;
    boolean endOfWord;

    Node(){
        this.content = null;
        this.endOfWord = false;
        this.children = new Node[26];
        for(int i=0;i<children.length;i++){
            this.children[i] = null;
        }
    }

}

