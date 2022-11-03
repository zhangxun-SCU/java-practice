package cw.learn.re_advanced;

public class InnerClassExercise {
    public static void main(String[] args) {
        CellPhone phone = new CellPhone();
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床！！");
            }
        });
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("上课啦！！");
            }
        });
    }
}

class CellPhone{
    void alarmClock(Bell bell){
        bell.ring();
    }
}

interface Bell{
    void ring();
}