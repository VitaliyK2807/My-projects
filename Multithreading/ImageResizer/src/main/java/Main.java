import java.io.File;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "C:/Images";
        String dstFolder = "C:/ChangedImage";
        int newWidth = 300;

        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();

        int one = files.length / 4;
        int two = (files.length - one) / 3;
        int three = (files.length - (one + two)) / 2;
        int four = files.length - (one + two + three);

        File[] file1 = new File[one];
        System.arraycopy(files, 0, file1, 0, file1.length);
        ImageResizer firstStream = new ImageResizer(file1, newWidth, dstFolder, start);
        firstStream.start();

        File[] file2 = new File[two];
        System.arraycopy(files, one, file2, 0, file2.length);
        ImageResizer secondStream = new ImageResizer(file2, newWidth, dstFolder, start);
        secondStream.start();

        File[] file3 = new File[three];
        System.arraycopy(files, one + two, file3, 0, file3.length);
        ImageResizer thirdStream = new ImageResizer(file3, newWidth, dstFolder, start);
        thirdStream.start();

        File[] file4 = new File[four];
        System.arraycopy(files, one + two + three, file4, 0, file4.length);
        ImageResizer fourthStream = new ImageResizer(file4, newWidth, dstFolder, start);
        fourthStream.start();

    }

}
