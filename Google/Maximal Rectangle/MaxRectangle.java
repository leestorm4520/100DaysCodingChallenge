/*
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Input: matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [['0']]
Output: 0
Example 3:

Input: matrix = [['1']]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
 */

 /*
  * Brainstorming the algorithm

  using a while loop to check all the square
  with a maxArea variable to check whether it's a 1 or not

  if it's a 1, then grow the square. There are 4 sides on the square, so grow forth. 
  Would not grow into squares already counted

  if it's a 0, then skip it
  */
  import java.util.*;
public class MaxRectangle {
    public static void main(String args[]){
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
        int num=2;
        System.out.println((num<<1)+1);
  
    }
    static int maximalRectangle(char[][] matrix){
        if(matrix==null || matrix.length==0 || matrix[0]==null) return 0;
       int m=matrix.length, n=matrix[0].length, maxArea=0;
       int[] left=new int[n];
       int[] right=new int[n];
       int[] height=new int[n];
       Arrays.fill(left,0); Arrays.fill(right, n); Arrays.fill(height, 0);
        
       for(int i=0;i<m;i++){
        int curLeft=0, curRight=n;
        //compute height
        for(int j=0;j<n;j++){
            if(matrix[i][j]=='1') height[j]++;
            else height[j]=0;
        }
        //compute left( from left to right)
        for(int j=0;j<n;j++){
            if(matrix[i][j]=='1') left[j]=Math.max(left[j], curLeft );
            else{ 
                left[j]=0; 
                curLeft=j+1;
            }
        }
        //compute right(from right to left)
        for(int j=n-1; j>=0;j--){
            if(matrix[i][j]=='1') right[j]=Math.min(right[j], curRight);
            else{
                right[j]=n;
                curRight=j;
            }   
        }
        //compute the area of the rectangle
        for(int j=0;j<n;j++) maxArea=Math.max(maxArea, (right[j]-left[j])*height[j]);

       }

        return maxArea;
    }
}
