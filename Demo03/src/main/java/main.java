import javax.swing.*;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Car car = new Car();
        JFrame frame = new JFrame("Gvssimux");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setLocation(100, 50);
        frame.setVisible(true);
        frame.add(car);

        //Scanner infile = new Scanner(Paths.get("D:/JavaSwingHuaTu.txt"), "UTF-8");


    }

}