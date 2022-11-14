package cw.learn.homework;
import java.util.Arrays;
import java.util.Scanner;
public class Ninetable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        nineninetable(n);
    }

    private static void nineninetable(int n){
        String[][] arr = new String[n][];
        for(int i = 0; i < n; i++){
            arr[i] = new String[i+1];
            for(int j = 0; j < i+1; j++){
                arr[i][j] = (i + 1) + "*" + (j + 1) + "=" + (i + 1) * (j + 1);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                System.out.print(arr[i][j]);
                if(i==j){
                    System.out.print("\n");
                } else {
                    System.out.print(' ');
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
