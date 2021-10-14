/**
 * Customer
 */
public class Customer extends User{
    private Company firm;
    static int amount=0;
    private int customerID;

    private GenericArray<Order>previousOrders;
    /**
     * Constructor of customer.
     * @param name of customer.
     * @param surname of customer.
     * @param mail of customer.
     * @param password of customer.
     * @param company 
     */
    public Customer(String name,String surname,String mail,String password,Company company){
        super(name,surname,mail,password);
        customerID = amount++;
        setCompany(company);
        previousOrders = new GenericArray<>();
    }
    /**
     * Setter function for company.
     * @param company
     */
    public void setCompany(Company company){this.firm = company;}
    /**
     * Prints products in branches.
     */
    public void showProducts(){
        for(int i =0;i<getCompany().getBranchs().getSize();i++){
            System.out.println("------ Branch " + getCompany().getBranchs().at(i).getName()+"-----");
            for(int j =0;j<getCompany().getBranchs().at(i).getProducts().getSize();j++){
                System.out.println(getCompany().getBranchs().at(i).getProducts().at(j).toString()+"       x" +getCompany().getBranchs().at(i).getProducts().at(j).getAmount());
            }
            System.out.println("\n\n");
        }
    }
    /**
     * Search spesific product in stocks.
     * @param product
     * @return true if it's found.Otherwise returns false.
     */
    public boolean searchProducts(Product product){
        int index;
        boolean flag = false;
        for(int i =0;i<getCompany().getBranchs().getSize();i++){
            index = getCompany().getBranchs().at(i).getProducts().containsElement(product);
            if(index != -1){
                flag = true;
                System.out.println("------ Branch " + getCompany().getBranchs().at(i).getName()+"-----");
                System.out.println(getCompany().getBranchs().at(i).getProducts().at(index).toString()+"       x" +getCompany().getBranchs().at(i).getProducts().at(index).getAmount());
            }
        }        
        return flag;
    }
    /**
     * Prints customer's previous orders.
     * @return false if there is no previous order.Otherwise returns true.
     */
    public boolean viewOrders(){
        if(getOrders().getSize() == 0){
            return false;
        }
        for(int i=0;i<getOrders().getSize();i++){
            System.out.println(getOrders().at(i).toString());
        }
        return true;
    }
    /**
     * Prints available products for online shopping.
     */
    public void showAvailableProducts(){
        for(int i=0;i<getCompany().getStocks().getSize();i++){
            System.out.println((i+1)+")" + getCompany().getStocks().at(i).toString());
        }
    }
    /**
     * Buy product from system.
     * @param product 
     * @param amount of product
     * @param adress of customer
     * @param phone of customer
     * @return false if there isn't enough amount product.Otherwise return true.
     */
    public boolean shopOnline(Product product,int amount,String adress,String phone){
        int i,j;
        for(i=0;i<getCompany().getBranchs().getSize();i++){
            for(j =0;j<getCompany().getBranchs().at(i).getProducts().getSize();j++){
                if(product.equals(getCompany().getBranchs().at(i).getProducts().at(j)) && getCompany().getBranchs().at(i).getProducts().at(j).getAmount() >= amount){
                    getCompany().getBranchs().at(i).getProducts().at(j).decreaseAmount(amount);
                    getOrders().addElement(new Order(getCompany().getBranchs().at(i).getProducts().at(j), phone, adress, amount));
                    return true;
                }
            }
        }
        return false;    
    }
    /**
     * Setter function for customer ID.
     * @param ID of customer.
     */
    public void setID(int ID){this.customerID = ID;}
    /**
     * Getter function for customer ID.
     * @return ID of customer.
     */
    public int getID(){return this.customerID;}
    /**
     * Getter function for customer's previous orders.
     * @return GenericArray of previos orders.
     */
    public GenericArray <Order> getOrders(){return previousOrders;}
    /**
     * Getter function for company.
     * @return company
     */
    public Company getCompany(){return firm;}
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(!(o instanceof Customer)){
            return false;
        }
        
        return getMail().equals(((Customer)o).getMail()) && getPassword().equals(((Customer)o).getPassword()); 
    }
}
