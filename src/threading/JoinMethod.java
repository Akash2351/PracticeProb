/**
 * Created by Chiru on Dec 28, 2016
 */
package threading;

public class JoinMethod {
    public static Thread slowThread;
    public static Thread fastThread;

    public static void main(String[] args) {
        JoinThread jt = new JoinThread();
        slowThread = new Thread(jt, "Slow Thread");
        fastThread = new Thread(jt, "Fast Thread");

        slowThread.start();

    }

}
