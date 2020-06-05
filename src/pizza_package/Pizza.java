package pizza_package;

import java.io.Serializable;

public class Pizza  implements Serializable {

	private int id;
    private String DesignPizz;
    private double price;
    private String Description;
   
    public Pizza( ) {
	 
	}
    
	public Pizza(int id, String designPizz, double price, String description) {
		super();
		this.id = id;
		this.DesignPizz = designPizz;
		this.price = price;
		this.Description = description;
	}
	@Override
	public String toString() {
		return "Pizza [id=" + id + ", DesignPizz=" + DesignPizz + ", price=" + price + ", Description =" + Description + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignPizz() {
		return DesignPizz;
	}
	public void setDesignPizz(String designPizz) {
		DesignPizz = designPizz;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	

}
