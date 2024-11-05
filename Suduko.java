package Recursion;

public class Suduko {
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solve(board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }

    static boolean solve(int [][] board){
        //check for empty space
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(board[i][j]==0){
                    for(int val=1;val<=9;val++){
                        if (isSafe(board,i,j,val)){
                            board[i][j]=val;
                            //recursive call to check if solution is possible ahead
                            boolean solution=solve(board);
//                            recursion will unwind, returning true all the way up the call stack to indicate success.
                            if(solution)
                                return true;
                            else
                                board[i][j]=0;
                        }
                    }
                    //if none is possible from values 1-9 in a particular row;
                    return false;
                }
            }
        }
        //if no empty spaces are left , after this all the recursion call will return true all the way up to the stack
        return  true;
    }

    static boolean isSafe(int[][] board ,int row,int col, int a){
        //checking for row
        for(int i=0;i<board.length;i++){
            if(board[i][col]==a)return false;
        }

        //checking for col
        for(int j=0;j<board[0].length;j++){
            if(board[row][j]==a)return false;
        }

        //for a board
        // % 3 cos 3 is actually sqrt of board.length , 3*3=9
        int x=row -(row%3);
        int y=col- (col%3);
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(board[i][j]==a)return false;
            }
        }
        return  true;
    }


    static void printBoard(int[][] board) {
        for (int j=0;j<board[0].length-1;j++){
            System.out.print("-- ");
        }
        System.out.println();
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if(j%3==0) System.out.print("| ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
            if((i+1)%3==0){

                for (int j=0;j<board[0].length-1;j++){
                    System.out.print("-- ");
                }
                System.out.println();
            }
        }
    }


}
