package com.black.key;

import java.util.Arrays;

/**
 * @author: DonHear
 * @since: 2021-01-12 14:48
 * @Description:
 * @version: 1.0.0
 */
public class ArrayDemo {
    public static void main(String[] args) {
        /*
        1、该demo是基于允许元素出现重复的情况
        所以在插入算法中逻辑步数相对较少，查询时需要找出所有指定元素的下标，删除时也需要删除所有指定元素
        相对的，查询和删除的逻辑步数就相应增加
        2、还有一种是不允许出现重复元素的情况
        在插入时就需要添加更多的逻辑步数，相对的，查询和删除在找到指定元素后就可以返回结果了
         */
        //获取一个无重复元素的定长60的数组（前三十的下标已被赋值，未赋值下标会被0补齐）
        int[] arrays = getArrays();
        //为数组插入一条新的数据，插入的数据会顺序的插入第一个未赋值的数组下标内（允许插入重复值）
        setArrays(arrays,29);
        //查询输入元素的所有下标，打印返回提示信息（这里会存在一个问题，没有赋值的下标是0补齐的，所以这里先忽略）
        System.out.println(findArrays(arrays, 29));
        //删除指定元素（所有指定元素）
        System.out.println("int[]="+Arrays.toString(delArrays(arrays, 29)));
    }


    /**
     * 声明一个固定长度的数组并赋值（不重复）
     * 起始元素从1开始依次递增
     */
    private static int[] getArrays(){
        int[] array = new int[60];
        for (int i = array.length - 31; i >= 0; i--) {
            array[i]=i+1;
        }
        System.out.println("初始化");
        System.out.println("int[]="+ Arrays.toString(array));
        return array;
    }
    /**
     * 增：为传入数组赋值（不重复）
     */
    private static int[] setArrays(int[] arrays,int a){
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i]==0){
                arrays[i]=a;
                break;
            }
        }
        System.out.println("插入一条数据");
        System.out.println("int[]="+ Arrays.toString(arrays));
        return arrays;
    }
    /**
     * 查：在传入的数组内查询想要的值是否存在并返回下标
     */
    private static String findArrays(int[] arrays,int a){
        String j = "";
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i]==a){
                j=j+"["+i+"]";
            }
        }
        System.out.println("查询完毕");
        if ("".equals(j)){
            return  "数组内不存在该元素";
        }else {
            return  "存在该元素的下标为："+j;
        }
    }
    /**
     * 删：为传入的数组删除该元素
     */
    private static int[] delArrays(int[] arrays,int a){
        //不复杂的正逻辑基本思路
        //首先循环出对应的元素并删除（赋值为0）
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i]==a){
                arrays[i]=0;
            }
        }
        //调整下标，使存在元素的下标相连
        for (int i = 0; i < arrays.length; i++) {
            //假设该demo只传入一个元素进行删除，所以连续存在元素的下标不存在连续为0的情况
            if (arrays[i]==0 && arrays[i]==arrays[i+1]){
                //基于上述前提，这里当出现连续无值的情况直接跳出循环
                break;
            }
            if (arrays[i]==0){
                arrays[i]=arrays[i+1];
                arrays[i+1]=0;
            }
        }
        System.out.println("删除成功");
        return arrays;
    }
}
