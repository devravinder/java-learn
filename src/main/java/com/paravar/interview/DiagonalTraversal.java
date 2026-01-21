package com.paravar.interview;

public class DiagonalTraversal {
    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

//        printDiagonals(matrix);

        printZigZagIndices(3);
    }

    public static void printZigZagIndices(int matixSize){

        System.out.println("matixSize="+matixSize);

        int maxSum = matixSize+1;

        int sum=0;

        int col=0, row=0;

        int nextCol, nextRow = 0;

        boolean up=true;

        while (sum<=maxSum){

            System.out.println("("+col+","+ row+")");

            if(up){
                 nextCol = col+1;
                 nextRow = row-1;
            }else {
                nextCol = col-1;
                nextRow = row+1;
            }

            if(nextCol<0 || nextRow<0 || nextCol==matixSize || nextRow==matixSize){
                if(nextCol<0)
                    nextCol=0;
                if(nextRow<0)
                    nextRow=0;
                if(nextCol==matixSize)
                    nextCol=matixSize-1;
                if(nextRow==matixSize)
                    nextRow=matixSize-1;

                up=!up;
                sum++;

                // for the second of from the main diagonal
                if (sum!=nextRow+nextCol){
                    if(up){
                        nextRow=row;
                        nextCol=col+1;
                    }else{
                       nextCol=col;
                       nextRow=row+1;
                    }
                }
            }

            col = nextCol;
            row = nextRow;

        }

    }
}
