// 向升序数组中添加元素，保持升序
import java.util.Scanner;
public class Homework04 {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        int[] arr = {10, 12, 45, 90};
        do{
//         输入一个数
            System.out.print("Input:");
            int numInput = myScanner.nextInt();
//        找到位置
            int index = -1;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] > numInput){
                    index = i;
                    break;
                } else {
                    index = arr.length;
                }
            }
//            System.out.println(index);
//        扩容并插入
            int[] arrNew = new int[arr.length + 1];
            for(int i = 0; i < arrNew.length; i++){
                if(i == index){
                    arrNew[i] = numInput;
                } else if (i < index) {
                    arrNew[i] = arr[i];
                } else {
                    arrNew[i] = arr[i - 1];
                }
            }
//            arr指向arrNew
            arr = arrNew;
//            是否继续
            System.out.print("continue?(y/n):");
            char flag = myScanner.next().charAt(0);
            if(flag == 'n'){
                break;
            }
        }while(true);
//        输出
        for(int num: arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
