package intern.dev.App.service;

import intern.dev.App.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String login_id);

    User save(User theUser);

}
