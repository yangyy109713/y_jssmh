package dao;

import org.springframework.stereotype.Repository;

/**
 * BookDao如果是接口，必须要有实现类
 * 否则，容器注入时会报错：No qualifying bean of type
 * 为什么？
 */

@Repository
public interface BookDao {
    void print();
}