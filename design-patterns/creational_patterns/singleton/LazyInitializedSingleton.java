package creational_patterns.singleton;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {}

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }

    public void helloWorld() {
        System.out.printf("%s: Hello World%n", instance.hashCode());
    }

    public static void main(String[] args) {
        LazyInitializedSingleton instance = LazyInitializedSingleton.getInstance();
        instance.helloWorld();
        instance.helloWorld();
    }


}
