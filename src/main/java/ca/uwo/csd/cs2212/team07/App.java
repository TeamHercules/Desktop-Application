package ca.uwo.csd.cs2212.team07;

import javax.swing.SwingUtilities;

/**
 * Main class for the FitBit Program
 *
 * @author team07
 */
public class App {

    /**
     * We expect that the args array will contain either no arguments or "test".
     * Runs MainWindow in either test mode or normal mode
     *
     * @param args command line arguments supplied
     */
    public static void main(String[] args) {

        //Runs test mode if specified by the command line argument
        if (args.length > 0 && args[0].equals("test")) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //Run the program in Test Mode
                    MainWindow window = new MainWindow(true);
                    window.setVisible(true);
                }
            });
        } 
        //Runs normal mode if either no command line argument is provided or arguments are unrecognized
        else {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //Run the program in Normal Mode
                    MainWindow window = new MainWindow(false);
                    window.setVisible(true);
                }
            });
        }

    }
}
