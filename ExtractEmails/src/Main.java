import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;

public class Main {


    public static void main(String[] args) {

        try {
            String content = new Scanner(new File("emails.txt")).useDelimiter("\\Z").next();
            Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(content);
            int i= 0;
            while (m.find()) {
                i++;
                if(i%2 == 0 || !m.group().contains("buffalo.edu")){
                    continue;
                }
                System.out.println(m.group());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
