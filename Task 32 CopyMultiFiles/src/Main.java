public class Main {
    public static void main(String[] args) {
        CopyFile[] copyFiles = {
                new CopyFile("source.txt", "DestinationPath1"),
                new CopyFile("DestinationPath1/destination1.txt", "DestinationPath2"),
                new CopyFile("source2.txt", "DestinationPath3"),
                new CopyFile("source3.txt", "DestinationPath4"),
                new CopyFile("source4.txt", "DestinationPath5")
        };
        Thread[] threads = new Thread[copyFiles.length];
        for (int i = 0; i < copyFiles.length; i++) {
            threads[i] = new Thread(copyFiles[i]);
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}