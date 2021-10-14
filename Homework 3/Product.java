/**
 * Product
 */

public abstract class Product implements CompanyProducts{

    private String productModel;
    private String productColour;
    private int amount =0;
    /**
     * Constructor for Product which doesn't have colour.
     * @param model of product.
     */
    public Product(String model){
        this.setModel(model);
    }
    /**
     * Constructor for product.
     * @param model of product.
     * @param colour of product.
     */
    public Product(String model,String colour){
        this.setModel(model);
        this.setColour(colour);
    }
    /**
     * Setter function for model.
     * @param model of product
     */
    public void setModel(String model){this.productModel = model;}
    /**
     * Getter function for model.
     * @return model of the product.
     */
    public String getModel(){return this.productModel;}
    /**
     * Setter function for colour.
     * @param colour of the product.
     */
    public void setColour(String colour){this.productColour = colour;}
    /**
     * Getter function for colour.
     * @return colour of the product.
     */
    public String getColour(){return this.productColour;}
    /**
     * Getter function for amount.
     * @return amount of product.
     */
    public int getAmount(){return this.amount;}
    /**
     * Increase amount of product one times.
     */
    public void increaseAmount(){amount++;}
    /**
     * Increase amount of product according to number.
     * @param number value of product amount which will be increase
     */
    public void increaseAmount(int number){amount += number;}
    /**
     * Decrease amount of product one times.
     * @return false if there isn't any product in stock.otherwise returns true.
     */
    public boolean decreaseAmount(){
        if(getAmount() == 0){
            return false;
        }
        amount--;
        return true;
    }
    /**
     * Decrease amount of product according to number.
     * @param numbervalue of product amount which will be decrease
     * @returnfalse if there isn't enough product in stock.otherwise returns true.
     */
    public boolean decreaseAmount(int number){
        if(getAmount() < number){
            return false;
        }
        amount -= number;
        return true;
    }
}