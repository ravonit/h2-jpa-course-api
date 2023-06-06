package com.demo.repository;

import com.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {

    @Query(value="SELECT x FROM Course x WHERE x.topic.Id = :topicId")
    public List<Course> findCourseByTopicId(String topicId);

}
