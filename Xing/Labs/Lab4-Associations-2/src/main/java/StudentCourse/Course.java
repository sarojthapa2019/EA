package StudentCourse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private int id;
    private String title;
    @ManyToMany
    private List<Student> students;

    Course(){students = new ArrayList<Student>();}
    Course(int id, String title){
        this.id = id;
        this.title = title;
        students = new ArrayList<Student>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student students) {
        this.students.add(students);

    }
}
