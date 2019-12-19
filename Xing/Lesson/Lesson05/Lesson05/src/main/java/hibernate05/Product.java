package hibernate05;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

@Entity
@SecondaryTables(
		@SecondaryTable(name="Warehouse", pkJoinColumns= {
				@PrimaryKeyJoinColumn(name="product_id", referencedColumnName="number")
		})
)
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private double price;
	@Column(table="Warehouse")
	private boolean available;

}
