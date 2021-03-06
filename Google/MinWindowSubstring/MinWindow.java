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

    public static String minWindow(String s, String t){
        //create a dictionary using array
        int[] arr_char=new int[128];
        for(char c: t.toCharArray()) arr_char[c]++; //character and its corresponding frequency in the string s

        int left=0, right=0, minStart=0, counter= t.length(), minLength=Integer.MAX_VALUE;
        /*
         * Create two pointers to keep track of the beginning and the ending of the minimum string
         * Start at the right: if the value is more than zero, that means the character at the right pointer is in the smaller string --> decrement the counter
         * Decrement the value of the character
         * Increment the right pointer
         * 
         * if the counter==0, which means all the characters of the smaller substring already present
         * --> time to compare the length of the substring (Copmpare right-left < minLength)
         * Start at the left: increment the value of the character
         * If the value of the character is more than 0, that means the character at the left pointer is in the smaller string --> increment the counter
         * increment the left pointer
         */
        while(right<s.length()){
            char c1=s.charAt(right);
            if(arr_char[c1]>0) counter--;
            arr_char[c1]--;
            right++;

            while(counter==0){
                if((right-left) < minLength){
                    minLength=right-left;
                    minStart=left;
                }

                char c2=s.charAt(left);
                arr_char[c2]++;
                if(arr_char[c2]>0) counter++;
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE? "" : s.substring(minStart, minStart+minLength);
    }
    
}
