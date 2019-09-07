package configs;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import domain.Red;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile: 指定组件在哪个环境中被激活
 *      Spring提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *  如开发环境、测试环境、线上环境
 *      不指定时，任何环境下都能注册组件
 * 1.加了环境标识的组件（使用@Profile("xxx")注解时），只有环境被激活时才会注册到容器中
 * 默认标识：default
 * 2.@Profile("test") 写在整个类上，只有当指定环境和类上的标识一致时，整个配置类中的组件才会加在到容器中
 * 3.没有标识环境的组件，在任何环境中都会加载：如red
 */

@Profile("prod") //给整个配置类指定环境
@PropertySource("classpath:/application.properties")
public class MainConfiProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String dbUser;//使用@Value注解，从配置文件中取值

    private StringValueResolver valueResolver;

    private String driverClass;

    //未指定环境的组件，当类加载时，任何环境下都会注册到容器中
    @Bean
    public Red red(){
        return new Red();
    }

    //@Profile("default") //默认标识
    @Profile("test") //默认标识
    @Bean("dataSourceTest")
    //直接在参数里使用@Value注解，从配置文件中取值
    public DataSource dataSourceTest(@Value("${db.pwd}") String pwd){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(dbUser);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://47.111.105.143:3306/dbxiu");
        try {
            dataSource.setDriverClass(driverClass);
        }catch (PropertyVetoException e){
            e.printStackTrace();
        }
        return dataSource;
    }

    @Profile("dev")
    @Bean("dataSourceDev")
    //直接在参数里使用@Value注解，从配置文件中取值
    public DataSource dataSourceDev(@Value("${db.pwd}") String pwd){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(dbUser);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://47.111.105.143:3306/sxfy_f");
        try {
            dataSource.setDriverClass(driverClass);
        }catch (PropertyVetoException e){
            e.printStackTrace();
        }
        return dataSource;
    }

    @Profile("prod")
    @Bean("dataSourceProd")
    //直接在参数里使用@Value注解，从配置文件中取值
    public DataSource dataSourceProd(@Value("${db.pwd}") String pwd){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(dbUser);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://47.111.105.143:3306/nba");
        try {
            dataSource.setDriverClass(driverClass);
        }catch (PropertyVetoException e){
            e.printStackTrace();
        }
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.valueResolver = stringValueResolver;
        driverClass = valueResolver.resolveStringValue("${db.DriverClass}");//使用StringValueResolver从配置文件中取值
    }
}
