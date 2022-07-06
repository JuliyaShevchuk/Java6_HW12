package ua.goit.hw12.Task1;


public class Messanger implements Runnable {
    Worker worker;

    public Messanger(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        while (true) {
            worker.message();
        }
    }
}
