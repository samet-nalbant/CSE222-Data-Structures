/**
 * Branch
 */
public class Branch {
    private String branchName;
    private GenericArray<BranchEmployee> employees;
    private GenericArray<Product> inventory;
    /**
     * Constructor of the branch.
     * @param name of the branch
     */
    public Branch(String name){
        setName(name);
        employees = new GenericArray<>();
        inventory = new GenericArray<>();
    }
    /**
     * Getter function for branch name.
     * @return name of the branch.
     */
    public String getName(){return this.branchName;}
    /**
     * Setter function for the branch name.
     * @param name of the branch.
     */
    public void setName(String name){this.branchName = name;}
    /**
     * Getter function for the products in the branch.
     * @return genericarray of product.
     */
    public GenericArray<Product> getProducts(){return this.inventory;}
    @Override
    public boolean equals(Object o){
        
        if(o == null){
            return false;
        }
        if(!(o instanceof Branch)){
            return false;
        }
        return getName().equals(((Branch)o).getName());
    }
    /**
     * Getter function for the employees in the branch.
     * @return genericarray of employees.
     */
    public GenericArray <BranchEmployee> getEmployees(){return employees;}
}