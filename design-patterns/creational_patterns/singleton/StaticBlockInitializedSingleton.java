package creational_patterns.singleton;

public class StaticBlockInitializedSingleton {
    private static final StaticBlockInitializedSingleton instance;

    static {
        try {
            instance = new StaticBlockInitializedSingleton();
        } catch (Exception ex) {
            throw new RuntimeException("Error when trying to create a singleton instance");
        }
    }

    private StaticBlockInitializedSingleton() {}

    public static StaticBlockInitializedSingleton getInstance() {
        return instance;
    }

    public void helloWorld() {
        System.out.printf("%s: Hello World%n", instance.hashCode());
    }

    public static void main(String[] args) {
        StaticBlockInitializedSingleton instance = StaticBlockInitializedSingleton.getInstance();
        instance.helloWorld();
        instance.helloWorld();
    }
}
