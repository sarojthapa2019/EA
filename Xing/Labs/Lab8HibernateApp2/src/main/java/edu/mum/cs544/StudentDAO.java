package edu.mum.cs544;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDAO {
    private static EntityManager em;
	private Collection<Student> studentlist = new ArrayList<Student>();

	public StudentDAO() {
//		Student student = new Student(12345, "Frank", "Brown");
//		Course course1 = new Course(1101, "Java", "A");
//		Course course2 = new Course(1102, "Math", "B-");
//		student.addCourse(course1);
//		student.addCourse(course2);
//		studentlist.add(student);

//        em = EntityManagerHelper.getEntityManager();
//		Student student = new Student(12345, "Frank", "Brown");
//		Course course1 = new Course(1101, "Java", "A");
//		Course course2 = new Course(1102, "Math", "B-");
//		student.addCourse(course1);
//		student.addCourse(course2);
//		em.getTransaction().begin();
//		em.persist(student);
//		em.getTransaction().commit();
	}

	public Student load(long studentid) {
//		for (Student student : studentlist) {
//			if (student.getStudentid() == studentid) {
//				return student;
//			}
//		}
//		return null;
        em = EntityManagerHelper.getEntityManager();
        EntityGraph<Student> graph = em.createEntityGraph(Student.class);
        graph.addAttributeNodes("courselist");
        TypedQuery<Student> query = em.createQuery("from Student where studentid=:id",Student.class);
        query.setParameter("id",studentid);
        query.setHint("javax.persistence.fetchgraph",graph);
        return query.getSingleResult();
	}
}
