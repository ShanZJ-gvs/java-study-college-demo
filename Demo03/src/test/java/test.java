import app.MyComponent;
import org.junit.Test;

public class test {

    @Test
    public void test01(){
        MyComponent wa = new MyComponent();
        System.out.println(wa.getClass().getName());
    }
}
