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
public class TextJustify {
   //main function
    /*
     * left is the starting index counting while array "words" still has words
     * 1st: find the right index is <= "maxWidth"
     * 2nd: add the phrases to the arraylist "result"
     * increment left by right+1 (since the words stop at the right index every iteration)
     */
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
    for(String line: result){
      System.out.println(line);
    }
    
}
  //find the right index by adding the next word length until it exceeds the maxWidth
    private static int findRight(int left, String[] words, int maxWidth){
      int right=left;
      //start the sum by adding the length of the next word in the "words" array: sum= words[left+1].length()
      int sum=words[right++].length();

      //condition: right index is less than the total length of "words" array and the sum accumulated + 1 (for the space) + the length of the next word
      while(right<words.length && (sum+1+words[right].length())<=maxWidth){
        sum+=1+words[right++].length();
      }
      //because, in order to compare the word length, we increment right in advance so we decrement before returning back to the main function
      return right-1;
    }
    private static String justify(int left, int right, String[] words, int maxWidth){
      if(right-left==0) return padResult(words[left], maxWidth); //if there's no words, the phrase is just the space

      boolean isLastLine=right==words.length-1; //check if it's the last word in the array
      int numSpaces=right-left; //find number of words on each line
      int totalSpace=maxWidth-wordsLength(left, right, words);
      //find how many spaces needed

      String space=""; int remainder=0;
      if(isLastLine){ 
        space=" ";
        remainder=0;
      }
      else{ 
        space=blank(totalSpace/numSpaces); //how much spaces between each word
        remainder=totalSpace%numSpaces; //how much spaces between the 2rd last and the last
      }

      StringBuilder result=new StringBuilder();
      for(int i=left; i<=right;i++){
        result.append(words[i]).append(space).append(remainder-- > 0 ? " ":"");
        //words[i] + space (needed between each words) + (decrement remainder in each iteration - if remainder>0, then add " ", else "")
      }
      return padResult(result.toString().trim(), maxWidth);
    }
    private static int wordsLength(int left, int right, String[] words){
      int wordsLength=0;
      for(int i=0; i<=right;i++) wordsLength+=words[i].length();
      //find the length of each line
      return wordsLength;

    }
    private static String padResult(String result, int maxWidth){
      return result+blank(maxWidth-result.length());
      //add the string with additional spaces
    }
    private static String blank(int length){
      String blank="";
      for(int i=0;i<length;i++) blank+=" ";
      return blank;
      
    }

   
    
}
