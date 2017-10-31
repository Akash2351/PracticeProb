/**
 * Created by Chiru on Dec 27, 2016
 */
package threading;

public class RunningRaceThreading {

    public static void main(String[] args) {

        // Racer Class has implemented runnable interface
        Racer racer = new Racer();

        Thread tortoiseThread = new Thread(racer, "Tortoise");
        Thread hareThread = new Thread(racer, "Hare");

        // Race Starts when threads are started
        tortoiseThread.start();
        hareThread.start();
    }
}
