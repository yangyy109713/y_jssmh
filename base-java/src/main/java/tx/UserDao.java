package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;//自动装配容器中的jdbcTemplate

    public void insert() {
        String sql = "insert into f_user (username, password, realName) values (?, ?, ?)";
        String userName = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql, userName, userName, userName);//参数1：sql语句，参数2：可变参数，和sql语句对应
    }
}
