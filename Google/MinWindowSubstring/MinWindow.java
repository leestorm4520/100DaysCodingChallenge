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
        int left=0, right=s.length()-1;

        System.out.println(minWindow(left, right, s, t));
    }
    //store character and its frequency into a hashmap
    public static HashMap<Character, Integer> storeChar(String t){
        HashMap<Character, Integer> hashChar=new HashMap<Character, Integer>();
        for(char c: t.toCharArray()){
            if(checkExist(hashChar)) hashChar.put(c,1);
        }

    }
    //update the value of character frequency whenever the pointer is moved
    public static boolean updateHash(HashMap<Character, Interger> hashChar, int left, int right, String s, char c){
        if(hashChar.containsKey) return true;
        else return false;
    }
    //possibly recursively go through the bigger string to check for the characters
    public static String minWindow(int left, int right, String s, String t){

    }
    
}
