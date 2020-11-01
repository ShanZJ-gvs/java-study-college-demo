import app.Component;
import app.MyFrame;
import model.Image;
import model.Letter;
import model.Rectangle;
import model.Round;
import tools.ReadProPerties;
import tools.SplitWord;

import java.awt.*;
import java.io.IOException;
import java.util.Map;


public class main {
    public static void main(String[] args) throws IOException{
        EventQueue.invokeLater(()->{
            MyFrame myFrame = new MyFrame();
            Container container = myFrame.getContainer("Hehee");
            String filePath = "D:\\Java后端学习的项目\\Java_CZ\\Demo03\\src\\main\\java\\app\\text2.txt";
            //第一种读取文件的方式
            //Map<String, String> stringStringMap = new SplitWord().SplitWord(filePath, ";|=|,|\\.| |;|\\(|\\)|\n");
            Map<String, String> stringStringMap = new SplitWord().SplitWord(filePath, " |;|\r\n");
            System.out.println(stringStringMap);
            Component letter = new Letter(stringStringMap);
            Component round = new Round(stringStringMap);
            //Image image = new Image(stringStringMap);
            container.add(round);
            container.add(letter);

            //container.add(image);

        });



        /*EventQueue.invokeLater(()->{


        });*/

        /*JFrame frame = new JFrame("shanzj");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setLocation(100, 50);
        frame.setVisible(true);*/
        //Container contentPane = frame.getContentPane();
        //contentPane.add(car);
        //Scanner infile = new Scanner(Paths.get("D:/JavaSwingHuaTu.txt"), "UTF-8");


    }

}