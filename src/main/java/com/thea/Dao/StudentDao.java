package com.thea.Dao;

import com.thea.Entity.Student;

import java.util.Collection;

/**
 * Created by Thea on 15/07/2017.
 */
public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
