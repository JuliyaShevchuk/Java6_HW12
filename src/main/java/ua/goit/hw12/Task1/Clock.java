package ua.goit.hw12.Task1;

public class Clock implements Runnable{
    Worker worker;

    public Clock(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        while (true) {
            worker.clock();
        }
    }
}
