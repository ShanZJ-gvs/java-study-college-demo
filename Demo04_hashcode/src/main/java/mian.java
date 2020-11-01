import java.util.HashMap;
import java.util.Set;

public class mian {
    public static void main(String[] args) {
        //读取文件
        String s = ReadFile.readFile("D:\\Java后端学习的项目\\Java_CZ\\Demo04_hashcode\\src\\main\\java\\word2.txt");
        //拆分字符串
        String[] str = s.split(",|\\.| |;|\\(|\\)|\r|\n");
        //执行方法返回HashMap
        System.out.println(countWord(str));
    }

    public static HashMap<String, Integer> countWord(String[] str){
        //将str压缩，使得单词不会重复
        HashMap<String, Integer> wordsHashMap = new HashMap<String, Integer>();
        for (int i = 0; i < str.length; i++) {
            wordsHashMap.put(str[i],1);
        }

        //取出压缩过的单词
        Set<String> keys = wordsHashMap.keySet();

        //new一个新的HashMap2去接受处理过的单词
        HashMap<String, Integer> wordsHashMap2 = new HashMap<String, Integer>();
        int count = 0;
        for (int i = 0; i < wordsHashMap.size(); i++) {
            count = 0;
            for (int j = 0;j< str.length;j++){
                if (str[j].equals(keys.toArray()[i])){
                    count++;
                }
            }
            wordsHashMap2.put((String) keys.toArray()[i],count);
        }

        //查看过程中集合的长度以及内容
        //System.out.println("String[] str"+Arrays.toString(str));
        //System.out.println("Set<String> keys"+keys);
        //System.out.println("String[] str "+str.length);
        //System.out.println("keys.size() "+keys.size());
        //System.out.println("wordsHashMap.size() "+wordsHashMap.size());
        //System.out.println("wordsHashMap2.size() "+wordsHashMap2.size());

        return wordsHashMap2;
    }

}
