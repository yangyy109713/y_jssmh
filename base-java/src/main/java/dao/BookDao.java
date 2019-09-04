package dao;

import org.springframework.stereotype.Repository;

/**
 * BookDao如果是接口，必须要有实现类，且将实现类注入到容器中
 * 具体见BookDaoImpl.java 和 BookService
 * 否则 Spring容器装配Bean时会报错：No qualifying bean of type
 * 只知其然，未知其所以然
 */

//组件名成为类名（首字母小写）
@Repository
public interface BookDao {
    void print();
}