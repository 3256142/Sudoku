public class Sudoku {


    static void displayBoard(String boardString){
        String[] boardRows = {"", "", "", "", "", "", "", "", ""};
        char[] boardArray = boardString.toCharArray();
        for(int index = 0; index < boardString.length(); index ++ ){
            boardRows[index/9] = boardRows[index/9] + " " + boardArray[index];
            if(index % 9 == 2 || index % 9 == 5){
                boardRows[index/9] = boardRows[index/9] + " |";
            }
        }
        System.out.println("-------------------------");
        for(int index = 0; index < 9; index ++ ){
            System.out.println("|" + boardRows[index] + " |");
            if(index == 2 || index == 5){
                System.out.println("-------------------------");
            }
        }
        System.out.println("-------------------------");
    } 

    private int [][] board;
    public static final int EMPTY =0;
    public static final int SIZE = 9;
    
    
    public Sudoku (int [][] board){
        this.board = new int [SIZE][SIZE];
            for (int i=0; i < SIZE; i ++){
                for (int j =0; j<SIZE; J++){
                    this.board[i][j] = board[i][j];

                }

            }


    }
    
    private boolean isInRow (int row, int number){
        for (int i =0 ; i < SIZE ; i ++){
            if(board[row][i]==number)
            return true;

        
        return false;
        }
    }

    private boolean isInCol (int col, int number){
        for (int i =0 ; i < SIZE ; i ++){
            if(board[i][col]==number)
            return true;

        
        return false;
        }
    }

   
    private boolean isInBox (int row, int col, int number){
        int r = row -row %3;
        int c = col - col%3;


        for (int i =r ; i < r ; i ++)
        for (int j =c; j < c; j++)
            if(board[i][j]==number)
            return true;

        
        return false;
        }
    
        private boolean isOK(int row, int col, int number){
            return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
        }
 

    public boolean solveV2(){
        for(int row=0 ; row<SIZE ; row++){
            for (int col =0 ; col < SIZE; col++){
                if(board[row][col] == EMPTY) {
                    for (number =1; number <=SIZE; number ++){
                        if (isOK(row, col, number)){
                            board[row][col] = number;
                            if (solveV2()){
                                return true;
                            }
                            else {
                                board[row][col] = EMPTY;
                            }
                        }
                        
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static String solve(String boardString){
        displayBoard(boardString);
        return "";
    }


    

    public static void main(String[] args) {
        // Easy Mode
        String solution = solve("105802000090076405200400819019007306762083090000061050007600030430020501600308900");
        System.out.println(solution.equals("145892673893176425276435819519247386762583194384961752957614238438729561621358947"));

        // // Hard Mode
        // String solution = solve("400000805030000000000700000020000060000080400000010000000603070500200000104000000");
        // System.out.println(solution.equals("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));


    }
}