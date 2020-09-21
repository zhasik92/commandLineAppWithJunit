package playgroung.tutorial.badthreads;
public class BadThreads {

    static String message;

    private static class CorrectorThread
            extends Thread {

        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
            // Key statement 1:
            message = "Mares do eat oats.";
        }
    }

    public static void main(String args[])
            throws InterruptedException {

        CorrectorThread correctorThread = new CorrectorThread();
        correctorThread.join();
        correctorThread.start();
        message = "Mares do not eat oats.";
        System.out.println(message+ "25");
        Thread.sleep(2000);
        // Key statement 2:
        System.out.println(message);
    }
}
