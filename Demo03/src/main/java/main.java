import app.MyComponent;
import app.MyFrame;
import model.Letter;
import model.Rectangle;
import model.Round;
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
            Map<String, String> stringStringMap = new SplitWord().SplitWord(filePath, " |;|\r\n");
            System.out.println(stringStringMap);


            MyComponent myComponent = new MyComponent();
            //在这new模型
            Letter letter = new Letter(stringStringMap);
            Round round1 = new Round(stringStringMap);
            Round round2 = new Round(stringStringMap,190,0);
            model.Image image1 = new model.Image(stringStringMap);
            Rectangle rectangle = new Rectangle(stringStringMap);

            //将模型传入父组件中
            myComponent.add(round1);
            myComponent.add(round2);
            myComponent.add(letter);
            myComponent.add(image1);
            myComponent.add(rectangle);

            //将父组件添加进容器
            container.add(myComponent);


        });



    }

}