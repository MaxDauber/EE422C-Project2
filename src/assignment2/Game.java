/**  EE422C Project 2 (Mastermind)submission by
 *  Replace <...> with your actual data.
 *  Meyer Dauber
 *  mjd3375
 *  Slip days used: 0
 *  Spring 2019
 */

package assignment2;

import java.util.Scanner;

public class Game {

    public boolean state;
    public boolean mode;
    public Scanner scan;
    public Board board;
    public String secret_code;


    public Game(boolean test, Scanner scan){
        this.mode = test;
        this.scan = scan;
        this.state = false;
        secret_code = SecretCodeGenerator.getInstance().getNewSecretCode();
        board  = new Board(GameConfiguration.guessNumber);
    }


    public void runGame(){
        boolean won = false;
        if(mode){
            System.out.println("Secret code: " + secret_code);
        }
        System.out.println();
        for(int num = board.numTurns; num > 0; num--){
            System.out.println("You have " + num + " guess(es) left");
            System.out.println("Enter guess: ");
            String guess = scan.next();
            while(!checkValidInput(guess)){
                System.out.println("INVALID_GUESS\n");
                System.out.println("You have " + num + " guess(es) left");
                System.out.println("Enter guess: ");
                guess = scan.next();
            }

            Peg result = checkInput(guess);
            board.addGuess(guess, result);
            if(result.black == GameConfiguration.pegNumber){
                System.out.println(guess + " -> "+result.toString());
                won = true;
                break;
            }
            else
                System.out.println(board.toString());


        }
        if(won)
            System.out.println("You win!");
        else
            System.out.println("You lose!");
    }
    /**
     * Checks guess to make sure it is made up of correct colors and is correct length
     * @param guess String format of current guess
     * @return true if the input fits the parameters, false if not
     */
    public boolean checkValidInput(String guess){
        if(guess.length() != GameConfiguration.pegNumber){
            return false;
        }
        boolean check;
        for(int i = 0; i < guess.length(); i++){
            check = false;
            for(int j = 0; j < GameConfiguration.colors.length; j++){
                if(guess.substring(i,i+1).equals(GameConfiguration.colors[j]))
                    check = true;

            }
            if(!check)
                return false;
        }
        return true;
    }
    /**
     * Checks given input and returns Peg configuration as feedback
     * @param guess String format of current guess
     * @return Peg with desired number of white and black pegs
     */
    public Peg checkInput(String guess){

        //Create temporary variables to store templists
        int black = 0;
        int white = 0;
        String[] secret_temp = new String[GameConfiguration.pegNumber];
        String[] guess_temp = new String[GameConfiguration.pegNumber];

        //Populating templists to calculate feedback
        for (int loc = 0; loc < GameConfiguration.pegNumber; loc++) {
            secret_temp[loc] = secret_code.substring(loc,loc+1);
            guess_temp[loc] = guess.substring(loc,loc+1);
        }

        //Check to see if there are any perfect (black) matches and if so, remove them from the templists
        for(int loc = 0; loc < GameConfiguration.pegNumber; loc++){
            if(secret_temp[loc].equals(guess_temp[loc])){
                guess_temp[loc]="";
                secret_temp[loc]="";
                black++;
            }
        }

        //Loop through unused indices of the secret code to find non-perfect (white) matches
        for (int secret_loc = 0; secret_loc < GameConfiguration.pegNumber; secret_loc++) {
            if(secret_temp[secret_loc].equals(""))
                continue;
            //For each element of the secret code, loop through unused indices of input
            for (int input_loc = 0; input_loc < GameConfiguration.pegNumber; input_loc++) {
                if(guess_temp[input_loc].equals("")){
                    continue;
                }
                //if the elements are the same, then there is a non-perfect (white) match
                else if(secret_temp[secret_loc].equals(guess_temp[input_loc])){
                    guess_temp[input_loc]="";
                    secret_temp[secret_loc]="";
                    white++;
                }
            }
        }
        return new Peg(black, white);

        /*
        boolean blacks[] = new boolean[secret_code.length()];
        boolean whites[] = new boolean[GameConfiguration.colors.length];

        //looping through to check each element of the answer values
        for(int secret_loc  = 0; secret_loc < GameConfiguration.pegNumber; secret_loc++) {
            //looping to check each of the input values agains
            for(int input_loc = 0; input_loc < GameConfiguration.pegNumber; input_loc++){

                //check if colors are the same at the chosen addresses
                if(input.substring(input_loc,input_loc+1).equals(secret_code.substring(secret_loc,secret_loc+1))) {

                    //if colors are the same, locations are the same and hasn't already been marked, increment black
                    if(secret_loc == input_loc && !blacks[secret_loc]){
                        black++;
                        blacks[secret_loc] = true;
                        continue;
                    }

                    //if locations are not the same and that color hasn't already been marked as a white
                    if(!whites[getColorLoc(input.substring(input_loc,input_loc+1))] && !blacks[secret_loc]){
                        white++;
                        whites[getColorLoc(input.substring(input_loc,input_loc+1))] = true;
                        continue;
                    }

                }
            }

        }
        */
    }
/*
    //Method needed to run old version of checkInput
    public int getColorLoc(String color){
        for(int k = 0; k < GameConfiguration.colors.length; k++){
            if(color.equals(GameConfiguration.colors[k]))
                return k;
        }
        return -1;
    }

*/
}
