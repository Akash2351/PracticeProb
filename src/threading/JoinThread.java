/**
 * Created by Chiru on Dec 28, 2016
 */
package threading;

public class JoinThread implements Runnable {

    @Override
    public void run() {
        String currentThread = Thread.currentThread().getName();
        System.out.println(System.nanoTime() + " " + currentThread + " is Starting");

        if (currentThread.equals("Slow Thread")) {
            try {
                System.out.println(System.nanoTime() + " Invoking join()");
                JoinMethod.fastThread.start();
                JoinMethod.fastThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.nanoTime() + " " + currentThread + " is Terminating");

    }

}
