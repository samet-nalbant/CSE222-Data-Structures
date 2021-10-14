import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Trader extends Authorized{

	private String name;
	/**
	 * No parameter constructor for trader.
	 */
	public Trader() {
		super();
	}
	/**
	 * Constructor for Trader.
	 * @param name
	 */
	public Trader(String name) {
		super();
		this.name = name;
	}
	/**
	 * Get's the order's of queue.If the trader hasn't logged in yet it returns null.
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public Queue<Order> getOrders() throws FileNotFoundException {
		if(!getLoginStatus()) {
			return null;
		}
		return getOrdersFromFile().get(name);
	}
	/**
	 * Meet or cancel order from order list acording to status value. If status is false, It cancels otherwise It approve order.If the trader hasn't logged in yet it returns false.
	 * @param orders
	 * @param target
	 * @param status
	 * @return
	 * @throws IOException
	 */
	public boolean approveOrder(Queue<Order> orders,Order target,boolean status) throws IOException {
		if(!getLoginStatus()) {
			return false;
		}
		if(status == false) {
			return orders.remove(target) && removeOrder(target.getProduct().getID());
		}
		else {
			return orders.remove(target) && removeOrder(target.getProduct().getID()) && removeProduct(target.getProduct().getID());
		}

	}
	private Hashtable<String,Queue<Order>> getOrdersFromFile() throws FileNotFoundException{ 
		Hashtable<String,Queue<Order>> temp = new Hashtable<>();
		Product tempProduct;
		FileReader file = new FileReader("orders.txt");
		Scanner reader = new Scanner(file);
		String customerID,productID,name,category,describtion,trader,price,discount;
		while(reader.hasNextLine()) {
			customerID = reader.nextLine();
			productID = reader.nextLine();
			name = reader.nextLine();
			category = reader.nextLine();
			price = reader.nextLine();
			discount = reader.nextLine();
			describtion = reader.nextLine();
			trader = reader.nextLine();
			tempProduct = new Product(name,productID,describtion,Integer.parseInt(price), Integer.parseInt(discount),trader);
			String [] temp2 = category.split(">>");
			tempProduct.addCategory(temp2[0].substring(0,temp2[0].length()-1));
			for(int i=1;i<temp2.length;i++) {
				tempProduct.addCategory(temp2[i].substring(0,temp2[i].length()));
			}
			if(temp.get(trader) == null) {
				temp.put(trader, new LinkedList<>());
			}
			temp.get(trader).add(new Order(customerID, tempProduct));
		}
		reader.close();
		return temp;
	}
	
	private boolean removeOrder(String productID) throws IOException {
		FileReader file = new FileReader("orders.txt");
		boolean flag=false,flag2=false;
		Scanner reader = new Scanner(file);
		StringBuffer sb = new StringBuffer();
		String product,customerID,line;
		while(reader.hasNextLine()) {
			flag2 = false;
			customerID = reader.nextLine();
			product = reader.nextLine();
			if(product.equals(productID)) {
				flag = true;
				flag2= true;
			}
			if(flag2 == true) {
				reader.nextLine();
				reader.nextLine();
				reader.nextLine();
				reader.nextLine();
				reader.nextLine();
				reader.nextLine();
			}
			else {
				sb.append(customerID);
				sb.append("\n");
				sb.append(product);
				sb.append("\n");
				line = reader.nextLine();
				sb.append(line);
				sb.append("\n");
				line = reader.nextLine();
				sb.append(line);
				sb.append("\n");
				line = reader.nextLine();
				sb.append(line);
				sb.append("\n");
				line = reader.nextLine();
				sb.append(line);
				sb.append("\n");
				line = reader.nextLine();
				sb.append(line);
				sb.append("\n");
				line = reader.nextLine();
				sb.append(line);
				sb.append("\n");
			}

		}
		reader.close();
		FileWriter writer = new FileWriter("orders.txt");
		writer.write(sb.toString());
		writer.close();
		return flag;
		
		
	}
	/**
	 * Edits the price and discount price of specific product.If product couldn't found It returns false.If the trader hasn't logged in yet it returns false.
	 * @param id
	 * @param newPrice
	 * @param discountPrice
	 * @return
	 * @throws IOException
	 */
	public boolean editProduct(String id, int newPrice,int discountPrice) throws IOException {
		if(!getLoginStatus()) {
			return false;
		}
		FileReader file = new FileReader("products.txt");
		boolean flag=false,flag2 = false;
		Scanner reader = new Scanner(file);
		StringBuffer sb = new StringBuffer();
		String line;
		String name,describtion,category,trader,price,discount;
		while(reader.hasNextLine()) {
			flag2 = false;
			line = reader.nextLine();
			if(line.equals(id)) {	
				name = reader.nextLine();
				category = reader.nextLine();
				price = reader.nextLine();
				discount = reader.nextLine();
				describtion = reader.nextLine();
				trader = reader.nextLine();
				if(trader.equals(getName())) {
					sb.append(line);
					sb.append("\n");
					sb.append(name);
					sb.append("\n");
					sb.append(category);
					sb.append("\n");
					sb.append(Integer.toString(newPrice));
					sb.append("\n");
					sb.append(Integer.toString(discountPrice));
					sb.append("\n");
					sb.append(describtion);
					sb.append("\n");
					sb.append(trader);
					sb.append("\n");
					flag = true;
				}
				else {
					sb.append(line);
					sb.append("\n");
					sb.append(name);
					sb.append("\n");
					sb.append(category);
					sb.append("\n");
					sb.append(price);
					sb.append("\n");
					sb.append(discount);
					sb.append("\n");
					sb.append(describtion);
					sb.append("\n");
					sb.append(trader);
					sb.append("\n");
				}
				flag2 = true;
				/*sb.append(line);
				sb.append("\n");
				line = reader.nextLine();
				sb.append(line);
				sb.append("\n");
				line = reader.nextLine();
				sb.append(line);
				sb.append("\n");
				reader.nextLine();
				reader.nextLine();
				sb.append(Integer.toString(newPrice));
				sb.append("\n");
				sb.append(Integer.toString(discountPrice));
				sb.append("\n");
				line = reader.nextLine();
				sb.append(line);
				sb.append("\n");
				line = reader.nextLine();
				sb.append(line);
				sb.append("\n");*/
			}
			if(!flag2) {
				sb.append(line);
				sb.append("\n");		
			}
		}		
		
		
		reader.close();
		if(flag) {
			FileWriter writer = new FileWriter("products.txt");
			writer.write(sb.toString());
			writer.close();
		}
		return flag;
	}
	/**
	 * Prints order's to terminal sold from trader.
	 * @param orders
	 */
	public void displayOrders(Queue<Order> orders) {
		if(orders != null) {
			Iterator<Order> iter = orders.iterator();
				int i=0;
				while(iter.hasNext()) {
					System.out.print(i+1+") ");
					iter.next().getProduct().print();
				}
		}

	}
	/**
	 * Remove specific product.If product couldn't found from given id It returns false.If the trader hasn't logged in yet it returns false.
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public boolean removeProduct(String id) throws IOException {
		if(!getLoginStatus()) {
			return false;
		}
		FileReader file = new FileReader("products.txt");
		boolean flag=false,flag2=false;
		Scanner reader = new Scanner(file);
		StringBuffer sb = new StringBuffer();
		String line,name,category,discount,describtion,trader,price;
		while(reader.hasNextLine()) {
			flag2 = false;
			line = reader.nextLine();
			if(line.equals(id)) {
				name = reader.nextLine();
				category = reader.nextLine();
				price = reader.nextLine();
				discount = reader.nextLine();
				describtion = reader.nextLine();
				trader = reader.nextLine();
				if(!trader.equals(getName())) {
					sb.append(line);
					sb.append("\n");
					sb.append(name);
					sb.append("\n");
					sb.append(category);
					sb.append("\n");
					sb.append(price);
					sb.append("\n");
					sb.append(discount);
					sb.append("\n");
					sb.append(describtion);
					sb.append("\n");
					sb.append(trader);
					sb.append("\n");
					flag2 = true;
				}
				else {
					flag = true;
				}

				/*reader.nextLine();
				reader.nextLine();
				reader.nextLine();
				reader.nextLine();
				reader.nextLine();
				reader.nextLine();*/
			}
			else {
				if(!flag2) {
					sb.append(line);
					sb.append("\n");
				}

			}
		}
		reader.close();
		FileWriter writer = new FileWriter("products.txt");
		writer.write(sb.toString());
		writer.close();
		return flag;
	}
	/**
	 * Adds product to "products.txt" file.If the product already in storage It returns false, otherwise It returns true.If the trader hasn't logged in yet it returns false.
	 * @param entry
	 * @return
	 * @throws IOException
	 */
	public boolean addProduct(Product entry) throws IOException {
		if(!getLoginStatus()) {
			return false;
		}
		FileReader file = new FileReader("products.txt");
		Scanner reader = new Scanner(file);
		FileWriter writer = new FileWriter("products.txt",true);
		String id;
		while(reader.hasNextLine()) {
			id = reader.nextLine();
			if(id.equals(entry.getID())) {
				reader.close();
				writer.close();
				return false;
			}
			reader.nextLine();
			reader.nextLine();
			reader.nextLine();
			reader.nextLine();
			reader.nextLine();
			reader.nextLine();
		}

		reader.close();
		LinkedList<String> temp = entry.getCategory();
		writer.write(entry.getID());
		writer.write("\n");
		writer.write(entry.getProductName());
		writer.write("\n");
		for(int i=0;i<temp.size()-1;i++) {
			writer.write(temp.get(i)+" >> ");
		}
		writer.write(temp.get(temp.size()-1));
		writer.write("\n");
		writer.write(Integer.toString(entry.getPrice()));
		writer.write("\n");
		writer.write(Integer.toString(entry.getDiscountPrice()));
		writer.write("\n");
		writer.write(entry.getDescription());
		writer.write("\n");
		writer.write(entry.getTrader());
		writer.write("\n");
		writer.close();
		return true;
	}
	@Override
	/**
	 * Checks the information of customer.If the values are true, logIN status turns true. So the other functions could use. Otherwise It returns false and the functions couldn't use from customer.
	 */
	public boolean logIn(int ID,String password) throws FileNotFoundException {
		FileReader file = new FileReader("users.txt");
		Scanner reader = new Scanner(file);
		int tempID;
		String fpassword,type,name;
		while(reader.hasNextLine()) {
			type = reader.nextLine();
			if(type.equals("trader")) {
				name = reader.nextLine();
				fpassword = reader.nextLine();
				tempID = Integer.parseInt(reader.nextLine());
				if(password.equals(fpassword) && tempID == ID) {
					changeLoginStatus();
					setPassword(password);
					setName(name);
				}
			}
			else if(type == "customer"){
				reader.nextLine();
				reader.nextLine();
			}
		}
		reader.close();
		return getLoginStatus();
	}
	/**
	 *  Register the customer to the system and prints his customer ID.If the trader already registered It returns false.
	 * @param name
	 * @param password
	 * @return
	 * @throws IOException
	 */
	public boolean register(String name,String password) throws IOException {
		File userFile = new File("users.txt");
		FileWriter writer = new FileWriter(userFile,true);
		FileReader file = new FileReader(userFile);
		Scanner reader = new Scanner(file);
		String traderName,type;
		while(reader.hasNextLine()) {
			type = reader.nextLine();
			if(type == "trader") {
				traderName = reader.nextLine();
				reader.nextLine();
				if(traderName == name) {
					reader.close();
					writer.close();
					return false;
				}
			}
			else if(type == "customer") {
				reader.nextLine();
				reader.nextLine();
			}
		}
		reader.close();
		writer.write("trader");
		writer.write("\n");
		writer.write(name);
		writer.write("\n");
		writer.write(password);
		writer.write("\n");
		writer.write(Integer.toString(getID()));
		System.out.println("Your trader ID: "+ getID());
		writer.write("\n");
		writer.close();
		return true;
		
	}
	/**
	 * Returns the name of trader.
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of trader.
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
