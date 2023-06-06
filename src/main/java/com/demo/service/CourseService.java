package com.demo.service;

import com.demo.entity.Course;
import com.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses(String id){
        return new ArrayList<>(courseRepository.findCourseByTopicId(id));
    }

    public Course getCourseById(String id){
        return courseRepository.findById(id).orElse(null);
    }

    public void addNewCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);

    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
