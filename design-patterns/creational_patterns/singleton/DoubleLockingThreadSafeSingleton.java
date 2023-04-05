package creational_patterns.singleton;

import java.util.Objects;

public class DoubleLockingThreadSafeSingleton {
    private static DoubleLockingThreadSafeSingleton instance;

    public String value;

    private DoubleLockingThreadSafeSingleton(String value) {
        this.value = value;
    }

    public static DoubleLockingThreadSafeSingleton getInstance(String value) {
        if (Objects.isNull(instance)) {
            synchronized (DoubleLockingThreadSafeSingleton.class) {
                if (Objects.isNull(instance)) {
                    instance = new DoubleLockingThreadSafeSingleton(value);
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            DoubleLockingThreadSafeSingleton singleton = DoubleLockingThreadSafeSingleton.getInstance("Foo");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            DoubleLockingThreadSafeSingleton singleton = DoubleLockingThreadSafeSingleton.getInstance("Bar");
            System.out.println(singleton.value);
        }
    }
}
