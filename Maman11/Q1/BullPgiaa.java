import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

/**
 * the class that runs the game.
 * all the messages and swing action happens here.
 */
public class BullPgiaa {
    public static JFrame f; //the frame of the game.

    /**
     * when running the program main will activate.
     * it's in charge on all of the UI interactions
     * @param args
     */
    public static void main(String[] args) {
        //starts the frame and sets its height, width ext.
        f=new JFrame();
        f.setSize(300, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setVisible(false);
        while(true){
            //restarts game variables
            JOptionPane.showMessageDialog(f, "Welcome to bull pgiaa!");
            Game game = new Game();
            String playerGuess = "0000";
            //main game
            while(!game.isWin(playerGuess)) {
                playerGuess = JOptionPane.showInputDialog(f, game.getHistory() + "please enter a number: ");
                if(playerGuess == null) break;
                while(!game.isLegal(playerGuess)) { //if the guess is illegal.
                    JOptionPane.showMessageDialog(f, "illegal number, please enter another number!", "Error", JOptionPane.ERROR_MESSAGE);
                    playerGuess = JOptionPane.showInputDialog(f, game.getHistory() + "please enter a number: ");
                }
                //checking the guess.
                int[] guess = game.res(playerGuess);
                //adding the guess to the list.
                game.addGuess(playerGuess + " bulls: " + guess[0] + " pgiot: " + guess[1]);
            }
            //shows a win message and asks the player if he wants to play again.
            int a = JOptionPane.showConfirmDialog(f,"you won! \n do you want to play again?");
            if(a==JOptionPane.NO_OPTION || a==JOptionPane.CANCEL_OPTION) break;
        }
        //closing the window.
        f.dispose();
    }
}