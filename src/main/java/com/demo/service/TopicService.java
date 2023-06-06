package com.demo.service;

import com.demo.entity.Topic;
import com.demo.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getTopics(){
        return topicRepository.findAll();
    }

    public Topic getTopicById (String id){
        return topicRepository.findById(id).orElse(null);
    }

    public void addNewTopic(Topic tp) {
        topicRepository.save(tp);
    }

    public void updateTopic(Topic tp, String id) {
        topicRepository.save(tp);

    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
