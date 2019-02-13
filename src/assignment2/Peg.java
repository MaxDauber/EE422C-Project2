/**  EE422C Project 2 (Mastermind)submission by
 *  Replace <...> with your actual data.
 *  Meyer Dauber
 *  mjd3375
 *  Slip days used: 0
 *  Spring 2019
 */


package assignment2;


public class Peg {
    public int black;
    public int white;

    public Peg(int black, int white){
        this.black = black;
        this.white = white;
    }

    public String toString(){
        return black + "b_" + white + "w";
    }
}
