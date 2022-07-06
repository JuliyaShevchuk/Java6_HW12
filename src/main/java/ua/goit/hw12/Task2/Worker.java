package ua.goit.hw12.Task2;

import java.util.ArrayList;

public class Worker {
    private int counterFinish = 20;
    private ArrayList<String> array = new ArrayList<>();

    private void fizz() {
        for (int i = 3; i <= counterFinish; i += 3) {
            array.set(i - 1, "Fizz");
            System.out.println(Thread.currentThread().getName() + " " + i + " - Fizz");
            if ((i + 3) % 5 == 0) {
                i += 3;
            }
        }
    }

    private void buzz() {
        for (int i = 5; i <= counterFinish; i += 5) {
            array.set(i - 1, "Buzz");
            System.out.println(Thread.currentThread().getName() + " " + i + " - Buzz");
            if ((i + 5) % 3 == 0) {
                i += 5;
            }
        }
    }

    private void fizzbuzz() {
        for (int i = 15; i <= counterFinish; i += 15) {
            array.set(i - 1, "FizzBuzz");
            System.out.println(Thread.currentThread().getName() + " " + i + " - FizzBuzz");
        }
    }

    private void number() {
        for (int i = 1; i <= counterFinish; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
            } else if (i % 5 == 0) {
            } else if (i % 3 == 0) {
            } else {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }

    public void start() {
        for (int i = 1; i <= counterFinish; i++) {
            array.add("" + i);
        }
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                fizz();
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                buzz();
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                fizzbuzz();
            }
        });
        Thread threadD = new Thread(new Runnable() {
            @Override
            public void run() {
                number();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(array.toString());
    }
}
