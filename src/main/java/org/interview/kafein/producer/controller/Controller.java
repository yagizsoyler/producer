package org.interview.kafein.producer.controller;

import java.util.Calendar;

import org.interview.kafein.producer.model.User;
import org.interview.kafein.producer.repo.UserRepository;
import org.interview.kafein.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
    UserRepository userRepository;
    
    @Autowired
    ProducerService producerService;

    @PostMapping("/user")
    public void saveUserAndPassMessage(@RequestBody User user){
    	user.setCreatedAt(Calendar.getInstance().getTime());
    	User newUser = userRepository.insert(user);
        this.producerService.writeMessage(newUser.getId(), user.getFollowerList());

    }
}
