/**
 * Created by Chiru on Dec 27, 2016
 */
package threading;

public class Racer implements Runnable {

    public static String winner = null;

    public void race() {

        for (int distance = 1; distance <= 100; distance++) {

            System.out.println(
                    "Distance Covered by " + Thread.currentThread().getName() + " is " + distance + " meeters");

            if (distance == 60 && Thread.currentThread().getName().equals("Hare")) {
                try {
                    System.out.println("Hare is sleeping");
                    Thread.sleep(1000 * 10);// 10 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Check if someone has won
            boolean isRaceWon = this.isRaceWon(distance);
            if (isRaceWon)
                break;

        }

    }

    private boolean isRaceWon(int distanceCovered) {
        boolean isRaceWon = false;

        if ((Racer.winner == null) && (distanceCovered == 100)) {
            String winnerName = Thread.currentThread().getName();
            Racer.winner = winnerName;
            System.out.println("Winner is " + Racer.winner);
            isRaceWon = true;
        }

        return isRaceWon;

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        this.race();

    }

}
