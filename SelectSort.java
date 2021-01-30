package com.black.key.array;

/**
 * @author: DonHear
 * @since: 2021-01-29 16:36
 * @Description:
 * @version: 1.0.0
 */
public class SelectSort {
    private final long[] a;
    //指针（索引）体现数组a中实际元素个数
    private int nElems;
    //构造函数：当对象初始化后，指针（索引）也随之初始化
    public SelectSort(int max){
        a = new long[max];
        nElems = 0;
    }
    public static void main(String[] args) {
        //声明数组大小
        SelectSort selectSort = new SelectSort(10);
        //生成20个随机元素
        selectSort.goRandom(10);
        System.out.println("排序前");
        //打印数组元素
        selectSort.display();
        System.out.println();
        //进行选择排序
        selectSort.sor();
        System.out.println();
        System.out.println("排序后");
        //打印数组元素
        selectSort.display();
    }
    public void sor(){
        //临时下标存放指针
        int out;
        //外循环从下标0开始
        for (int j=0;j<nElems-1;j++){
            //内循环中会临时存放一些无规则下标
            //这里每次外循环都需要对其进行重置
            out=j;
            //声明一个计算内循环次数变量
            int k = 0;
            //这里对内循环进行了修改，使其从数组的后面向前遍历
            // i>j 是为了让已经有序的、不变性的元素不去重复循环比较消耗性能
            for ( int i=nElems-1;i>j;i--){
                k++;
                //下标对应元素若小于标识元素则将对应下标交赋给标识
                if (a[i]<a[out]){
                    out = i;
                }
            }
            swap(j,out);
            System.out.println("第"+(j+1)+"次外循环,共执行内循环："+k+"次");
        }
    }
    /**
     * 进行选择排序
     * 注：书中的排序形式
     */
    public void bookSor(){
        //分析一下
        //out ：外循环次数
        //in  ：内循环次数
        //min ：临时下标存储指针
        int out, in, min;
        //外循环，保证从下标0-9
        for (out = 0; out<nElems-1; out++){
            //重置临时指针，随着外循环次数增加而忽略已排序、不变性的元素
            min = out;
            //内循环，in=out+1·是为了保证循环起始下标不与自身重复比较
            for (in=out+1; in<nElems; in++){
                //取出下标区间内最小元素的下标，赋予临时指针，随后交给外循环进行元素交换
                if (a[in]<a[min]){
                    min = in ;
                }
            }
            swap(out , min);
        }
    }
    /**
     * 元素交换
     * @param one
     * @param two
     */
    private void swap(int one,int two){
        long temp = a[one];
        a[one]=a[two];
        a[two]=temp;
    }
    /**
     * 为数组自动生成指定长度的元素个数
     * 范围：长度内
     * @param size
     */
    public void goRandom(int size){
        for (int i = 0; i < size; i++) {
            int j = (int) ((Math.random() * size + 1) * 1);
            a[i]=j;
            nElems++;
        }
    }
    /**
     * 打印所有存在的元素
     */
    public void display(){
        for (int j=0;j<nElems;j++){
            System.out.print(a[j] + " ");
        }
    }

}
