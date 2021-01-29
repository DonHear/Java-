/**
 * @author: DonHear
 * @since: 2021-01-29 10:56
 * @Description:
 * @version: 1.0.0
 */
public class BubbleSor {
    private long[] a;
    //指针（索引）体现数组a中实际元素个数
    private int nElems;
    //构造函数：当对象初始化后，指针（索引）也随之初始化
    public BubbleSor(int max){
        a = new long[max];
        nElems = 0;
    }
    public static void main(String[] args) {
        //声明数组大小
        BubbleSor bubbleSor = new BubbleSor(20);
        //生成20个随机元素
        bubbleSor.goRandom(20);
        System.out.println("排序前");
        //打印数组元素
        bubbleSor.display();
        System.out.println();
        //进行冒泡排序
        bubbleSor.sor();
        System.out.println();
        System.out.println("排序后");
        //打印数组元素
        bubbleSor.display();
    }

    /**
     * 进行冒泡排序排序
     *
     * 注：这个冒泡方法是我根据书中理解一步步调试，从内循环向外写，将自己的理解体现出来
     *     和书中给出的有所不同
     *     书中的在执行上优于我写的
     */
    public void sor(){
        //空闲指引，用于元素交换时临时寄存
        long c ;
        //作为内循环次数指针，减少不必要的循环消耗（默认1是因为N-1次冒泡公式）
        int k = 1;
        //外循环（i=1是因为最后一次没必要执行，已经是最小的）
        for (int i=0;i<nElems-1;i++){

            int j;
            //内层循环（执行比较、替换）
            for (j=0;j<nElems-k;j++){
                //交换
                if (a[j]>a[j+1]){
                    c = a[j];
                    a[j]=a[j+1];
                    a[j+1]=c;
                }
            }
            System.out.println("第"+(i+1)+"次外循环,共执行内循环："+j+"次");
            k++;
        }
    }

    /**
     * 进行冒泡排序排序
     * 注：书中的排序形式
     */
    public void bookSor(){
        int out,in;
        for (out=nElems-1;out>1;out--){
            for (in=0;in<out;in++){
                if (a[in]>a[in+1]){
                    swap(in,in+1);
                }
            }
        }
    }
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
