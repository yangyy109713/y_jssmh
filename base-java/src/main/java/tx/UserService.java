package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //Spring事务注解：当方法无异常时，正常提交；如果出现异常，则整个事务回滚
    @Transactional
    public void insertUser() {
        userDao.insert();
        System.out.println("插入完成。。。");
        int i = 10 / 0;//方法执行时，会抛异常（如果未使用事务，则插入语句仍会成功）
    }
}
