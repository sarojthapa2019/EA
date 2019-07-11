package cs544;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Resource
    private IBookDAO bookDAO;

    public void add(Book book){
        bookDAO.add(book);
    }

    public Book get(int id){
        return bookDAO.get(id);
    }

    public List<Book> getAll(){
        return bookDAO.getAll();
    }

    public void update(Book book){
        bookDAO.update(book);
    }

    public void delete(int id){
        bookDAO.delete(id);
    }
}
