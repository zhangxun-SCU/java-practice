package cw.learn.basic;

public class ArrayAssign {
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        System.out.println("---------arr1----------");
        for(int i = 0; i < 3; i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();


        arr2[1] = 10;
        System.out.println("---------arr1----------");
        for(int i = 0; i < 3; i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }
}
