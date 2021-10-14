
import java.util.Scanner;

public class Test{

    public static void main(String []args){
        Company gtu = new Company("GTU BUTTERFLY A.S");
        gtu.setAdmin(new Administrator("Anonymous","Anonymous","admin@gtu","gtu123", gtu));
        driver();
        addDefaults(gtu);
        automationSystem(gtu);
    }
    public static void driver(){
        BranchEmployee temp2;
        Customer temp3;
        System.out.println("Company is creating!");
        Company temp = new Company("DRIVER COMPANY");
        System.out.println("Company name:"+temp.getName());
        System.out.println("-------------");
        System.out.println("Admin is setting!");
        temp.setAdmin(new Administrator("Anonymous","Anonymous","admin@gtu","gtu123", temp));
        System.out.println("Admin name:"+temp.getAdmmin().getName());
        System.out.println("-------------");
        System.out.println("Admin creating Branch!");
        temp.getAdmmin().addBranch(new Branch("DRIVER BRANCH"));
        System.out.println("Branch Name: "+temp.getBranchs().get(0).getName());
        System.out.println("-------------");
        System.out.println("Admin adding Employee!");
        temp.getAdmmin().addEmployee("samet", "nalbant", "samet@gtu", "123", "DRIVER BRANCH");
        System.out.println("Employee : "+temp.getBranchs().get(0).getEmployees().get(0));
        System.out.println("-------------");
        System.out.println("Admin creating New Branchs!");
        temp.getAdmmin().addBranch(new Branch("DRIVER BRANCH1"));
        temp.getAdmmin().addBranch(new Branch("DRIVER BRANCH2"));
        temp.getAdmmin().addBranch(new Branch("DRIVER BRANCH3"));
        temp.getAdmmin().showBranchs();
        System.out.println("Admin removing BRANCH1!");
        temp.getAdmmin().removeBranch(new Branch("DRIVER BRANCH1"));
        temp.getAdmmin().showBranchs();
        System.out.println("-------------");
        System.out.println("Admin trying to remove not existing branch!");
        System.out.println(temp.getAdmmin().removeBranch(new Branch("DRIVER BRANCH8")));
        System.out.println("-------------");
        System.out.println("Admin creating New Employees!");
        temp.getAdmmin().addEmployee("samet2", "nalbant2", "samet2@gtu", "123", "DRIVER BRANCH");
        temp.getAdmmin().addEmployee("samet3", "nalbant3", "samet3@gtu", "123", "DRIVER BRANCH");
        temp.getAdmmin().addEmployee("samet4", "nalbant4", "samet4@gtu", "123", "DRIVER BRANCH");
        temp.getAdmmin().showBranchEmployees("DRIVER BRANCH");
        System.out.println("-------------");
        System.out.println("Admin removing samet2 employee!");
        temp.getAdmmin().removeEmployee(new BranchEmployee("samet2", "nalbant2","samet2@gtu", "123", null, null), "DRIVER BRANCH");
        temp.getAdmmin().showBranchEmployees("DRIVER BRANCH");
        System.out.println("-------------");
        System.out.println("Admin removing not exist employee!");
        System.out.println(temp.getAdmmin().removeEmployee(new BranchEmployee("samet2", "nalbant2","samet2@gtu", "123", null, null), "DRIVER BRANCH"));
        System.out.println("-------------");
        System.out.println("Admin query products!");
        temp.getAdmmin().queryProducts();
        System.out.println("-------------");
        System.out.println("Admin read informations!");
        temp.getAdmmin().readInformations();
        System.out.println("-----------------");
        System.out.println("--Employe Functions--");
        temp2 = temp.getEmployee("samet@gtu", "123");
        System.out.println("Samet employee adding Bookcase Narrow Model x5 and OfficeChair Red Wide x10");
        temp2.addProduct(new Bookcase("Narrow"), 5);
        temp2.addProduct(new OfficeChair("Narrow","Red"), 10);
        temp2.showProducts();
        System.out.println("-----------------");
        System.out.println("Branch employee removing Bookcase");
        temp2.removeProduct(new Bookcase("Narrow"));
        temp2.showProducts();
        System.out.println("Branch employee removing now existing product");
        System.out.println(temp2.removeProduct(new Bookcase("Narrow")));
        System.out.println("-----------------");
        System.out.println("Customer Adding To System!");
        temp.customerSubscribe("ali", "kaya", "ali@gtu", "123");
        temp3 = temp.getCustomers().get(temp2.findCustomer(0));
        System.out.println("Customer name:"+temp3.getName()+" Customer ID:"+ temp3.getID());
        System.out.println("-----------------");
        System.out.println("Branch employee make sales: 5 Office Chair");
        temp2.makeSale(0, "1234", "gtu", (new OfficeChair("Narrow","Red")), 5);
        temp2.showProducts();
        System.out.println("Branch employee make sales not existing product!");
        System.out.println(temp2.makeSale(0, "1234", "gtu", (new OfficeChair("Narrow","Black")), 5));
        System.out.println("-----------------");
        System.out.println("Branch employee lists the previous orders of customer:");
        temp2.showOrders(0);
        System.out.println("-----------------");
        System.out.println("Branch employee lists the previous orders of non existing customer:");
        temp2.showOrders(8);
        System.out.println("-----------------");
        System.out.println("Branch employee querying products!");
        temp2.queryProducts();
        System.out.println("-----------------");
        System.out.println("Customer search product!");
        System.out.println(temp3.searchProducts(new OfficeChair("Narrow", "Red")));
        System.out.println("-----------------");
        System.out.println("Customer search non existing product!");
        System.out.println(temp3.searchProducts(new OfficeChair("Narrow", "Black")));
        System.out.println("-----------------");
        System.out.println("Customer shopping online!");
        System.out.println(temp3.shopOnline(new OfficeChair("Narrow","Red"), 2, "gtu123", "1234567890"));
        temp3.viewOrders();
        System.out.println("-----------------");
        System.out.println("Customer query products!");
        temp3.showProducts();
        System.out.println("-----------------");
        System.out.println("Customer shopping online with non existing product!");
        System.out.println(temp3.shopOnline(new OfficeChair("Narrow","Black"), 2, "gtu123", "1234567890"));
        System.out.println("-----------------\n\n");
    }
    public static void addDefaults(Company x){
        Administrator admin = x.getAdmmin();
        BranchEmployee employee,employee2;


        Customer customer1;
        admin.addBranch(new Branch("Gebze"));
        admin.addBranch(new Branch("Pendik"));
        admin.addEmployee("Ahmet","Aksoy","ahmet@gtu","123","Gebze");
        admin.addEmployee("Fatma", "Tekin","fatma@gtu","123","Gebze");
        admin.addEmployee("Mehmet", "Kayhan","mehmet@gtu","123","Pendik");

        employee = x.getEmployee("ahmet@gtu","123");
        employee2 = x.getEmployee("mehmet@gtu","123");
        
        employee.addProduct(new Bookcase("Middle Size"),3);
        employee.addProduct(new Bookcase("Rectangle"),7);
        employee.addProduct(new Bookcase("Square"),2);
        employee.addProduct(new Bookcase("Wooden"),0);
        employee.addProduct(new OfficeChair("Wide","Red"),5);
        employee.addProduct(new OfficeChair("Wide","Black"),2);
        employee.addProduct(new OfficeChair("Wooden","White"),1);
        employee.addProduct(new OfficeChair("Wooden","Orange"),2);        
        employee.addProduct(new OfficeChair("Plastic","White"),5);
        employee.addProduct(new MeetingTable("Long Size", "Black"), 17);
        employee.addProduct(new MeetingTable("Narrow", "Black"), 0);
        employee.addProduct(new MeetingTable("Wide", "Black"), 1);
        employee.addProduct(new MeetingTable("Square", "Red"), 3);
        employee.addProduct(new MeetingTable("Suare", "Gray"), 7);
        employee.addProduct(new MeetingTable("Long Size", "Black"),2);
        employee.addProduct(new OfficeCabinet("Narrow"), 3);
        employee.addProduct(new OfficeCabinet("Short size"), 12);
        employee.addProduct(new OfficeCabinet("Middle size"), 0);
        employee.addProduct(new OfficeCabinet("Rectangle"),7);
        employee.addProduct(new OfficeCabinet("Wide"), 1);
        employee.addProduct(new OfficeDesk("Wooden", "Gray"),2);
        employee.addProduct(new OfficeDesk("Wooden", "Black"),12);
        employee.addProduct(new OfficeDesk("Wooden", "Red"),1);
        employee.addProduct(new OfficeDesk("Plastic", "Red"),0);
        employee.addProduct(new OfficeDesk("Plastic", "Gray"),7);
        employee.addProduct(new OfficeDesk("Rectangle", "Red"),6);

        employee2.addProduct(new Bookcase("Middle Size"),2);
        employee2.addProduct(new Bookcase("Rectangle"),0);
        employee2.addProduct(new Bookcase("Short Size"),2);
        employee2.addProduct(new Bookcase("Rectangle"),7);
        employee2.addProduct(new OfficeChair("Wooden","Red"),5);
        employee2.addProduct(new OfficeChair("Wide","Black"),0);
        employee2.addProduct(new OfficeChair("Square","White"),1);
        employee2.addProduct(new OfficeChair("Square","Orange"),0);        
        employee2.addProduct(new OfficeChair("Plastic","White"),7);   
        employee2.addProduct(new MeetingTable("Short Size", "Black"), 0);
        employee2.addProduct(new MeetingTable("Narrow", "Black"), 0);
        employee2.addProduct(new MeetingTable("Circle", "Gray"), 12);
        employee2.addProduct(new MeetingTable("Square", "Red"), 3);
        employee2.addProduct(new MeetingTable("Suare", "Gray"), 0);
        employee2.addProduct(new MeetingTable("Rectangle", "Black"),2);     
        employee2.addProduct(new OfficeCabinet("Narrow"), 3);
        employee2.addProduct(new OfficeCabinet("Circle"), 13);
        employee2.addProduct(new OfficeCabinet("Grid"), 1);
        employee2.addProduct(new OfficeCabinet("Reverse"),7);
        employee2.addProduct(new OfficeCabinet("Wide"), 1);
        employee.addProduct(new OfficeDesk("Wooden", "Gray"),12);
        employee.addProduct(new OfficeDesk("Wooden", "Black"),0);
        employee.addProduct(new OfficeDesk("Square", "White"),5);
        employee.addProduct(new OfficeDesk("Square", "Red"),2);
        employee.addProduct(new OfficeDesk("Plastic", "Gray"),3);
        employee.addProduct(new OfficeDesk("Narrow", "White"),3);

        x.customerSubscribe("Samet","Nalbant","sam@gtu","123");
        x.customerSubscribe("Feyza","Kaya","feyza@gtu","123");
        admin.removeBranch(new Branch("yjtrhe"));
        customer1 = x.getCustomers().get(employee.findCustomer(2));
        customer1.shopOnline(new OfficeDesk("Wooden","Gray"), 2, "Gebze Home", "123456");
        customer1.shopOnline(new OfficeCabinet("Reverse"), 3, "Gebze Office", "123456");
    }
    public static void automationSystem(Company x){
        Scanner input = new Scanner(System.in);
        String name,surname,mail,password;
        int choice = -1;
        while(choice != 0){
            System.out.println("Welcome to " + x.getName());
            System.out.println("1)Enter as an Administrator.\n2)Enter as a Branch Employee.\n3)Enter as  Customer.\n4)Subscribe to system as a Customer.\n0)EXIT\n");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    adminMenu(x);
                    break;
                case 2:
                    employeeMenu(x);
                    break;
                case 3:
                    customerMenu(x);
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("Enter Name:");
                    name = input.nextLine();
                    System.out.println("Enter Surname:");
                    surname = input.nextLine();
                    System.out.println("Enter Mail Adress:");
                    mail = input.nextLine();
                    System.out.println("Enter Password:");
                    password = input.nextLine();
                    if(x.customerSubscribe(name,surname,mail,password) == false){
                        System.out.println("This mail is already taken!.");
                    }
                    else{
                        System.out.println("You can log in now!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong Choice!");
                    break;
            }
        }
    }

    public static void adminMenu(Company x){
        Administrator temp;
        int choice = -1,selection,num;
        String mail,password,name,surname;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Mail Adress:");
        mail = input.nextLine();
        System.out.println("Enter Password:");
        password = input.nextLine();
        if(x.adminLogIn(mail, password)){
            System.out.println("Succesfully Loged In\n");
            temp = x.getAdmmin();
            while(choice != 0){
                System.out.println("1)List Branchs.\n2)List Employees\n3)Add Branch.\n4)Remove Branch.\n5)Add Branch Employee.\n6)Remove Branch Employee.\n7)Query Products\n8)Read Message\n0)EXIT\n");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        temp.showBranchs();
                        break;
                
                    case 2:
                        temp.showBranchs();
                        if(temp.getCompany().getBranchs().size() != 0){
                            System.out.println("Enter the number of the Branch to Show Employees.");
                            selection = input.nextInt();
                            try {
                                temp.showBranchEmployees(temp.getCompany().getBranchs().get(selection-1).getName());
                            } catch (Exception e) {
                                System.out.println("Wrong Selection!\n");
                            }
                        }
                        break;    
                    case 3:
                        System.out.println("Enter the name of the new Branch");
                        input.nextLine();
                        name = input.nextLine();
                        if(temp.addBranch(new Branch(name)) == false){
                            System.out.println("This Branch is already exist!\n");
                        }
                        else{
                            System.out.println("Operation Succesful!");
                        }
                        break;
                    case 4:
                        temp.showBranchs();
                        System.out.println("Enter the number of the Branch:");
                        input.nextLine();
                        selection = input.nextInt();
                        if(selection <= 0 || selection > temp.getCompany().getBranchs().size() || temp.removeBranch(new Branch(temp.getCompany().getBranchs().get(selection-1).getName())) == false){
                            System.out.println("Branch couldn't found!\n");
                        }
                        else{
                            System.out.println("Operation Succesful!");
                        }
                        break;
                    case 5:
                        temp.showBranchs();
                        System.out.println("Enter the number of the Branch to Add new Employee.");
                        selection = input.nextInt();
                        if(selection <= 0 || selection > temp.getCompany().getBranchs().size()){
                            System.out.println("Branch couldn't found!\n");
                        }
                        else{
                            input.nextLine();
                            System.out.println("Enter the name of the Employee.");
                            name = input.nextLine();
                            System.out.println("Enter the surname of the Employee.");
                            surname = input.nextLine();
                            System.out.println("Enter the mail of the Employee.");
                            mail = input.nextLine();
                            System.out.println("Enter the password of the Employee.");
                            password = input.nextLine();                                    
                            if(!(temp.addEmployee(name,surname,mail,password,temp.getCompany().getBranchs().get(selection-1).getName()))){
                                System.out.println("Wrong input!Try again!");
                            }
                            else{
                                System.out.println("Operation Succesful!");
                            }
                        }
                        break;
                    case 6:
                        temp.showBranchs();
                        System.out.println("Enter the number of the Branch to Remove Employee:");
                        selection = input.nextInt();   
                        if(selection <= 0 || selection > temp.getCompany().getBranchs().size()){
                            System.out.println("Branch couldn't found!\n");
                        }
                        else{
                            temp.showBranchEmployees(temp.getCompany().getBranchs().get(selection-1).getName());
                            System.out.println("Enter the number of the Branch Employee to remove:");
                            num = input.nextInt();
                            if(num <= 0 || num >temp.getCompany().getBranchs().get(selection-1).getEmployees().size()){
                                System.out.println("Wrong Selection!");
                            }
                            else{
                                if(temp.removeEmployee(temp.getCompany().getBranchs().get(selection-1).getEmployees().get(num-1),temp.getCompany().getBranchs().get(selection-1).getName())){
                                    System.out.println("Operation Succesful!");
                                }
                                else{
                                    System.out.println("Something went wrong!");
                                }
                            }      
                        }  
                        break;
                    case 7:
                        temp.queryProducts();
                        break;
                    case 8:
                        temp.readInformations();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Wrong Choice!");
                        break;
                }
            }
        }
        else{
            System.out.println("Wrong informations.I can't tell you which one is wrong!.\n");
        }
    }

    public static void employeeMenu(Company x){
        Scanner input = new Scanner(System.in);
        boolean flag;
        String mail,password,name,surname,phone,adress;
        int choice,selection = -1,num,amount,num2,id;
        BranchEmployee tempEmployee;
        Product tempProduct = null;
        System.out.println("Enter Mail Adress:");
        mail = input.nextLine();
        System.out.println("Enter Password:");
        password = input.nextLine();
        if(x.employeeLogIn(mail, password)){
            tempEmployee = x.getEmployee(mail, password);
            System.out.println("Succesfully Loged In\n");
            while(selection != 0){

                System.out.println("1)Add product.\n2)Remove product\n3)Make Sale\n4)Show Previous Order\n5)Inquire Products\n0)EXIT\n");
                selection = input.nextInt();
                switch (selection){
                    case 1:
                        flag = true;
                        System.out.println("1)Bookcase\n2)Meeting Table\n3)Office Cabinet\n4)Office Chair\n5)Office Desk");
                        System.out.println("Enter the number of Item Which You Want to Add:");
                        choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                tempProduct = new Bookcase(" ");                 
                                break;
                            case 2:
                                tempProduct = new MeetingTable(" ", " ");       
                                break;
                            case 3:
                                tempProduct = new OfficeCabinet(" ");        
                                break;
                            case 4:
                                tempProduct = new OfficeChair(" ", " ");      
                                break;
                            case 5:
                                tempProduct = new OfficeDesk(" ", " ");
                                break;
                            default:
                                flag = false;
                                break;
                        }
                        if(flag != false){
                            if(choice == 1 || choice == 3){
                                tempProduct.showModels();
                                System.out.println("Enter the number of model:");
                                num = input.nextInt();
                                if(num <= 0 || tempProduct.getModels().length < num){
                                    System.out.println("Wrong Selection!");
                                }
                                else{
                                    System.out.println("Enter the amount:");
                                    amount = input.nextInt();
                                    if(amount <=0){
                                        System.out.println("Amount can not take "+ amount);
                                    }
                                    else{
                                        tempProduct.setModel(tempProduct.getModels()[num-1]);     
                                        tempEmployee.addProduct(tempProduct, amount);   
                                    }
                            
                                }
                            }
                            else{
                                tempProduct.showModels();
                                System.out.println("Enter the number of model:");
                                num = input.nextInt();
                                System.out.println("Enter the number of colour:");
                                num2 = input.nextInt();
                                if(num <= 0 || tempProduct.getModels().length < num || num2<= 0 || tempProduct.getColours().length < num2){
                                    System.out.println("Wrong Selection!");
                                }
                                else{
                                    System.out.println("Enter the amount:");
                                    amount = input.nextInt();
                                    if(amount <=0){
                                        System.out.println("Amount can not take "+ amount);
                                    }
                                    else{
                                        tempProduct.setModel(tempProduct.getModels()[num-1]);
                                        tempProduct.setColour(tempProduct.getColours()[num2-1]);
                                        tempEmployee.addProduct(tempProduct, amount);
                                    }
                                }                            
                            }
                        }
                        break;
                    case 2:
                        tempEmployee.showProducts();
                        System.out.println("Enter the number of the product:");
                        num = input.nextInt();
                        if(num <=0 || tempEmployee.getBranch().getProducts().size() < num){
                            System.out.println("Wrong Selection!");
                        }
                        else{
                            tempEmployee.removeProduct(tempEmployee.getBranch().getProducts().get(num-1));
                            System.out.println("Operation Succesful!");
                        }
                        break;
                    case 3:
                        tempEmployee.showProducts();
                        System.out.println("Enter the number of the product:");
                        num = input.nextInt();
                        if(num <=0 || tempEmployee.getBranch().getProducts().size() < num){
                            System.out.println("Wrong Selection!");
                        } 
                        else{
                            System.out.println("Enter the amount of product");
                            amount = input.nextInt();
                            if(amount <=0){
                                System.out.println("Amount can not be " + amount);
                            }
                            else{
                                System.out.println("Enter the CustomerID:\nIf you are not subscribed enter -2");
                                id = input.nextInt();
                                input.nextLine();
                                System.out.println("Enter the phone number");
                                phone = input.nextLine();
                                System.out.println("Enter the customer adress");
                                adress = input.nextLine();
                                tempEmployee.makeSale(id, phone, adress, tempEmployee.getBranch().getProducts().get(num-1), amount);
                            }

                        }                  
                        break;
                    case 4:
                        System.out.println("Enter the customer id:");
                        id = input.nextInt();
                        tempEmployee.showOrders(id);
                        break;
                    case 5:
                        tempEmployee.queryProducts();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Wrong Choice!");
                }
            }
        }
        else{
            System.out.println("Wrong informations.I can't tell you which one is wrong!.\n");
        }
    }
    public static void customerMenu(Company x){
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        String mail,password,adress,phone;
        int choice = -1,selection,num,amount,index1,index2;
        System.out.println("Enter Mail Adress:");
        mail = input.nextLine();
        System.out.println("Enter Password:");
        password = input.nextLine();
        Customer tempCustomer;
        Product tempProduct = null; 
        if(x.customerLogIn(mail, password) == true){
            System.out.println("Succesfully Loged In\n");
            tempCustomer = x.getCustomers().get(x.getCustomers().indexOf(new Customer(" "," ",mail,password,null)));
            while(choice != 0){
                System.out.println("1)See the list of Products\n2)Search Product\n3)Shop Online\n4)View Previous Orders\n0)EXIT");
                choice = input.nextInt();
                switch (choice){
                    case 1:
                        tempCustomer.showProducts();
                        break;
                    case 2:
                        flag = true;
                        System.out.println("1)Bookcase\n2)Meeting Table\n3)Office Cabinet\n4)Office Chair\n5)Office Desk");
                        System.out.println("Enter the number of Item Which You Want to Search:");
                        selection = input.nextInt();
                        switch(selection){
                            case 1:
                                tempProduct = new Bookcase(" ");
                                break;
                            case 2:
                                tempProduct = new MeetingTable(" "," ");                                                                   
                                break;
                            case 3:
                                tempProduct = new OfficeCabinet(" ");
                                break;
                            case 4:
                                tempProduct = new OfficeChair(" ", " ");                      
                                break;
                            case 5:
                                tempProduct = new OfficeDesk(" ", " ");                                                             
                                break;
                            default:
                                flag = false;
                                System.out.println("Wrong Selection!");
                                break;
                        }
                        if(flag == true){
                            if(selection == 1 || selection == 3){
                                tempProduct.showModels();
                                System.out.println("Enter the model number:");
                                index1 = input.nextInt();
                                if(index1 > tempProduct.getModels().length || index1 <=0){
                                    System.out.println("Wrong Selection!");
                                }
                                else{
                                    tempProduct.setModel(tempProduct.getModels()[index1-1]);
                                }

                            }
                            else{
                                tempProduct.showModels();
                                System.out.println("Enter the model number:");
                                index1 = input.nextInt();
                                System.out.println("Enter the colur number:");
                                index2 = input.nextInt();
                                if(index1 <= 0 || index2 <=0 || tempProduct.getModels().length>index1|| tempProduct.getColours().length>index2){
                                    System.out.println("Wrong Selection!");
                                }
                                else{
                                    tempProduct.setColour(tempProduct.getColours()[index2-1]);
                                    tempProduct.setModel(tempProduct.getModels()[index1-1]);  
                                }
    
                            }
                            if(tempCustomer.searchProducts(tempProduct)== false){   
                                System.out.println("Product couldn't find!");
                            } 
                        }       
                        break;
                    case 3:
                        tempCustomer.showAvailableProducts();
                        System.out.println("Enter the number of the product to buy:");
                        num = input.nextInt();
                        if(num <=0 || num > x.getAvailableProductsAmount()){
                            System.out.println("Wrong Selection!");
                        }
                        else{
                            System.out.println("Enter the amount of product:");
                            amount = input.nextInt();
                            System.out.println("Enter the adress:");
                            input.nextLine();
                            adress = input.nextLine();
                            System.out.println("Enter the phone:");
                            phone = input.nextLine();
                            if(!(tempCustomer.shopOnline(x.getStocks().get(num-1), amount, adress, phone))){
                                System.out.println("Stocks can't affort your amount!");
                            }
                            else{
                                System.out.println("Order Completed!");
                            }
                        }
                        break;
                    case 4:
                        if(tempCustomer.viewOrders() == false){
                            System.out.println("There is no order!");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Wrong Choice!");
                        break;
                }
            }
        }
        else{
            System.out.println("Wrong informations.I can't tell you which one is wrong!.\n");
        }
    }
}