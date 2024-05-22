import java.io.FileWriter;
import java.io.IOException;

public class LogFile {
    public void writeFile(String s) {
        try(FileWriter writer = new FileWriter("22N.log")) {
            writer.write(s);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
