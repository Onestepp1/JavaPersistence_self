package io.namoosori.jpa;

import io.namoosori.jpa.entity.Customer;
import io.namoosori.jpa.entity.Major;
import io.namoosori.jpa.entity.Student;
import jakarta.persistence.*;

import java.util.List;

public class CustomerJpaExam {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        em.persist(Customer.sample());
//        tx.commit();
//        em.close();
        try {
            Major major = new Major("Economics", "College of Economics and Business");
            em.persist(major);

            Student student = new Student("Woody Jang", "3");
            student.setMajorId(major.getMajorId());
            em.persist(student);

            em.flush();
            em.clear();
            //student 검색
            Student foundStudent = em.find(Student.class, 1);
            System.out.println(foundStudent.toString());

            Major foundMajor = em.find(Major.class, foundStudent.getMajorId());
            System.out.println(foundMajor.toString());
            tx.commit();
        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();
    }
}
