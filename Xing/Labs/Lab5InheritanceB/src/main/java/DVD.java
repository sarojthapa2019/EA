import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DVD")
public class DVD extends Product {
    private String genre;

    public DVD(){
        super();
    }

    public DVD(String name, String desc, String genre){
        super(name, desc);
        this.genre = genre;
    }

    public String getGenre(){
        return this.genre;
    }

    @Override
    public String toString(){
        return super.toString()+" DVD genre:"+genre;
    }
}
