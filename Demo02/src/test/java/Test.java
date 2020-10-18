import com.gvssimux.com.pojo.Round;

public class Test {


    public static void main(String[] args) {
        Round round1 = new Round(0, 0, 5);
        Round round2 = new Round(3, 4, 5);
        System.out.println(round1.getRelation(round2));

    }


}
