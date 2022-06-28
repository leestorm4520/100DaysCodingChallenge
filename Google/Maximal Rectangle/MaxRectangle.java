/*
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
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
public class MaxRectangle {
    static void main(String args[]){
        char[][] matrix = {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};

    }
    static int findArea(char[][] matrix, int x, int y)
{
   
    int area=0;

    return area;

}
    static boolean checkRectangle(char[] matrix, int x, int y){
        

        return true;
    }
    static int maximalRectangle(char[][] matrix, int x, int y){
        if(matrix==null) return 0;
        int maxArea=0;

        if(matrix[x][y]=='0'){
            if(y<matrix[0].length) maximalRectangle(matrix, x, y+1);
            if(x<matrix.length) maximalRectangle(matrix, x+1, 0);
        }
        else{
            if(maxArea<findArea(matrix, x, y)){
                maxArea=findArea(matrix, x, y);
                
            }
        }
        return maxArea;
    }
}
