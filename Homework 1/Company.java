/**
 * Company
 */
public class Company {
    private String companyName;
    private Administrator admin;
    private GenericArray <Branch> branchs;
    private GenericArray <Customer> customers; 
    private GenericArray <Product> stock;
    /**
     * Constructor for the company.
     * @param name of the company.
     */
    public Company(String name){
        setName(name);
        branchs = new GenericArray<>();
        customers = new GenericArray<>();
        stock = new GenericArray<>();
    }
    /**
     * Controls the administration's password and string to enter the system.
     * @param mail of the administrator.
     * @param password of the password.
     * @return false if the password or mail is invalid.Otherwise it returns true.
     */
    public boolean adminLogIn(String mail,String password){
        if(mail.equals(admin.getMail()) && password.equals(admin.getPassword())){
            return true;
        }
        return false;
    }
    /**
     * Controls the employee's password and string to enter the system
     * @param mail of the employee.
     * @param password of the employee.
     * @return false if the password or mail is invalid.Otherwise it returns true.
     */
    public boolean employeeLogIn(String mail,String password){
        int index;
        for(int i=0;i<getBranchs().getSize();i++){
            index = getBranchs().at(i).getEmployees().containsElement(new BranchEmployee("", "", mail, password,this,null));
            if(index != -1){
                return true;
            }
        }
        return false;
    }
    /** 
     * Getter function for branchemployee.
     * @param mail of the branch employee.
     * @param password of the branch employee
     * @return BranchEmployee 
     */
    public BranchEmployee getEmployee(String mail,String password){
        int index = -1;
        int i;
        for(i=0;i<getBranchs().getSize();i++){
            index = getBranchs().at(i).getEmployees().containsElement(new BranchEmployee("", "", mail, password,this,null));
            if(index != -1){
                break;
            }
        }
        return getBranchs().at(i).getEmployees().at(index);
    }
    /**
     * Controls the customer's password and string to enter the system.
     * @param mail of the customer
     * @param password of the customer
     * @return false if the password or mail is invalid.Otherwise it returns true.
     */
    public boolean customerLogIn(String mail,String password){
        int index = getCustomers().containsElement(new Customer(" "," ",mail,password,this));
        if(index != -1){
            return true;
        }
        return false;
    }
    /**
     * Subscribe customer to the customer database.if the arguments are valid prints customer id.
     * @param name of the customer
     * @param surname of the customer
     * @param mail of the customer
     * @param password of the customer
     * @return false if the customer mail is already taken.Otherwise it return true.
     */
    public boolean customerSubscribe(String name,String surname,String mail,String password){
        for(int i=0;i<getCustomers().getSize();i++){
            if(mail.equals(getCustomers().at(i).getMail()) == true){
                return false;
            }
        }
        customers.addElement(new Customer(name, surname, mail, password, this));
        int index = getCustomers().containsElement(new Customer("name","surname",mail,password,this));
        System.out.println("Your customer id is: " + getCustomers().at(index).getID());
        return true;
    /**
     * Create prodct database for online shopping from the branchs.
     */
    }
    public void fillStocks(){
        for(int i=0;i<getBranchs().getSize();i++){
            for(int j=0;j<getBranchs().at(i).getProducts().getSize();j++){
                stock.addElement(getBranchs().at(i).getProducts().at(j));
            }
        }
    }
    /**
     * Getter function for products amount in stock.
     * @return products amount.
     */
    public int getAvailableProductsAmount(){return getStocks().getSize();}
    /**
     * Getter function for products in stock.
     * @return GenericArray of products.
     */
    public GenericArray<Product> getStocks(){return this.stock;}
    /**
     * Setter function for company name.
     * @param name of company.
     */
    public void setName(String name){this.companyName = name;}
    /**
     * Getter function for company name.
     * @return name of the company.
     */
    public String getName(){return this.companyName;}
    /**
     * Getter function for branchs in company.
     * @return GenericArray of branchs.
     */
    public GenericArray<Branch> getBranchs(){return branchs;}
     /**
     * Getter function for customers.
     * @return GenericArray of customers.
     */   
    public GenericArray<Customer> getCustomers(){return customers;}
    /**
     * Getter function for administrator in company.
     * @return administrator of company.
     */
    public Administrator getAdmmin(){return admin;}
    /**
     * Setter function for administrator in company.
     * @param admin of company
     */
    public void setAdmin(Administrator admin){this.admin = admin;}

    
}