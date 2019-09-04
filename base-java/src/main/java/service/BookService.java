package service;

import dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Qualifier("bookDao")
    @Autowired
    private BookDao bookDao;

    /*@Autowired
    private BookDaoImpl bookDao;*/

    public void printDao(){
        System.out.println("printDao："+ bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
