// Last updated: 8/8/2026, 4:02:22 PM
1class WordDictionary {
2    private WordDictionary[] children;
3    boolean isEndOfWord;
4    // Initialize your data structure here. 
5    public WordDictionary() {
6        children = new WordDictionary[26];
7        isEndOfWord = false;
8    }
9    
10    // Adds a word into the data structure. 
11    public void addWord(String word) {
12        WordDictionary curr = this;
13        for(char c: word.toCharArray()){
14            if(curr.children[c - 'a'] == null)
15                curr.children[c - 'a'] = new WordDictionary();
16            curr = curr.children[c - 'a'];
17        }
18        curr.isEndOfWord = true;
19    }
20    
21    // Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. 
22    public boolean search(String word) {
23        WordDictionary curr = this;
24        for(int i = 0; i < word.length(); ++i){
25            char c = word.charAt(i);
26            if(c == '.'){
27                for(WordDictionary ch: curr.children)
28                    if(ch != null && ch.search(word.substring(i+1))) return true;
29                return false;
30            }
31            if(curr.children[c - 'a'] == null) return false;
32            curr = curr.children[c - 'a'];
33        }
34        return curr != null && curr.isEndOfWord;
35    }
36}