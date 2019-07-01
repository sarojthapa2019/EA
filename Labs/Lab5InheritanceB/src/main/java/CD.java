import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CD")
public class CD extends Product {
    private String artist;

    public CD(){
        super();
    }

    public CD(String name, String desc, String artist){
        super(name,desc);
        this.artist = artist;
    }

    @Override
    public String toString(){
        return super.toString()+" CD Artist:"+artist;
    }
}
