public class Main {

    public static void main(String[] args) {
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        Thread5 thread5 = new Thread5();
        thread2.start();
        thread3.start();
        thread5.start();
    }
}
class Thread2 extends Thread implements Runnable{

    @Override
    public void run() {
        for (int i=0; i < 100 ; i++){
            System.out.println(2*i);
        }

    }
}
class Thread3 extends Thread implements Runnable{

    @Override
    public void run() {
        for (int i=0; i < 100 ; i++){
            System.out.println(5*i);
        }

    }
}
class Thread5 extends Thread implements Runnable{

    @Override
    public void run() {
        for (int i=0; i < 100 ; i++){
            System.out.println(5*i);
        }

    }
}