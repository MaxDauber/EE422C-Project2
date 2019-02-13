/**  EE422C Project 2 (Mastermind)submission by
 *  Replace <...> with your actual data.
 *  Meyer Dauber
 *  mjd3375
 *  Slip days used: 0
 *  Spring 2019
 */


package assignment2;

public class Board {
    public int numTurns;
    public String[] guesses;
    public Peg[] feedback;

    public Board(int numTurns){
        this.numTurns = numTurns;
        guesses = new String[GameConfiguration.guessNumber];
        feedback = new Peg[GameConfiguration.guessNumber];
    }

    public String toString(){
        String ret = "";
        for(int k = 0; k < guesses.length; k++){
            ret += guesses[k];
            ret += " -> ";
            ret += feedback[k];
            ret += "b_\n";
        }
        return ret;
    }
}
