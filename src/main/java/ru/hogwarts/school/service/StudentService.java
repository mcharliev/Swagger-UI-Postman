package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentService {
    private Map<Integer, Student> students = new HashMap<>();
    private int lastId = 0;

    public Student addStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(int id) {
        return students.remove(id);
    }

    public Collection<Student> findStudents(int age) {
        List<Student> list = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                list.add(student);
            }
        }
        return list;
    }
}
