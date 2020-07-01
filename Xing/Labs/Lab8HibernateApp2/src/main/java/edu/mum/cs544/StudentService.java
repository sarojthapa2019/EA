package edu.mum.cs544;

import javax.persistence.EntityManager;

public class StudentService {

	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        em.getTransaction().begin();
        Student student = studentdao.load(studentid);
        em.getTransaction().commit();
		return student;
	}
}