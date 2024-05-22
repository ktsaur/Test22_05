import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File directory = new File("/Users/kseniataryskina/Downloads/cw2");
        List<String> names = new ArrayList<>();
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        names.add(file.getName());
                    }
                }
            } else {
                throw new FileNotFoundException();
            }
        } else {
            throw new FileNotFoundException();
        }

        //файл для записи итоговой строки
        OutputStream os = new FileOutputStream("22N.txt");

        List<Thread> fileThread = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            ReadThread rt = new ReadThread(names.get(i));
            fileThread.add(new Thread(rt));
            os.write(rt.s.getBytes()); // записала все строки в один итоговый файл
        }

        os.flush();

        //запуск потоков
        for (int i = 0; i < names.size(); i++) {
            fileThread.get(i).start();
        }
    }
}
