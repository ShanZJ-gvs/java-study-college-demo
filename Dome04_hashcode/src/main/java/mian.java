import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;

public class mian {
    public static void main(String[] args) {
        String s = ReadFile.readFile("D:\\Java后端学习的项目\\Java_CZ\\Dome04_hashcode\\src\\main\\java\\word.txt");
        System.out.println(s);
        int i = s.hashCode();
        ArrayList<String> word = new ArrayList<String>();
        System.out.println(word);
        HashMap<String, String> wordsHashMap = new HashMap<String, String>();
        wordsHashMap.
    }
}
