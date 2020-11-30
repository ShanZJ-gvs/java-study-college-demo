import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;

public class LeetCodeTest {
    public static void main(String[] args) {
        int nums[] = new int[]{3,2,3};
        System.out.println("nums的长度 "+nums.length);

        System.out.println("-----分割------");

        int[] ints = twoSum(nums, 6);
        for (int a: ints) {
            System.out.print(" "+a);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        //定义2个动态数组,一个用来排序，一个用来最后算位置
        ArrayList<Integer> integers = new ArrayList<Integer>();
        ArrayList<Integer> integers2 = new ArrayList<Integer>();
        for (int a: nums) {
            integers.add(a);
            integers2.add(a);
        }
        System.out.println("integers："+integers);
        Collections.sort(integers);
        System.out.println("integers："+integers);
        //定义一个的处理后的集合
        ArrayList<Integer> ends = new ArrayList<Integer>();
        int j = integers.size()-1;
        for(int i=0;i<integers.size()&&i<j;){
            if(integers.get(i) + integers.get(j) < target){
                i++;
            }else if (integers.get(i) + integers.get(j) > target){
                j--;
            }else if (integers.get(i) + integers.get(j) == target){
                ends.add(integers.get(i));
                ends.add(integers.get(j));
                i++;
                j--;
            }
        }
        System.out.println("ends:"+ends);
        int nums2[] = new int[ends.size()];
        int i = 0;
        for (int a : ends) {

            nums2[i] = integers2.indexOf(a);
            integers2.set(nums2[i],null);
            i++;
        }
        return nums2;
    }

    @Test
    public  void test(){

        // 创建一个动态数组
        ArrayList<String> sites = new ArrayList<>();

        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");

        System.out.println("ArrayList : " + sites);

        // 将所有元素更改为大写
        sites.replaceAll(e -> e.toUpperCase());
        System.out.println("更新后的 ArrayList: " + sites);
    }


}
