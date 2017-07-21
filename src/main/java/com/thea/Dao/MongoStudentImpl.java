package com.thea.Dao;

import com.thea.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Thea on 15/07/2017.
 */

@Repository
@Qualifier("mongoData")
public class MongoStudentImpl implements StudentDao {


    @Override
    public Collection<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudent(Student student) {

    }
}
