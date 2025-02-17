import java.util.Scanner;
public class ConnectFour {
    private static void initializeTable(String[][] arr) {
        for(int j =0; j<arr[0].length; j++) {
            for(int k=0; k<arr[0].length; k++){
                arr[j][k] = "";
            }
        }
    }

    private static void current_board(String[][] status){
        System.out.println(" --------------------");
        for(int j =0; j<status[0].length; j++) {
            System.out.print("|  ");
            for(int k=0; k<status[0].length; k++){
                System.out.printf("%-3s",status[j][k]);
                    if (k == 5) {
                        System.out.print("|");
                        System.out.println("");
                        }
            } 
        }
        System.out.println(" --------------------");
    }

    private static void tieChecker(String[][] arree, int move){
        if(move >= arree[0].length * arree[0].length) {
            System.out.println("It's a Tie!");
            System.exit(1);
        }
    }

    private static void winner_check(String[][] array){
            //Horizontal win check -> ---
            for(int j =0; j<(array[0].length-3); j++){
                for(int i=0; i<array[0].length; i++){
                    if(array[i][j] != null && !array[i][j].equals("") && array[i][j].equals(array[i][j+1]) && array[i][j+1].equals(array[i][j+2]) && array[i][j+2].equals(array[i][j+3])) {
                    //Printing the final state of board
                    System.out.println("Player "+array[i][j]+" Won!");
                    current_board(array);
                    System.exit(1);
                    }
                }
            }

            //verticle Win check -> ||
            for(int k =0; k<(array[0].length-3); k++){
                for(int i=0; i<array[0].length;i++){
                    if(array[k][i] != null && !array[k][i].equals("") && array[k][i].equals(array[k+1][i]) && array[k+1][i].equals(array[k+2][i]) && array[k+2][i].equals(array[k+3][i])) {
                    System.out.println("Player "+array[k][i]+" Won!");
                    current_board(array);
                    System.exit(1);
                }
                }
            }

            //Cross check 1: main DIAGONALS -> \
            for(int l =0; l<(array[0].length-3); l++){
                if( array[l][l] != null && !array[l][l].equals("") && array[l][l].equals(array[l+1][l+1]) && array[l+1][l+1].equals(array[l+2][l+2]) && array[l+2][l+2].equals(array[l+3][l+3]) ) {
                    System.out.println("Player "+array[l][l]+" Won!");
                    current_board(array);
                    System.exit(1);
                }
            }

            //cross check 2: Diagonal -> /
            for(int i =0; i<3;i++){
                for(int j=5; j>=3; j--){
                    if( array[i][j] != null && !array[i][j].equals("") && array[i][j].equals(array[i+1][j-1]) && array[i+1][j-1].equals(array[i+2][j-2]) && array[i+2][j-2].equals(array[i+3][j-3]) ) {
                    System.out.println("Came from herePlayer "+array[i][j]+" Won!");
                    current_board(array);
                    System.exit(1);
                    }
                }
            }

            //Diagonal small single -> \\
            if( array[0][2] != null && !array[0][2].equals("")&& array[0][2].equals(array[1][3]) && array[1][3].equals(array[2][4]) && array[2][4].equals(array[3][5]) ) {
                System.out.println("Player "+array[0][2]+" Won!");
                current_board(array);
                System.exit(1);
            }else if( array[2][0] != null && !array[2][0].equals("") && array[2][0].equals(array[3][1]) && array[3][1].equals(array[4][2]) && array[4][2].equals(array[5][3]) ) {
                System.out.println("Player "+array[2][0]+" Won!");
                current_board(array);
                System.exit(1);
            }

            //Diagonal small single check -> //
            if( array[0][3] != null && !array[0][3].equals("")&& array[0][3].equals(array[1][2]) && array[1][2].equals(array[2][1]) && array[2][1].equals(array[3][0]) ) {
                System.out.println("Player "+array[0][3]+" Won!");
                current_board(array);
                System.exit(1);
            }else if( array[2][5] != null && !array[2][5].equals("")&& array[2][5].equals(array[3][4]) && array[3][4].equals(array[4][3]) && array[4][3].equals(array[5][2]) ) {
                System.out.println("Player "+array[2][5]+" Won!");
                current_board(array);
                System.exit(1);
            }

            //diagonal double  chec  -> \\
            if( array[0][1] != null && !array[0][1].equals("")&& array[0][1].equals(array[1][2]) && array[1][2].equals(array[2][3]) && array[2][3].equals(array[3][4]) ) {
                System.out.println("Player "+array[0][1]+" Won!");
                current_board(array);
                System.exit(1);
            }else if( array[1][2] != null && !array[1][2].equals("")&& array[1][2].equals(array[2][3]) && array[2][3].equals(array[3][4]) && array[3][4].equals(array[4][5]) ) {
                System.out.println("Player "+array[1][2]+" Won!");
                current_board(array);
                System.exit(1);
            } else if( array[1][0] != null && !array[1][0].equals("")&& array[1][0].equals(array[2][1]) && array[2][1].equals(array[3][2]) && array[3][2].equals(array[4][3]) ) {
                System.out.println("Player "+array[1][0]+" Won!");
                current_board(array);
                System.exit(1);
            }else if( array[2][1] != null && !array[2][1].equals("")&& array[2][1].equals(array[3][2]) && array[3][2].equals(array[4][3]) && array[4][3].equals(array[5][4]) ) {
                System.out.println("Player "+array[2][1]+" Won!");
                current_board(array);
                System.exit(1);
            }

            //diagonal double  //
            if( array[0][4] != null && !array[0][4].equals("")&& array[0][4].equals(array[1][3]) && array[1][3].equals(array[2][2]) && array[2][2].equals(array[3][1]) ) {
                System.out.println("Player "+array[0][4]+" Won!");
                current_board(array);
                System.exit(1);
            }else if( array[1][3] != null  && !array[1][3].equals("") && array[1][3].equals(array[2][2]) && array[2][2].equals(array[3][1]) && array[3][1].equals(array[4][0]) ) {
                System.out.println("Player "+array[1][3]+" Won!");
                current_board(array);
                System.exit(1);
            } else if( array[1][5] != null && !array[1][5].equals("") && array[1][5].equals(array[2][4]) && array[2][4].equals(array[3][3]) && array[3][3].equals(array[4][2]) ) {
                System.out.println("Player "+array[1][5]+" Won!");
                current_board(array);
                System.exit(1);
            }else if( array[2][4] != null && !array[2][4].equals("") && array[2][4].equals(array[3][3]) && array[3][3].equals(array[4][2]) && array[4][2].equals(array[5][1]) ) {
                System.out.println("Player "+array[2][4]+" Won!");
                current_board(array);
                System.exit(1);
            }
    
        }

    private static void push_to_board( String[][] arr, int real, int aa, int bb, int cc, int dd, int ee, int ff ){
            if(aa == 1  && real == 0){
                for(int j =0; j<(arr[0].length-1); j++) {
                    int k = real;
                    arr[j][k] = arr[j+1][k];
                }
            }else if(bb == 1  && real == 1){
                for(int j =0; j<(arr[0].length-1); j++) {
                    int k = real;
                    arr[j][k] = arr[j+1][k];
                }
            }else if(cc == 1  && real == 2){
                for(int j =0; j<(arr[0].length-1); j++) {
                    int k = real;
                    arr[j][k] = arr[j+1][k];
                }
            }else if(dd == 1  && real == 3){
                for(int j =0; j<(arr[0].length-1); j++) {
                    int k = real;
                    arr[j][k] = arr[j+1][k];
                }
            }else if(ee == 1  && real == 4){
                for(int j =0; j<(arr[0].length-1); j++) {
                    int k = real;
                    arr[j][k] = arr[j+1][k];
                }
            }else if(ff == 1  && real == 5){
                for(int j =0; j<(arr[0].length-1); j++) {
                    int k = real;
                    arr[j][k] = arr[j+1][k];
                }
            }
    }
    public static void main(String[] args) {
        System.out.println("Start the Game!");
        System.out.println("1. Start");
        System.out.println("2. Quit");
        System.out.print("--> ");
        Scanner scan = new Scanner(System.in);
        String user_input = scan.next();
        Boolean i = true;
        String[][] player_move = new String[6][6];
        initializeTable(player_move);
        char turn = 'R';
        int r_check1 = 0;
        int r_check2 = 0;
        int r_check3 = 0;
        int r_check4 = 0;
        int r_check5 = 0;
        int r_check6 = 0;
        int move_count = 0;
        int max_column_counter1 = 0;
        int max_column_counter2 = 0;
        int max_column_counter3 = 0;
        int max_column_counter4 = 0;
        int max_column_counter5 = 0;
        int max_column_counter6 = 0;
        Boolean change = true;
        Boolean restarter = false;
        try {
            while(i){
            current_board(player_move);         //Printing current board each time after player has made move
            if(user_input.equals("Start") || user_input.equals("1")) {
            switch (turn) {
                case 'R' -> {
                    System.out.println("Player R turn - Please enter your move between 1 to 6");
                    Scanner r_move = new Scanner(System.in);        //taking R player input
                    String r_input = r_move.next();
                    if(r_input.matches("[1-6]")){
                        move_count = move_count +1;                 //counting the move to track each player's move
                        tieChecker(player_move, move_count);       //checking for tie each time the while loop runs
                        int real_move = Integer.parseInt(r_input)-1;
                        if( (max_column_counter1 >= player_move[0].length && real_move == 0) || (max_column_counter2 >= player_move[0].length && real_move == 1) || (max_column_counter3 >= player_move[0].length && real_move == 2) || (max_column_counter4 >= player_move[0].length && real_move == 3) || (max_column_counter5 >= player_move[0].length && real_move == 4) || (max_column_counter6 >= player_move[0].length && real_move == 5)){
                            System.out.println("");
                            System.out.println("Your move is invalid as column "+(real_move+1)+" is already full.");
                            System.out.println("Please select another column!");
                            System.out.println("");
                            move_count = move_count -1;
                            change = false;
                        }else {
                            push_to_board(player_move, real_move, r_check1, r_check2, r_check3, r_check4, r_check5, r_check6 );
                        }
                        switch (real_move) {        //switch condition to only increase the number of input done in particular column to avoid overflow later
                            case 0:
                                r_check1 = 1;
                                max_column_counter1 = max_column_counter1 +1;
                                break;
                            case 1:
                                r_check2 = 1;
                                max_column_counter2 = max_column_counter2 +1;
                                break;
                            case 2:
                                r_check3 = 1;
                                max_column_counter3 = max_column_counter3 +1;
                                break;
                            case 3:
                                r_check4 = 1;
                                max_column_counter4 = max_column_counter4 +1;
                                break;
                            case 4:
                                r_check5 = 1;
                                max_column_counter5 = max_column_counter5 +1;
                                break;
                            default:
                                r_check6 = 1;
                                max_column_counter6 = max_column_counter6 +1;
                                break;
                        }
                        if(change == true){
                            player_move[5][real_move] = "R";
                            turn = 'Y';
                        }
                        winner_check(player_move);
                        change = true;

                    }else if (r_input.equals("Q") || r_input.equals("q")){
                    System.out.println("Force Quiting...!");
                    System.exit(1);
                    } else {
                    turn = 'R';
                    System.out.println("Invalid Move: Please choose your move between 1 to 6!");
                    }
                //r_move.close();
                }
            case 'Y' -> {
                System.out.println("Player Y turn - Please enter your move between 1 to 6");
                Scanner y_move = new Scanner(System.in);
                String y_input = y_move.next();
                if(y_input.matches("[1-6]")){
                    move_count = move_count +1;
                    tieChecker(player_move, move_count);       //checking for tie each time the while loop runs
                    int real_move = Integer.parseInt(y_input)-1;
                    if( (max_column_counter1 >= player_move[0].length && real_move == 0) || (max_column_counter2 >= player_move[0].length && real_move == 1) || (max_column_counter3 >= player_move[0].length && real_move == 2) || (max_column_counter4 >= player_move[0].length && real_move == 3) || (max_column_counter5 >= player_move[0].length && real_move == 4) || (max_column_counter6 >= player_move[0].length && real_move == 5)){
                        System.out.println("Your move is invalid as column "+(real_move+1)+" is already full.");
                        System.out.println("Please select another column!");
                        move_count = move_count -1;
                        change = false;
                    }else {
                        push_to_board(player_move, real_move, r_check1, r_check2, r_check3, r_check4, r_check5, r_check6 );
                    }
                    switch (real_move) {                //switch condition to only increase the number of input done in particular column to avoid overflow later
                            case 0:
                                r_check1 = 1;
                                max_column_counter1 = max_column_counter1 +1;
                                break;
                            case 1:
                                r_check2 = 1;
                                max_column_counter2 = max_column_counter2 +1;
                                break;
                            case 2:
                                r_check3 = 1;
                                max_column_counter3 = max_column_counter3 +1;
                                break;
                            case 3:
                                r_check4 = 1;
                                max_column_counter4 = max_column_counter4 +1;
                                break;
                            case 4:
                                r_check5 = 1;
                                max_column_counter5 = max_column_counter5 +1;
                                break;
                            default:
                                r_check6 = 1;
                                max_column_counter6 = max_column_counter6 +1;
                                break;
                        }
                    if(change == true){             //changing only when needed, avoiding exceptions
                        player_move[5][real_move] = "Y";
                        turn = 'R';
                    }
                    winner_check(player_move);
                    change = true;
                }else if (y_input.equals("Q") || y_input.equals("q")){
                    System.out.println("Force Quiting...!");
                    System.exit(1);
                } else {
                    turn = 'Y';
                    System.out.println("Invalid Move: Please choose your move between 1 to 6!");
                }
            //y_move.close();
            }
            default -> {
                System.out.println("Please enter a valid move!");
                System.out.println("Restarting the game...");
                restarter = true;
                }
        }
        }else if(user_input.equals("Quit") || user_input.equals("2") || user_input.equals("Q") || user_input.equals("q")){
        System.out.println("Game is Quiting...");
        i = false;
        }else {
            System.out.println("Error!");
            i = false;
            if(restarter){
                i = true;
            }
        }
    }
        } catch (NumberFormatException e) {
            System.out.println("There is problem with your input, please recomplie code");      //throwing an exception in the case the scanner dont take input correctly
        }
    scan.close();
    System.out.println("Thanks for playing!");          //exit command
    System.exit(1);
}
}
