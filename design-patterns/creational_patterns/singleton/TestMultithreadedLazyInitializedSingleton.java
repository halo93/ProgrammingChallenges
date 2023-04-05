package creational_patterns.singleton;

public class TestMultithreadedLazyInitializedSingleton {
    private static TestMultithreadedLazyInitializedSingleton instance;
    public String value;

    private TestMultithreadedLazyInitializedSingleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static TestMultithreadedLazyInitializedSingleton getInstance(String value) {
        if (instance == null) {
            instance = new TestMultithreadedLazyInitializedSingleton(value);
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread threadFoo = new Thread(new TestMultithreadedLazyInitializedSingleton.ThreadFoo());
        Thread threadBar = new Thread(new TestMultithreadedLazyInitializedSingleton.ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            TestMultithreadedLazyInitializedSingleton singleton = TestMultithreadedLazyInitializedSingleton.getInstance("Foo");
            // Different value
            System.out.println(singleton.value);
            // Different hashcode
            System.out.println(singleton.hashCode());
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            TestMultithreadedLazyInitializedSingleton singleton = TestMultithreadedLazyInitializedSingleton.getInstance("Bar");
            // Different value
            System.out.println(singleton.value);
            // Different hashcode
            System.out.println(singleton.hashCode());
        }
    }
}
