/**
 * Branch
 */
public class Branch {
    private String branchName;
    private kwArrayList<BranchEmployee> employees;
    private hybridList<Product> inventory;
    /**
     * Constructor of the branch.
     * @param name of the branch
     */
    public Branch(String name){
        setName(name);
        employees = new kwArrayList<>();
        inventory = new hybridList<>();
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
     * @return list of product.
     */
    public hybridList<Product> getProducts(){return this.inventory;}
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
     * @return list of employees.
     */
    public kwArrayList<BranchEmployee> getEmployees(){return employees;}
}