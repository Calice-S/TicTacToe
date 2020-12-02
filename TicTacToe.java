import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

  public static char player;
  public static int newMove;
  public static void main(String[] args) {
    // declare 2d char array 
    char[][] board = new char[3][3];
     // initialize board
    for(int r = 0; r < board.length; r++){
      for(int c = 0; c < board[r].length; c++){
           board[r][c] = ' ';
        }
    }
    gameBoard(board);
          /* call methods for user & computer in a while loop for gameplay only breaking
           when either wins or both draw */
    while(true){
      userMove(board);
    if(checkRowWin(board)){
       break;
      }
      cpuMove(board);
    if(checkRowWin(board)){
      break;
      } 

      }
   }

   /**
    * print board using nested for loop
    * @param board
    */   
  public static void gameBoard(char[][] board){
    System.out.println("Welcome to the game of Tic Tac Toe");
    System.out.println();
    for(int r = 0; r < board.length; r++){
        System.out.print(" ");
        System.out.print("|");
        for(int c = 0; c < board[r].length; c++){
            System.out.print(" ");
            System.out.print(board[r][c] + " |");
        }
            System.out.println();
            System.out.println("-----+---+-----");

      }
}
/**
 * Get user input, validate user moves,place user move on the board 
 * @param board
 */
public static void userMove(char[][] board){    
  
  while(true){
    Scanner in = new Scanner(System.in); 
    System.out.println("Please enter a number between 1-9");
    String  move = in.nextLine();   
  if  (!move.equals(" ")) {  
      newMove = Integer.parseInt(move); // change string to take in integer input 
  if  (newMove >= 1 && newMove <= 9)  { 
      newMove -= 1;       //  to get correct index 
      int row = newMove / 3; // to get row index
      int col = newMove % 3; // to get column index 
      player = board[row][col];  // assign char player variable to 2d array index
 if   (player == 'X' || player == 'O'){
    System.out.println("Sorry this position is taken"); 
 } else {
      board[row][col] = 'X'; // if spot not taken place char symbol at 2d array index 
      break; 
 }

}
 else { // refers to if statement above when user enter a value not in range 
       System.out.println("Please play within the range of 1-9 "); 
 } 

}
 else { // refers to if statement above when user enters a space instead of a value
      System.out.println("Please enter a valid number");
}
      in.close();
 }
 
 // call game board 
 gameBoard(board);
 
}
/**
 * get computer input by using random() method
 * @param board
 */ 
public static void cpuMove(char[][] board){
  Random rand = new Random(); // use math random() method
  while(true){
    int cpuPosition = rand.nextInt(9) + 1; // get range 
    cpuPosition -= 1;
    int row = cpuPosition / 3;
    int col = cpuPosition % 3; 
    player = board[row][col];
    if (player == 'X' || player == 'O') { 
      continue; // if spot taken , find another spot
    } else {
      board[row][col] = 'O'; // place computer char symbol at avaiable 
      break; 
    }
      
     }
    gameBoard(board); // call game board

    }

/**
 * check wins 
 * @param board
 * @return win or draw for computer or user if true 
 */
public static boolean checkRowWin(char[][] board){
  //for loop to get rows and colunm wins
 for(int i = 0; i < 3; i++){
   if(board[i][0] == 'X' &&  board[i][1] == 'X' &&   board[i][2] == 'X' ) {
      System.out.println("CONGRATS!!! YOU WON! ");
      return true;
   } else if(board[i][0] == 'O' &&  board[i][1] == 'O' &&   board[i][2] == 'O' ) {
      System.out.println("COMPUTER WON ");
      return true;
   } else if(board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X' ) {  
      System.out.println("CONGRATS!!! YOU WON! ");
      return true;
   } else if(board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O')  {
      System.out.println("COMPUTER WON ");
   }
 }
// if- else if to get diagonal wins
 if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
    System.out.println("CONGRATS!!! YOU WON!");
    return true;
 } else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
    System.out.println("COMPUTER WON ");
 } else if (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') {
    System.out.println("CONGRATS!!! YOU WON!");
    return true;
 } else if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O') {
    System.out.println("COMPUTER WON ");
    return true; 
 }
 // if board indices are not equal to char space , it's a draw
 if (board[0][0] != ' ' && board[0][1] != ' '  && board[0][2] != ' ' && board[1][0] != ' ' 
 && board[1][1] != ' ' && board[1][2] != ' ' && board[2][0] != ' ' && board[2][1] != ' '
 && board[2][2] != ' ') {
    System.out.println("IT'S A DRAW ");
    return true;
 } 
 // complete boolean method
    return false;

}

}





