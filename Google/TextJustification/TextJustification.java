package TextJustification;
/*
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left-justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
*/


/*
Algorithm:
  Start with the left being the first word
  findRight: try to go as far right as possible until we fill maxWidth
  justify: in all cases, pad the right side with spaces until we reach max width for the line
    1. if it's one word, the result is just that word
    2. if it's the last line, the result is all words separated by a single space
    3. Otherwise, calculate the size of each space evenly and if there's a remainder,
    distribute an extra space until it is gone

*/

import java.util.*;
public class TextJustification {
  //find the right index
    private static int findRight(int left, String[] words, int maxWidth){
      int right=left;
      return right;
    }
    private static String justify(int left, int right, String[] words, int maxWidth){

    }
    private static int wordsLength(int left, int right, String[] words){
      int wordLength=0;
      return wordLength;

    }
    private static String padResult(String result, int maxWidth){
      
    }
    private static String blank(int length){

    }
    public static void main(String args[]){
      String[] words=new String[]{"This", "is", "an", "example", "of", "text", "justification."};
      int maxWidth=16;
      int left=0;
      List<String> result=new ArrayList<>();
      while(left<words.length){
        int right=findRight(left, words, maxWidth);
        result.add(justify(left, right, words, maxWidth));
        left=right+1;
      }
      
  }
    
}
