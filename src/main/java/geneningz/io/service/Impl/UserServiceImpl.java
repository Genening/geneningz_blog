package geneningz.io.service.Impl;


import geneningz.io.po.User;
import geneningz.io.dao.UserRepository;
import geneningz.io.service.UserService;
import geneningz.io.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

}


