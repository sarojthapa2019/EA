package StudentCourse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private int id;
    private String name;
    @ManyToMany
    private List<Course> courses;

    Student(int id, String name){
        this.id = id;
        this.name = name;
        courses = new ArrayList<Course>();
    }

    public void addCourse(Course course){
        this.courses.add(course);
        course.addStudents(this);
    }

    public String getName(){
        return name;
    }
}
