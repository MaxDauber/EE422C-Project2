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
            System.out.println(board.toString());


        }
    }

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

    public Peg checkInput(String input){
        int black = 0;
        int white = 0;
        for(int i  = 0; i < GameConfiguration.pegNumber; i++) {
            if(input.substring(i,i+1).equals(secret_code.substring(i,i+1)))
                black++;
        }
        return new Peg(black, white);
    }


}
