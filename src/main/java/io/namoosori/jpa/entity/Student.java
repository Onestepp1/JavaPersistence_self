package io.namoosori.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Student_tb")
public class Student {
    @Id
    @GeneratedValue
    private Long studentId;

    private String studentName;
    private String grade;
    private Long majorId;

    public Student(String studentName, String grade) {
        this.studentName = studentName;
        this.grade = grade;
    }
}
