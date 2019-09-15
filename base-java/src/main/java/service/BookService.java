package service;

import dao.BookDao;
import domain.Car;
import domain.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class BookService {

    @Qualifier("bookDaoImpl")
    @Autowired
    //@Resource
    //@Inject
    private BookDao bookDao;

    public void printDao() {
        System.out.println("printDao：" + bookDao);
    }

    //Bean标注的方法创建对象时，方法参数从容器中获取
    @Bean
    public Color color(Car car) {
        Color color = new Color(car);
        return color;
    }
}
