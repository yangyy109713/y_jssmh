package dubboapi.test.service;

import dubboapi.test.bean.User;
import dubboapi.test.bean.UserAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        return null;
    }
}
