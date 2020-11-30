import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class func {

    public static void twoSum2(int[] nums, int target) {
        //定义动态数组
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (int a:
                nums) {
            integers.add(a);
        }
        //把操作数也放进去
        integers.add(target);


       /* for(int i=0;i<nums.length;i++){
            for (int j=i+1; j<nums.length; j++){
                ints.add(nums[i]+ nums[j]);
            }
        }*/

        System.out.println("integers:"+integers);
        Collections.sort(integers);
        System.out.println("排序后的integers:"+integers);
        System.out.println("target="+target+"的下标为："+integers.indexOf(target));
        //定义一个的处理后的集合
        ArrayList<Integer> ends = new ArrayList<Integer>();
        for(int i=0;i<integers.size()/2;i++){
            for (int j=integers.size()/2; j<integers.size(); j++){
                if(integers.get(i) + integers.get(integers.size()-1)<target){
                    break;
                }
                if(integers.get(i) + integers.get(j)>target){
                    break;
                }else if(integers.get(i) + integers.get(j)<target){

                }else if(integers.get(i) + integers.get(j) == target){
                    ends.add(integers.get(i));
                    ends.add(integers.get(j));
                }


            }
        }

        //此处ends中按顺序每两个之和等于target 如 ends.get(0)+ends.get(1) = target; ends.get(2)+ends.get(3) = target;
        System.out.println("ends:"+ends);


        int nums2[] = new int[ends.size()];
        int i = 0;

        for (int a:
             ends) {
            nums2[i] = integers.indexOf(a);
            i++;
        }

        for (int a:
             nums2) {
            System.out.print(" "+a);
        }


    }


    /*nums的长度 4
    -----分割------
    integers:[2, 7, 11, 15]
    排序后的integers:[2, 7, 11, 15]
    target=9的下标为：-1
    ends:[2, 7]
     0 1*/   //可以~~~~
    public static void twoSum3(int[] nums, int target) {
        //定义动态数组
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (int a:
                nums) {
            integers.add(a);
        }



        System.out.println("integers:"+integers);
        Collections.sort(integers);
        System.out.println("排序后的integers:"+integers);
        System.out.println("target="+target+"的下标为："+integers.indexOf(target));
        //定义一个的处理后的集合
        ArrayList<Integer> ends = new ArrayList<Integer>();

        int j = integers.size()-1;
        for(int i=0;i<integers.size()/2&&i<j;){

            if(integers.get(i) + integers.get(j) < target){
                i++;
            }else if (integers.get(i) + integers.get(j) > target){
                j--;
            }else if (integers.get(i) + integers.get(j) == target){
                ends.add(integers.get(i));
                ends.add(integers.get(j));
                i++;
                j++;
            }



        }

        //此处ends中按顺序每两个之和等于target 如 ends.get(0)+ends.get(1) = target; ends.get(2)+ends.get(3) = target;
        System.out.println("ends:"+ends);


        int nums2[] = new int[ends.size()];
        int i = 0;

        for (int a:
                ends) {
            nums2[i] = integers.indexOf(a);
            i++;
        }

        for (int a:
                nums2) {
            System.out.print(" "+a);
        }

    }



    public int[] twoSum4(int[] nums, int target) {
        //定义动态数组
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (int a: nums) {
            integers.add(a);
        }

        System.out.println("integers:"+integers);
        Collections.sort(integers);
        System.out.println("排序后的integers:"+integers);
        System.out.println("target="+target+"的下标为："+integers.indexOf(target));
        //定义一个的处理后的集合
        ArrayList<Integer> ends = new ArrayList<Integer>();

        int j = integers.size()-1;
        for(int i=0;i<integers.size()/2&&i<j;){

            if(integers.get(i) + integers.get(j) < target){
                i++;
            }else if (integers.get(i) + integers.get(j) > target){
                j--;
            }else if (integers.get(i) + integers.get(j) == target){
                ends.add(integers.get(i));
                ends.add(integers.get(j));
                i++;
                j++;
            }



        }

        //此处ends中按顺序每两个之和等于target 如 ends.get(0)+ends.get(1) = target; ends.get(2)+ends.get(3) = target;
        System.out.println("ends:"+ends);


        int nums2[] = new int[ends.size()];
        int i = 0;

        for (int a:
                ends) {
            nums2[i] = integers.indexOf(a);
            i++;
        }



        return nums2;
    }

}
