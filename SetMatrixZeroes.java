// brute force approach

// import java.util.*;
// public class SetMatrixZeroes{
//     public static void markrow(ArrayList<ArrayList<Integer>> matrix, int n , int m , int i){
//         for(int j=0;j<m;j++){
//             if(matrix.get(i).get(j)!=0){
//                 matrix.get(i).set(j,-1);
//             }

//         }

//     }

//      public static void markcolumn(ArrayList<ArrayList<Integer>> matrix, int n , int m , int j){
//        for(int i=0;i<n;i++){
//         if(matrix.get(i).get(j)!=0){
//             matrix.get(i).set(j,-1);
//         }
//        } 
//     }

//    public static ArrayList<ArrayList<Integer>> ZeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n , int m){
//  for(int i=0;i<n;i++){
//     for(int  j=0;j<m;j++){
//         if(matrix.get(i).get(j)==0){
//             markrow(matrix,  n ,  m , i);
//             markcolumn(matrix,  n,  m , j);
//         }
//     }
//  }
// // mark all -1 to 0
//  for(int i =0;i<n;i++){
//     for(int j=0;j<m;j++){
//         if(matrix.get(i).get(j)==-1){
//             matrix.get(i).set(j,0);
//         }
//     }
//  }
//  return matrix;

//     }
//     public static void main(String[] args){
//         ArrayList<ArrayList<Integer>> matrix= new ArrayList<>();
//          matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
//          matrix.add(new ArrayList<>(Arrays.asList(1,0,1)));
//          matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
//           int n=matrix.size();
//           int m =matrix.get(0).size();
//           ArrayList<ArrayList<Integer>> ans=ZeroMatrix(matrix,  n ,  m);
//           System.out.println("the output of matrix is ");
//           for(ArrayList<Integer> row : ans){
//             for(Integer elem: row){
//                 System.out.print(elem+" ");
//             }
//             System.out.println();
//           }

//     }
    
// }

// optimal approach , time complexity=O(m*n) , space complexity =O(1)

import java.util.*;
public class SetMatrixZeroes{
     public static void setZeroes(int[][] matrix){
         int m=matrix.length;
         int n=matrix[0].length;
         boolean firstRowZero=false;
         boolean firstColZero=false;
        //  check first row is affected or not 
         for (int col=0;col<n;col++){
            if(matrix[0][col]==0){
                firstRowZero=true;
                break;
            }
         }
        //  check first col is affected or not
         for (int row=0;row<m;row++){
            if(matrix[row][0]==0){
                firstColZero=true;
                break;
            }
         }

          for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
          }

           for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0|| matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
           }
            if(firstRowZero){
                for(int i=0;i<n;i++){
                    matrix[0][i]=0;
                }
            }
             if(firstColZero){
                for(int j=0;j<m;j++){
                    matrix[j][0]=0;
                }
             }

     }

     public static void printmatrix(int[][] matrix){
         for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
         }
     }
    public static void main(String[] args){
        // int[][] matrix= new int[m][n];
        int[][] matrix={
            {1,1,1},{1,0,1},{1,1,1}
        };
           
           setZeroes(matrix);
           printmatrix(matrix);
         
    }
}