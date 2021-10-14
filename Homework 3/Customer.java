/**
 * Customer
 */
public class Customer extends User{
    private Company firm;
    static int amount=0;
    private int customerID;

    private hybridList<Order>previousOrders;
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
        previousOrders = new hybridList<>();
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
        for(int i =0;i<getCompany().getBranchs().size();i++){
            System.out.println("------ Branch " + getCompany().getBranchs().get(i).getName()+"-----");
            for(int j =0;j<getCompany().getBranchs().get(i).getProducts().size();j++){
                System.out.println(getCompany().getBranchs().get(i).getProducts().get(j).toString()+"       x" +getCompany().getBranchs().get(i).getProducts().get(j).getAmount());
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
        for(int i =0;i<getCompany().getBranchs().size();i++){
            index = getCompany().getBranchs().get(i).getProducts().indexOf(product);
            if(index != -1){
                flag = true;
                System.out.println("------ Branch " + getCompany().getBranchs().get(i).getName()+"-----");
                System.out.println(getCompany().getBranchs().get(i).getProducts().get(index).toString()+"       x" +getCompany().getBranchs().get(i).getProducts().get(index).getAmount());
            }
        }        
        return flag;
    }
    /**
     * Prints customer's previous orders.
     * @return false if there is no previous order.Otherwise returns true.
     */
    public boolean viewOrders(){
        if(getOrders().size() == 0){
            return false;
        }
        for(int i=0;i<getOrders().size();i++){
            System.out.println(getOrders().get(i).toString());
        }
        return true;
    }
    /**
     * Prints available products for online shopping.
     */
    public void showAvailableProducts(){
        for(int i=0;i<getCompany().getStocks().size();i++){
            System.out.println((i+1)+")" + getCompany().getStocks().get(i).toString());
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
        for(i=0;i<getCompany().getBranchs().size();i++){
            for(j =0;j<getCompany().getBranchs().get(i).getProducts().size();j++){
                if(product.equals(getCompany().getBranchs().get(i).getProducts().get(j)) && getCompany().getBranchs().get(i).getProducts().get(j).getAmount() >= amount){
                    getCompany().getBranchs().get(i).getProducts().get(j).decreaseAmount(amount);
                    getOrders().add(new Order(getCompany().getBranchs().get(i).getProducts().get(j), phone, adress, amount));
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
     * @return list of previos orders.
     */
    public hybridList <Order> getOrders(){return previousOrders;}
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
