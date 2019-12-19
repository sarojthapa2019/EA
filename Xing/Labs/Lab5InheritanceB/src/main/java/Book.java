import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
public class Book extends Product {
    private String title;

    Book(){
        super();
    }

    Book(String name, String desc, String title){
        super(name, desc);
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    @Override
    public String toString(){
        return super.toString()+" Book Title:"+title;
    }
}
