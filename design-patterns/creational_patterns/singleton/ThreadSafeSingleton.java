package creational_patterns.singleton;

import java.util.Objects;

/**
 * This implementation works fine and provides thread-safety,
 * but it reduces the performance because of the cost associated with the synchronized method,
 * although we need it only for the first few threads that might create separate instances
 */

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    public String value;

    private ThreadSafeSingleton(String value) {
        this.value = value;
    }

    public static synchronized ThreadSafeSingleton getInstance(String value) {
        if (Objects.isNull(instance)) {
            instance = new ThreadSafeSingleton(value);
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread threadFoo = new Thread(new ThreadSafeSingleton.ThreadFoo());
        Thread threadBar = new Thread(new ThreadSafeSingleton.ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("Foo");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("Bar");
            System.out.println(singleton.value);
        }
    }
}
