package ua.goit.hw12.Task1;

public class Worker {
    int minutes = 0;
    int seconds = 0;

    public void clock() {
        synchronized (Test.lock) {
            System.out.println(minutes + ":" + seconds);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
            }
            while (seconds % 5 == 0) {
                try {
                    System.out.println(minutes + ":" + seconds);
                    Test.lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Test.lock.notifyAll();
        }
    }

    public void message() {
        synchronized (Test.lock) {
            while (seconds % 5 != 0) {
                try {
                    Test.lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            seconds++;
            System.out.println("Прошло 5 секунд!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Test.lock.notifyAll();
        }
    }
}
