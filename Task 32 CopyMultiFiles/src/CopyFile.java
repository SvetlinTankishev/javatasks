import java.io.*;

public class CopyFile implements Runnable {
    private String sourceFile;
    private String destinationPath;

    public CopyFile(String sourceFile, String destinationPath) {
        this.sourceFile = sourceFile;
        this.destinationPath = destinationPath;
    }

    public void run() {
        System.out.println("Copying file " + sourceFile + " starts...");
        try {
            File source = new File(sourceFile);
            File destDir = new File(destinationPath);
            destDir.mkdirs(); // create directories if they don't exist
            File dest = new File(destinationPath + File.separator + source.getName());
            InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
            System.out.println("Copying file " + sourceFile + " ends.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}