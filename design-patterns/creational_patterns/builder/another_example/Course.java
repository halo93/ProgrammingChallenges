package creational_patterns.builder.another_example;

public class Course {

    private int courseId;
    private String courseName;
    private String courseLeader;
    private float ects;

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseLeader() {
        return courseLeader;
    }

    public float getEcts() {
        return ects;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseLeader='" + courseLeader + '\'' +
                ", ects=" + ects +
                '}';
    }

    private Course() {}

    private Course(int courseId, String courseName, String courseLeader, float ects) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseLeader = courseLeader;
        this.ects = ects;
    }

    public static class Builder {
        private int courseId;
        private String courseName;
        private String courseLeader;
        private float ects;

        public Builder courseId(int courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder courseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public Builder courseLeader(String courseLeader) {
            this.courseLeader = courseLeader;
            return this;
        }

        public Builder ects(float ects) {
            this.ects = ects;
            return this;
        }

        public Course build() {
            return new Course(courseId, courseName, courseLeader, ects);
        }
    }
}
