package hibernate07;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
//	@LazyCollection(LazyCollectionOption.EXTRA)
    private List<Book> books = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
	@LazyCollection(LazyCollectionOption.EXTRA)
    private List<Movie> movies = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private SalesRep salesRep;

    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Customer(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean addBook(Book b) {
        return books.add(b);
    }

    public boolean addMovie(Movie m) {
        return movies.add(m);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
