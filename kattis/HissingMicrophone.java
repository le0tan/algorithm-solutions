import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * HissingMicrophone
 */
public class HissingMicrophone {

    public static void main(String[] args) {
        Pattern p = Pattern.compile(".*ss.*");
        Scanner sc = new Scanner(System.in);
        if(p.matcher(sc.nextLine()).matches()) {
            System.out.println("hiss");
        } else {
            System.out.println("no hiss");
        }
    }
}