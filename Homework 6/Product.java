import java.util.LinkedList;

public class Product {

	private String productName;
	private String ID;
	private String description;
	private int price;
	private int discountPrice;;
	private LinkedList<String> category;
	private String trader;
	
	
	/**
	 * Constructor for Product
	 * @param productName
	 * @param iD
	 * @param description
	 * @param price
	 * @param discountPrice
	 * @param trader
	 */
	public Product(String productName, String iD, String description, int price, int discountPrice,String trader) {
		super();
		this.productName = productName;
		ID = iD;
		this.description = description;
		this.price = price;
		this.discountPrice = discountPrice;
		this.setTrader(trader);
		category = new LinkedList<>();
	}

	/**
	 * Returns the categories of the product.
	 * @return LinkedList of string.
	 */
	public LinkedList<String> getCategory(){
		return category;
	}
	/**
	 * Add's category to product.
	 * @param category
	 */
	public void addCategory(String category) {
		this.category.add(category);
	}
	/**
	 * Return product name.
	 * @return
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * Sets product name.
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * Return product id.
	 * @return
	 */
	public String getID() {
		return ID;
	}
	/**
	 * Sets product id.
	 * @param ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	/**
	 * Return price of product.
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * Sets price of product.
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * Return discount price of product.
	 * @return
	 */
	public int getDiscountPrice() {
		return discountPrice;
	}
	/**
	 * Set discount price of product.
	 * @param discountPrice
	 */
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	/**
	 * Returns description of product.
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets description of product.
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Returns trader of product.
	 * @return
	 */
	public String getTrader() {
		return trader;
	}
	/**
	 * Sets trader of product.
	 * @param trader
	 */
	public void setTrader(String trader) {
		this.trader = trader;
	}
	/**
	 * Display product information.
	 */
	public void print() {
		System.out.println("ID: " + getID()+ " NAME: "+ getProductName()+" PRICE: "+ getPrice()+ " DISCOUNTED PRICE: "+ getDiscountPrice() + "DESCRIBTION: " + getDescription()+ "TRADER:" +getTrader());
		System.out.print("CATEGORY: ");
		for(int i=0;i<category.size();i++) {
			System.out.print(category.get(i)+ ">>");
		}
		System.out.print("\n");
	}
	
	
	
	
	
}
