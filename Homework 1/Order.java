/**
 * Order
 */
public class Order {

    private String adressInformation;
    private String phoneNumber;
    private Product item;
    private int amount;
    /**
     * Constructor for Order.
     * @param item which is buyed.
     * @param phone number of customer.
     * @param adress of customer.
     * @param amount of product.
     */
    public Order(Product item,String phone,String adress,int amount){
        setAdress(adress);
        setPhone(phone);
        setProduct(item);
        setAmount(amount);
    }
    /**
     * Setter function for product.
     * @param item product which is bought.
     */
    public void setProduct(Product item){this.item = item;}
    /**
     * Getter function for product.
     * @return product which is bought.
     */
    public Product getProduct(){return this.item;}
    /**
     * Getter function for phone number.
     * @return phone number of customer.
     */
    public String getPhone(){return this.phoneNumber;}
    /**
     * Getter function for adress.
     * @return adress of customer.
     */
    public String getAdress(){return this.adressInformation;}
    /**
     * Setter function for adress.
     * @param adress of customer.
     */
    public void setAdress(String adress){this.adressInformation = adress;}
    /**
     * Setter function for phone.
     * @param phone of customer.
     */
    public void setPhone(String phone){this.phoneNumber = phone;}
    /**
     * Setter function for amount.
     * @param amount of product.
     */
    public void setAmount(int amount){this.amount = amount;}
    /**
     * Getter function for amount.
     * @return amount of product.
     */
    public int getAmount(){return this.amount;}
    @Override
    public String toString(){
        return "Adress: " + getAdress() + " - Phone Number: " + getPhone() + " - Product: " + item.toString() + "- x " + Integer.toString(getAmount());


    }
}