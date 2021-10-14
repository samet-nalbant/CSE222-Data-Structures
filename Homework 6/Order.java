
public class Order {

	String customerID, trader;
	Product product;
	/**
	 * Constructor for the order.
	 * @param customerID
	 * @param product
	 */
	public Order(String customerID, Product product) {
		super();
		this.customerID = customerID;
		this.trader = product.getTrader();
		this.product = product;
	}
	/**
	 * Returns the customer ID.
	 * @return
	 */
	public String getCustomerID() {
		return customerID;
	}
	/**
	 * Sets the customer ID.
	 * @param customerID
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	/**
	 * Returns the name of trader.
	 * @return
	 */
	public String getTrader() {
		return trader;
	}
	/**
	 * Returns the product which is in the order.
	 * @return
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * Sets the product which is in the order.
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

}
