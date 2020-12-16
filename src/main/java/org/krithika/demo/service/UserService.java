package org.krithika.demo.service;

import org.krithika.demo.entity.User;
import org.krithika.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by administrator on 5/12/20.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

}
