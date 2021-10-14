/**
 * Administrator
 */

public class Administrator extends User implements Authorized{
    private Company firm;
    private GenericArray<String> informations;
    /**
     * Constructor for the Administrator.
     * @param name of the administrator.
     * @param surname of the administrator.
     * @param mail of the administrator.
     * @param password of the administrator.
     * @param newCompany of the administrator.
     */
    public Administrator(String name,String surname,String mail,String password,Company newCompany){
        super(name,surname,mail,password);
        setCompany(newCompany);
        informations = new GenericArray<>();
    }
    /**
     * Getter function for the administrator messages.
     * @return messages of the administrator.
     */
    public GenericArray<String> getInformations(){return informations;}
    /**
     * Setter function for the administrator's company.
     * @param firm company of the administrator.
     */
    public void setCompany(Company firm){this.firm = firm;}
    /**
     * Getter function for the administrator's company.
     * @return administrator's company.
     */
    public Company getCompany(){return this.firm;}
    /**
     *  Prints the administrator messages from branch employee.
     */
    public void readInformations(){
        if(getInformations().getSize()== 0){
            System.out.println("There is no information!");
        }
        else{
            for(int i=0;i<getInformations().getSize();i++){
                System.out.println("Message "+i+" "+getInformations().at(i));
            }
        }
    }
    /**
     * Adds the employee according to Branch Name.
     * @param name of the branch employee.
     * @param surname the branch employee.
     * @param mail of the branch employee.
     * @param password the branch employee.
     * @param branchName of the branch employee.
     * @return It returns if the operation is successfull.If the branch couldn't found it return false and also it returns false if the employee surname and password is already registered to system and prints the warning message.
     */
    public boolean addEmployee(String name,String surname,String mail,String password,String branchName){
        int index = getCompany().getBranchs().containsElement(new Branch(branchName));
        int index2;
        if(index == -1){
            return false;
        }
        else{
            index2 = getCompany().getBranchs().at(index).getEmployees().containsElement(new BranchEmployee(name, surname, mail, password,getCompany(),getCompany().getBranchs().at(index)));
            if(index2 != -1){
                System.out.println("Employee is already registered!");
                return false;
            }
            getCompany().getBranchs().at(index).getEmployees().addElement(new BranchEmployee(name, surname, mail, password, getCompany(),getCompany().getBranchs().at(index)));
            return true;
        }
    }
    /**
     * Add to newBranch to generic array branch.
     * @param newBranch new branch which will be add.
     * @return It return false if the branch is already exist.Otherwise it returns false.
     */
    public boolean addBranch(Branch newBranch){
        return getCompany().getBranchs().addElement(newBranch);
    }
    /**
     * Removes the employee from the her/his branch.
     * @param employee who will be removed.
     * @param branchName of the branch 
     * @return false if the branch couldn't find if it the branchName is valid it trys to remove employee.If employee couldn't find it catchs the exception and print error to terminal and return false.It returns true if the remove sucessfull.
     */
    public boolean removeEmployee(BranchEmployee employee,String branchName){
        int index = getCompany().getBranchs().containsElement(new Branch(branchName));
        if(index == -1){
            return false;
        }
        else{
            try {
                getCompany().getBranchs().at(index).getEmployees().removeElement(employee);
            } catch (Exception e) {
                System.out.println("Employee couldn't Found\n");
                return false;
            }
           return true;
        }
    }
    /**
     * Removes the branch from the company.
     * @param oldBranch which will be removed.
     * @return false if the branch couldn't found and it prints the warning message.Otherwise it returns true.
     */
    public boolean removeBranch(Branch oldBranch){
        try {
            getCompany().getBranchs().removeElement(oldBranch);
        } 
        catch (Exception e) {
            System.out.println("Branch couldn't Found\n");
            return false;
        }
        return true;       
    }
    /**
     * Prints the existing branchs.
     */
    public void showBranchs(){
        if(getCompany().getBranchs().getSize() == 0){
            System.out.println("There is no Branch right now!\n\n");
        }
        for(int i=0;i<getCompany().getBranchs().getSize();i++){
            System.out.println("----BRANCHS----");
            System.out.println((i+1)+"-)"+getCompany().getBranchs().at(i).getName());
        }
        System.out.println("---------------\n\n");
    }
    /**
     * Prints the employees of the branch according to branchName.
     * @param branchName of branch which the employees will shown.
     */
    public void showBranchEmployees(String branchName){
        System.out.println(branchName);
        int index = getCompany().getBranchs().containsElement(new Branch(branchName));
        if(getCompany().getBranchs().at(index).getEmployees().getSize() == 0){
            System.out.println("There is no employee in this branch.\n");
        }
        else if(index == -1){
            System.out.println("Branch Couldn't Find");
        }
        else{
            System.out.println("Employees of " + getCompany().getBranchs().at(index).getName()+" :");
            for(int i=0;i<getCompany().getBranchs().at(index).getEmployees().getSize();i++){
                System.out.println((i+1)+") "+getCompany().getBranchs().at(index).getEmployees().at(i).toString());
            }
        }
    }
    /**
     * Querry products and prints the consumed produtcs to screen.
     */
    @Override
    public void queryProducts(){
        System.out.println("----Consumed Product List----");
        System.out.println("\n");
        for(int i=0;i<getCompany().getBranchs().getSize();i++){
            System.out.println("------ " +getCompany().getBranchs().at(i).getName()+" ------");
            for(int j=0;j<getCompany().getBranchs().at(i).getProducts().getSize();j++){
                if(getCompany().getBranchs().at(i).getProducts().at(j).getAmount() == 0){
                    System.out.println(getCompany().getBranchs().at(i).getProducts().at(j).toString());
                }
            }
            System.out.println("\n");
        }
    }
}