package tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 声明式事务
 * 1.环境搭建：
 *  导入相关依赖：数据源、数据库驱动、Spring-jdbc模块
 * 2.配置数据源、JdbcTemplate操作数据库：Spring提供的简化数据库操作的工具
 * 3.给方法标注 @Transactional 注解，表示当前方法是一个事务方法
 *   只标注时，如未开启事务状态，不会生效
 * 4.@EnableTransactionManagement 开启基于注解的事务管理功能
 * 5.配置事务管理器 控制事务
 *   将事务管理器加入到容器中
 *    @Bean
 *    public PlatformTransactionManager transactionManager()
 */

@EnableTransactionManagement
@ComponentScan({"tx"}) //指定包扫描路径
@PropertySource("classpath:/application.properties")
@Configuration
public class MainConfigTx {

    @Value("${db.user}")
    private String user;

    @Value("${db.pwd}")
    private String pwd;

    @Value("${db.driverClass}")
    private String driverClass;

    @Value("${db.url}")
    private String url;


    //给容器中加入组件dataSource
    //第二次使用时，不会再次创建，会直接用容器中已有的dataSource
    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl(url);
        try {
            dataSource.setDriverClass(driverClass);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataSource;
    }

    //给容器中加入组件jdbcTemplate，方便数据库操作：增 删 改 查
    @Bean
    public JdbcTemplate jdbcTemplate(){
        //Spring对@Configuration类会特殊处理，给容器中加组件的方法，多次调用都只是从容器中查找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());//此处调用dataSource()，相当于从容器中找对应组件
        return jdbcTemplate;
    }

    //给容器中注册事务管理器
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());//事务管理器 管理数据源
    }
}
