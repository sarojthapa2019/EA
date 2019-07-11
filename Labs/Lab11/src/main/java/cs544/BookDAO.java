package cs544;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDAO implements IBookDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Book> getAll() {
        return em.createQuery("from Book",Book.class).getResultList();
    }

    public void add(Book book) {
        em.persist(book);
    }

    public Book get(int id) {
        return em.find(Book.class,id);
    }

    public void update(Book book) {
        em.merge(book);
    }

    public void delete(int bookId) {
        Book bk = em.find(Book.class,bookId);
        em.remove(bookId);
    }
}
