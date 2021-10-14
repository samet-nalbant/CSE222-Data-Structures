/**
 * Branch Employee
 */

import java.util.Scanner;

public class BranchEmployee extends User implements Authorized{
    private Branch branch;
    private Company firm;
    /**
     * Constructor for the branch employeee.
     * @param name of the employee.
     * @param surname of the employee.
     * @param mail of the employee.
     * @param password of the employee.
     * @param company which the employee worked.
     * @param branch which the employee worked.
     */
    public BranchEmployee(String name,String surname,String mail,String password,Company company,Branch branch){
        super(name,surname,mail,password);
        setBranch(branch);
        setCompany(company);
    }
    /**
     * Setter function for employee's branch.
     * @param branch which the employee worked.
     */
    public void setBranch(Branch branch){this.branch = branch;}
    /**
     * Getter function for the employee's branch.
     * @return the branch which employee worked.
     */
    public Branch getBranch(){return this.branch;}
    /**
     * Getter function for the employee's company.
     * @return the company which employee worked.
     */
    public Company getCompany(){return this.firm;}
    /**
     * Setter function for the employee's company.
     * @return the company which employee worked.
     */
    public void setCompany(Company company){this.firm = company;}
    /**
     * Create subscription for the customer which shop from branch and doesn't have subscription.
     * @return id of the new created customer.
     */
    public int addCustomer(){
        int index;
        Scanner input = new Scanner(System.in);
        String name,surname,mail,password;
        System.out.println("Enter the customer name:");
        name = input.nextLine();
        System.out.println("Enter the customer surname:");
        surname = input.nextLine();
        System.out.println("Enter the customer mail:");
        mail = input.nextLine();
        System.out.println("Enter the customer password:");
        password = input.next();
        firm.customerSubscribe(name, surname, mail, password);
        index = getCompany().getCustomers().containsElement(new Customer(name, surname, mail, password, getCompany()));
        System.out.println("Customer ID:"+index);
        return getCompany().getCustomers().at(index).getID();
    }
    /**
     * Add spesific product to stock.
     * @param newProduct which will be add to stock.
     * @param amount of the product.
     */
    public void addProduct(Product newProduct,int amount){
        int index = getBranch().getProducts().containsElement(newProduct);
        if(index == -1){
            getBranch().getProducts().addElement(newProduct);
            index = getBranch().getProducts().containsElement(newProduct);
        }
        getBranch().getProducts().at(index).increaseAmount(amount);
        firm.fillStocks();
    }
    /**
     * Remove product from the branch's stock.
     * @param oldProduct which will be removed.
     * @return false if the product couldn't found and prints warning otherwise returns true.
     */
    public boolean removeProduct(Product oldProduct){
        try {
            getBranch().getProducts().removeElement(oldProduct);
        } catch (Exception e) {
            System.out.println("Product couldn't Found\n");
            return false;
        }
        firm.fillStocks();
        return true;
    }
    /**
     * Finds the customer index according to customerID.
     * @param customerID of customer.
     * @return index of the customer according to customerID if customer not subscribed yet it returns -1.
     */
    public int findCustomer(int customerID){
        for(int i=0;i<getCompany().getCustomers().getSize();i++){
            if(getCompany().getCustomers().at(i).getID() == customerID){
                return i;
            }
        }
        return -1;
    }
    /**
     * Prints the customer's previous orders to screen.
     * @param customerID of customer
     */
    public void showOrders(int customerID){
        int index = findCustomer(customerID);
        if(index == -1){
            System.out.println("Customer ID is Invalid!");
        }
        else if(getCompany().getCustomers().at(index).getOrders().getSize() == 0){
            // Throw exception.
            System.out.println("There is no previous order!");
        }
        else{
            for(int i=0;i<getCompany().getCustomers().at(index).getOrders().getSize();i++){
                System.out.println(getCompany().getCustomers().at(index).getOrders().at(i).toString());
            }
        }
    }
    /**
     * Adds new order to customer's previous orders.
     * @param customerID of the customer.
     * @param newOrder of the customer.
     */
    public void addOrder(int customerID,Order newOrder){
        int index = findCustomer(customerID);
        if(index == -1){
            addCustomer();
        }
        else{
            getCompany().getCustomers().at(index).getOrders().addElement(newOrder);
        }
    }
    /**
     * Make sale from branch.
     * @param CustomerID of the customer.
     * @param phone of the customer.
     * @param adress of the customer.
     * @param product which will buy.
     * @param amount of the product.
     * @return false if somethings went wrong and prints warning.Otherwise it returns true.
     */
    public boolean makeSale(int CustomerID,String phone,String adress,Product product,int amount){
        int index = getBranch().getProducts().containsElement(product);
        int index2=0;
        if(index == -1){
            System.out.println("Product Couldn't Found");
            return false;
        }
        else if(getBranch().getProducts().at(index).getAmount() < amount){
            System.out.println("Less Product!");
            System.out.println("Administrator Informed!");
            getCompany().getAdmmin().getInformations().addElement(" Products need to be supplied to "+ getBranch().getName()+" Branch -"+product.toString()+" x "+(amount-getBranch().getProducts().at(index).getAmount()));
            return false;
        }
        if(CustomerID == -2){
            System.out.println("You are directing to new subcribtion menu");
            CustomerID = addCustomer();
        }
        else{
            index2= findCustomer(CustomerID);
            if(index2 == -1){
            
                System.out.println("Customer ID is Invalid!\nYou are directing to new subcribtion menu");
                CustomerID = addCustomer();
            }
        }
        addOrder(CustomerID,new Order(product,phone,adress,amount));
        getBranch().getProducts().at(index).decreaseAmount(amount);
        firm.fillStocks();
        return true;
    }
    /**
     * Prints the stock of the branch.
     */
    public void showProducts(){
        for(int i=0;i<getBranch().getProducts().getSize();i++){
            System.out.println((i+1)+")"+getBranch().getProducts().at(i).toString()+" x"+getBranch().getProducts().at(i).getAmount());
        }
        System.out.println("\n\n");
    }
    /*
    *  Query the products.
    */
    @Override
    public void queryProducts(){
        showProducts();
    }
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(!(o instanceof BranchEmployee)){
            return false;
        }
        return getMail().equals(((BranchEmployee)o).getMail()) && getPassword().equals(((BranchEmployee)o).getPassword()); 
    }

    @Override
    public String toString(){
        return "Name: "+getName() + " - Surname: "+getSurname() + " - Mail: " + getMail()+" - Password: " +getPassword()+"\n";
    }
}