/**
 * Administrator
 */

public class Administrator extends User implements Authorized{
    private Company firm;
    private hybridList<String> informations;
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
        informations = new hybridList<>();
    }
    /**
     * Getter function for the administrator messages.
     * @return messages of the administrator.
     */
    public hybridList<String> getInformations(){return informations;}
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
        if(getInformations().size()== 0){
            System.out.println("There is no information!");
        }
        else{
            for(int i=0;i<getInformations().size();i++){
                System.out.println("Message "+i+" "+getInformations().get(i));
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
        int index = getCompany().getBranchs().indexOf(new Branch(branchName));
        int index2;
        if(index == -1){
            return false;
        }
        else{
            index2 = getCompany().getBranchs().get(index).getEmployees().indexOf(new BranchEmployee(name, surname, mail, password,getCompany(),getCompany().getBranchs().get(index)));
            if(index2 != -1){
                System.out.println("Employee is already registered!");
                return false;
            }
            getCompany().getBranchs().get(index).getEmployees().add(new BranchEmployee(name, surname, mail, password, getCompany(),getCompany().getBranchs().get(index)));
            return true;
        }
    }
    /**
     * Add to newBranch to list branch.
     * @param newBranch new branch which will be add.
     * @return It return false if the branch is already exist.Otherwise it returns false.
     */
    public boolean addBranch(Branch newBranch){
        getCompany().getBranchs().addLast(newBranch);
        return true;
    }
    /**
     * Removes the employee from the her/his branch.
     * @param employee who will be removed.
     * @param branchName of the branch 
     * @return false if the branch couldn't find if it the branchName is valid it trys to remove employee.If employee couldn't find it catchs the exception and print error to terminal and return false.It returns true if the remove sucessfull.
     */
    public boolean removeEmployee(BranchEmployee employee,String branchName){
        int index = getCompany().getBranchs().indexOf(new Branch(branchName));
        if(index == -1){
            return false;
        }
        else{
            try {
                getCompany().getBranchs().get(index).getEmployees().remove(getCompany().getBranchs().get(index).getEmployees().indexOf(employee));
                //getCompany().getBranchs().get(index).getEmployees().removeElement(employee);
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
        return getCompany().getBranchs().remove(oldBranch);
    }
    /**
     * Prints the existing branchs.
     */
    public void showBranchs(){
        if(getCompany().getBranchs().size() == 0){
            System.out.println("There is no Branch right now!\n\n");
        }
        for(int i=0;i<getCompany().getBranchs().size();i++){
            System.out.println("----BRANCHS----");
            System.out.println((i+1)+"-)"+getCompany().getBranchs().get(i).getName());
        }
        System.out.println("---------------\n\n");
    }
    /**
     * Prints the employees of the branch according to branchName.
     * @param branchName of branch which the employees will shown.
     */
    public void showBranchEmployees(String branchName){
        System.out.println(branchName);
        int index = getCompany().getBranchs().indexOf(new Branch(branchName));
        if(getCompany().getBranchs().get(index).getEmployees().size() == 0){
            System.out.println("There is no employee in this branch.\n");
        }
        else if(index == -1){
            System.out.println("Branch Couldn't Find");
        }
        else{
            System.out.println("Employees of " + getCompany().getBranchs().get(index).getName()+" :");
            for(int i=0;i<getCompany().getBranchs().get(index).getEmployees().size();i++){
                System.out.println((i+1)+") "+getCompany().getBranchs().get(index).getEmployees().get(i).toString());
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
        for(int i=0;i<getCompany().getBranchs().size();i++){
            System.out.println("------ " +getCompany().getBranchs().get(i).getName()+" ------");
            for(int j=0;j<getCompany().getBranchs().get(i).getProducts().size();j++){
                if(getCompany().getBranchs().get(i).getProducts().get(j).getAmount() == 0){
                    System.out.println(getCompany().getBranchs().get(i).getProducts().get(j).toString());
                }
            }
            System.out.println("\n");
        }
    }
}