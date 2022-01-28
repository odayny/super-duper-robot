"""
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.
"""
# recursively delegate adding and search to corresponding sub-tries
class WordDictionary:
    offset = ord('a')
    
    def __init__(self):
        self.end = False
        self.child = [None]*26  

    # time O(n): we're going on a single branch for any giver word
    # space O(n): because of recursion. may be improved uisng pointers
    def addWord(self, word: str) -> None:
        # end of the word
        if not word :
            self.end = True
            return
        
        # trie
        ch = word[0] 
        pos = ord(ch) - self.offset
        if self.child[pos] == None :
            self.child[pos] = WordDictionary()
        self.child[pos].addWord(word[1:])
        
    # time from O(n) to O(26^n) depends on query
    # space O(n): because of recursion. may be improved uisng pointers but not for '.'
    def search(self, word: str) -> bool:
        if not word :
            return self.end
        
        ch = word[0]
        if ch == '.' :
            for c in self.child :
                if c != None and c.search(word[1:]) :
                    return True
            return False
        else :            
            pos = ord(ch) - self.offset
            return self.child[pos] != None and self.child[pos].search(word[1:])
        

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
