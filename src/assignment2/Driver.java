/**  EE422C Project 2 (Mastermind)submission by
 *  Replace <...> with your actual data.
 *  Meyer Dauber
 *  mjd3375
 *  Slip days used: 0
 *  Spring 2019
 */

package assignment2;

import java.util.*;
import java.io.*;

public class Driver {

    public static void main(String[] args){
        System.out.println("Welcome to Mastermind!");
        System.out.println("Do you want to play a new game? (Y/N):");
        Scanner scan = new Scanner(System.in);
        if(scan.next().equals("Y")){
            Game game;
            if(args[0].equals("1"))//determining if need to run in test mode
                game = new Game(true, scan);
            else
                game = new Game(false, scan);
            game.runGame();
        }
    }
}
