package ua.goit.hw12.Task1;

public class Test {
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread clocker = new Thread(new Clock(worker));
        Thread messager = new Thread(new Messanger(worker));
        clocker.start();
        messager.start();
    }
}
