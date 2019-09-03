package dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void print() {
        System.out.println("BookDaoImpl。。。。");
    }
}
