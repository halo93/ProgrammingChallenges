package creational_patterns.builder.another_example;

public class Client {
    public static void main(String[] args) {
        Course course = Course.builder()
                .courseId(1)
                .courseName("Algebra")
                .ects(30)
                .courseLeader("Long").build();
        System.out.println(course);
    }
}
