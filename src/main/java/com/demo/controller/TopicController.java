package com.demo.controller;

import com.demo.entity.Topic;
import com.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getTopics();

    }

    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopicById(id);
    }

    @PostMapping(value = "/topics")
    public void addTopic(@RequestBody Topic tp){
        topicService.addNewTopic(tp);
    }

    @PutMapping(value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic tp, @PathVariable String id) {
        topicService.updateTopic(tp, id);
    }

    @DeleteMapping(value = "topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
