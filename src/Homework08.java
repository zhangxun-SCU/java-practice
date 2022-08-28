public class Homework08 {
    public static void main(String[] args){
        double sum = 0;
        for(int i = 1; i <= 100; i++){
            if(i%2==0){
                sum -= 1/(double)i;
            }else{
                sum += 1/(double)i;
            }
        }
        System.out.println("sum=" + sum);
    }
}
