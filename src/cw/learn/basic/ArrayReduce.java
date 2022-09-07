package cw.learn.basic;

public class ArrayReduce {
    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        int[] arrNew = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++){
            arrNew[i] = arr[i];
        }
        arrNew[arr.length] = 4;
        arr = arrNew;
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
