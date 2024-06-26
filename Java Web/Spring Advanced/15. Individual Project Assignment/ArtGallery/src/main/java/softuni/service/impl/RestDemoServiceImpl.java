package softuni.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.model.entity.User;
import softuni.repository.RestDemoRepository;
import softuni.service.RestDemoService;

import java.util.List;

@Service
public class RestDemoServiceImpl implements RestDemoService {

    private final RestDemoRepository userRepository;

    @Autowired
    public RestDemoServiceImpl(RestDemoRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
