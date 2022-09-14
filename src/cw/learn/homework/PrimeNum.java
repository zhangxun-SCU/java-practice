package cw.learn.homework;

public class PrimeNum {
    public static void main(String[] args) {
        System.out.print(2 + " ");
        for(int i = 3; i <= 2000; i+=2){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    static Boolean isPrime(int num){
        if(num <= 2){

            return num>1;
        }
        for(int i = 2; i <= (int)Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
