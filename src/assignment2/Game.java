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
        for(int num = board.numTurns; num > 0; num--){
            System.out.println("You have " + num + " guess(es) left.");

        }
    }

}
