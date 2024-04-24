package intern.dev.App.service;

import intern.dev.App.entity.User;
import intern.dev.App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAll() {

        return userRepository.findAll();

    }

    @Override
    public User findById(String login_id) {

        Optional<User> result = userRepository.findById(login_id);

        User user = null;

        if(result.isPresent()) {
            user = result.get();
        }
        else {
            throw new RuntimeException("Did not find user login - " + login_id);
        }

        return user;

    }

    @Override
    public User save(User theUser) {

        String word = theUser.getPassword().trim();

        theUser.setPassword("{noop}" + word);

        return userRepository.save(theUser);
    }

}
