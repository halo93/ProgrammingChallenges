package creational_patterns.singleton;

public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {}

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }

    public void helloWorld() {
        System.out.printf("%s: Hello World%n", instance.hashCode());
    }

    public static void main(String[] args) {
        EagerInitializedSingleton instance = EagerInitializedSingleton.getInstance();
        instance.helloWorld();
        instance.helloWorld();
    }
}
