import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class hashcode {
    public static void main(String[] args) {
        int flag=0;
        Scanner s=new Scanner(System.in);
        System.out.println("是否忽略大小写？请输入0(忽略)或1(不忽略)");
        int ss=s.nextInt();
        flag=(ss==0)?0:1;
//        if(ss==0) {
//            flag=0;
//        }
//        else if(ss==1) {
//            flag=1;
//        }
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        // 获取项目路径
        String path = System.getProperty("user.dir");
        // 拼接文件路径 创建源
        File src = new File(path + "/src/com/yj/demo.txt");
        // 选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);
            // 读取操作
            char[] flush = new char[1024];
            int len = 0;
            while (-1 != (len = reader.read(flush))) {
                // 字符数组转成 字符串
                String str = new String(flush, 0, len);
                // 分割成块
                String[] strArray = str.split(",|\\.|\\s+");
                // 分割出单词
                for (int i = 0; i < strArray.length; i++) {
                    // 将所有单词选出来放于集合
                    if (strArray[i].matches("^[A-Za-z]+$")) {
                        // 忽略大小写，统一转为小写
                        if(flag==0) {
                            strArray[i] = strArray[i].toLowerCase();
                        }

                        if (wordMap.containsKey(strArray[i])) {
                            wordMap.put(strArray[i], wordMap.get(strArray[i]) + 1);
                        } else {
                            wordMap.put(strArray[i], 1);
                        }
                    }
                }

            }

            List<Map.Entry<String, Integer>> words = new ArrayList<Map.Entry<String, Integer>>(wordMap.entrySet());
            Collections.sort(words, new Comparator<Map.Entry<String, Integer>>() {

                public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                    return -(o1.getValue() - o2.getValue());
                }
            });

            System.out.println("出现频率最多的十个单词是：");
            int i = 0;
            for (Map.Entry<String, Integer> node : words) {
                if (i < 10) {
                    System.out.println(node.getKey() + " : " + node.getValue());
                } else {
                    break;
                }
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("源文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取失败");
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (Exception e2) {
            }
        }
    }

}