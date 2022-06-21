package MinWindowSubstring;

/*
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
/*
 * Algorithm (Brute Force Possibly)
 * 1. Store all the character in a HashMap (characters as key and frequency to which the character appears as value) for checking
 * 2. Create 2 positional indexes (left and right) - window that has length S
 */
import java.util.*;
public class MinWindow {

    public static void main(String args[]){
        String s="ADOBECODEBANC";
        String t="ABC";

        System.out.println(minWindow(s, t));
    }
    //store character and its frequency into a hashmap
    public static HashMap<Character, Integer> storeChar(String t){
        HashMap<Character, Integer> hashChar=new HashMap<Character, Integer>();
        for(char c: t.toCharArray()){
            if(!hashChar.containsKey(c)) hashChar.put(c,1);
            else hashChar.put(c, hashChar.get(c)+1);
        }
        return hashChar;
    }

    //check if th

    //update the value of character frequency whenever the pointer is moved
    public static void updateHash(HashMap<Character, Interger> hashChar, int left, int right, String s){
        for(int i=left; i<right;i++){
            char c=s.charAt(i);
            if(hashChar.containsKey(c)) hashChar.put(c, hashChar.get(c)+1);
        }     
    }

    //possibly recursively go through the bigger string to check for the characters
    public static String minWindow(String s, String t){
        int left=0, right=s.length()-1;        
        HashMap<Character, Integer> hashChar= storeChar(t);

        int start=0, end=0;
        char[] s_arr= s.toCharArray();
        String result= new String();
        for(int i=0;i<s.length();i++){
            if(!hashChar.containsKey(s_arr[left])){
                left++;
                updateHash(hashChar, 0, left-1, s);
            }
            else if(!hashChar.containsKey(s_arr[right])){
                right--;
                updateHash(hashChar, right+1, s.length()-1, s);
            }
            else{
                
            }

            if((right-left) < t.length()){
                result="";
                break;
            }
            //subtract the frequency
        }


        return result;
    }
    
}
