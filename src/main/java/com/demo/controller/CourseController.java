package com.demo.controller;

import com.demo.entity.Course;
import com.demo.entity.Topic;
import com.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseService.getCourses(topicId);
    }

    @GetMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return courseService.getCourseById(courseId);
    }

    @PostMapping(value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addNewCourse(course);
    }

    @PutMapping(value = "/topics/{topicId}/courses")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @DeleteMapping(value = "/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId){
        courseService.deleteCourse(courseId);
    }
}
