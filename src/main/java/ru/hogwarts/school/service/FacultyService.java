package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;


import java.util.*;

@Service
public class FacultyService {
    private Map<Integer, Faculty> faculties = new HashMap<>();
    private int lastId = 0;

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        faculties.put(lastId, faculty);
        return faculty;
    }

    public Faculty getFaculty(int id) {
        return faculties.get(id);
    }

    public Collection<Faculty> getAllFaculties() {
        return faculties.values();
    }

    public Faculty editFaculty(Faculty faculty) {
        if (faculties.containsKey(faculty.getId())){
            faculties.put(faculty.getId(),faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty(int id){
        return faculties.remove(id);
    }

    public Collection<Faculty> findByColor(String color) {
        List<Faculty> result = new ArrayList<>();
        for (Faculty faculty : faculties.values()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }
}
