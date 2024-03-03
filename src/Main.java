import java.io.*;

public class Main {

    /**
     * TODO: TODO: Доработать метод print, необходимо распечатывать директории и файлы
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String resultFulder = "./backup";
        File theDir = new File(resultFulder);
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        copyDir(new File("."), resultFulder);
    }

    static void copyDir(File file, String resultDir) throws IOException {

        File[] files = file.listFiles();
        if (files == null)
            return;
        System.out.println(files.length);
        for (int i = 0; i < files.length; i++){
            System.out.println(files[i].getName());
            if (files[i].getName().equals("backup"))
                continue;
            if (files[i].isDirectory())
            {
                new File(resultDir + "/" + files[i].getName()).mkdirs();
                copyDir(files[i], resultDir + "/" + files[i].getName());
            }
            else {
                copyFile(files[i], resultDir + "/" + files[i].getName());
            }
        }
    }
    static void copyFile(File file, String resultDir) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(resultDir)){
            int c;
            // На чтение
            try (FileInputStream fileInputStream = new FileInputStream(file)){
                while ((c = fileInputStream.read()) != -1){
                    fileOutputStream.write(c);
                }
            }
        }
    }

}

