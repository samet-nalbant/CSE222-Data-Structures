import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Customer extends Authorized {
	
	/**
	 * Returns list of product which includes searched word in it's name or description.If the customer hasn't logged in yet it returns null.
	 * @param entry
	 * @return
	 */
	public ArrayList<Product> searchProducts(String entry){
		if(getLoginStatus() == false) {
			return null;
		}
		ArrayList<Product> productList = new ArrayList<>();
		String id,name,category,describtion,trader,price,discount;
		int count = 0;
		try {
			FileReader file = new FileReader("Products.txt");
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				id = reader.nextLine();
				name = reader.nextLine();
				category = reader.nextLine();
				price = reader.nextLine();
				discount = reader.nextLine();
				describtion = reader.nextLine();
				trader = reader.nextLine();
				if(name.contains(entry) || describtion.contains(entry)) {
					productList.add(new Product(name,id,describtion,Integer.parseInt(price),Integer.parseInt(discount),trader));
					String [] temp = category.split(">>");
					productList.get(count).addCategory(temp[0].substring(0,temp[0].length()-1));
					for(int i=1;i<temp.length;i++) {
						productList.get(count).addCategory(temp[i].substring(1,temp[i].length()-1));
					}
					count++;
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		quickSort(productList,0,productList.size()-1,3);
		return productList;
	}
	/**
	 * It takes a product and save the order to "orders.txt" file.If the customer hasn't logged in yet it returns false.
	 * @param product
	 * @return
	 * @throws IOException
	 */
	public boolean createOrder(Product product) throws IOException {
		if(getLoginStatus() == false) {
			return false;
		}
		FileWriter writer = new FileWriter("orders.txt",true);
		writer.write(Integer.toString(getID()));
		writer.write("\n");
		writer.write(product.getID());
		writer.write("\n");
		writer.write(product.getProductName());
		writer.write("\n");
		LinkedList<String> temp = product.getCategory();
		for(int i=0;i<temp.size()-1;i++) {
			writer.write(temp.get(i)+" >> ");
		}
		writer.write(temp.get(temp.size()-1));
		writer.write("\n");
		writer.write(Integer.toString(product.getPrice()));
		writer.write("\n");
		writer.write(Integer.toString(product.getDiscountPrice()));
		writer.write("\n");
		writer.write(product.getDescription());
		writer.write("\n");
		writer.write(product.getTrader());
		writer.write("\n");
		writer.close();
		return true;
	}
	/**
	 * Returns the list of products of specific trader according to traderName.If the customer hasn't logged in yet it returns false.
	 * @param traderName
	 * @return
	 * @throws FileNotFoundException
	 */
	public ArrayList<Product> getProductsOfTrader(String traderName) throws FileNotFoundException{
		if(getLoginStatus() == false) {
			return null;
		}
		String id,name,category,describtion,trader,price,discount;
		int count = 0;
		FileReader file = new FileReader("Products.txt");
		Scanner reader = new Scanner(file);
		ArrayList<Product> productList = new ArrayList<>();
		while(reader.hasNextLine()) {
			id = reader.nextLine();
			name = reader.nextLine();
			category = reader.nextLine();
			price = reader.nextLine();
			discount = reader.nextLine();
			describtion = reader.nextLine();
			trader = reader.nextLine();
			if(trader.equals(traderName)) {
				productList.add(new Product(name,id,describtion,Integer.parseInt(price),Integer.parseInt(discount),trader));
				String [] temp = category.split(">>");
				productList.get(count).addCategory(temp[0].substring(0,temp[0].length()-1));
				for(int i=1;i<temp.length;i++) {
					productList.get(count).addCategory(temp[i].substring(1,temp[i].length()));
				}
				count++;
			}
		}
		reader.close();
		return productList;
	}
	/**
	 * It returns the filtered results acording to lowerBound or upperBound.If the one of them is unnecessary, bound must be enter as an -1.If the customer hasn't logged in yet it returns false.
	 * @param data
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public ArrayList<Product>filterResults(ArrayList<Product> data,int lowerBound,int upperBound) {
		if(getLoginStatus() == false) {
			return null;
		}
		ArrayList<Product> temp = new ArrayList<>();
		for(int i=0;i<data.size();i++) {
			if(lowerBound == -1 && upperBound != -1) {
				if(data.get(i).getPrice()<upperBound) {
					temp.add(data.get(i));
				}
			}
			else if(lowerBound != -1 && upperBound == -1) {
				if(data.get(i).getPrice() > lowerBound) {
					temp.add(data.get(i));
				}
			}
			else {
				if(data.get(i).getPrice() > lowerBound && data.get(i).getPrice()<upperBound) {
					temp.add(data.get(i));
				}				
			}
		}
		return temp;
	}
	/**
	 * Returns the list of product according to category name.If the customer hasn't logged in yet it returns false.
	 * @param data
	 * @param category
	 * @return
	 */
	public ArrayList<Product>filterResultsbyCategory(ArrayList<Product> data, String category) {
		if(getLoginStatus() == false) {
			return null;
		}
		ArrayList<Product> temp = new ArrayList<>();
		for(int i=0;i<data.size();i++) {
			if(data.get(i).getCategory().contains(category)) {
				temp.add(data.get(i));
			}
		}
		return temp;
	}
	
	/**
	 * Sort's the products according to choice.If the customer hasn't logged in yet it's do nothing.
	 * @param productList
	 * @param choice
	 */
	public void sortProducts(ArrayList<Product> productList,int choice) {
		if(getLoginStatus() != false) {
			quickSort(productList,0,productList.size()-1,choice);
		}
	}

	@Override
	/**
	 * Checks the information of customer.If the values are true, logIN status turns true. So the other functions could use. Otherwise It returns false and the functions couldn't use from customer.
	 */
	public boolean logIn(int ID,String password) throws FileNotFoundException {
		FileReader file = new FileReader("users.txt");
		Scanner reader = new Scanner(file);
		int tempID;
		String fpassword,type;
		while(reader.hasNextLine()) {
			type = reader.nextLine();
			if(type.equals("customer")) {
				fpassword = reader.nextLine();
				tempID = Integer.parseInt(reader.nextLine());
				if(password.equals(fpassword) && tempID == ID) {
					changeLoginStatus();
					setPassword(password);
				}
			}
			else if(type.equals("trader")){
				reader.nextLine();
				reader.nextLine();
				reader.nextLine();
			}
			else {
				
			}
		}
		reader.close();
		return getLoginStatus();
	}
	/**
	 * Register the customer to the system and prints his customer ID.If the customer already registered It returns false.
	 * @param password
	 * @return
	 * @throws IOException
	 */
	public boolean register(String password) throws IOException {
		File userFile = new File("users.txt");
		FileWriter writer = new FileWriter(userFile,true);
		FileReader file = new FileReader("users.txt");
		Scanner reader = new Scanner(file);
		String line;
		while(reader.hasNextLine()) {
			line = reader.nextLine();
			if(line.equals(Integer.toString(getID()))) {
				writer.close();
				reader.close();
				return false;
			}
		}
		writer.write("customer");
		writer.write("\n");
		writer.write(password);
		writer.write("\n");
		writer.write(Integer.toString(getID()));
		writer.write("\n");
		writer.close();
		System.out.println("Your customer ID: "+ getID());
		reader.close();
		return true;
	}

	private int partition(ArrayList<Product> data, int low, int high,int sort) {
	    Product pivot = data.get(high);
	    int i = (low - 1);
	    for(int j = low; j <= high - 1; j++){
	        if (data.get(j).getPrice() < pivot.getPrice() && sort == 0){
	            i++;
	            swap(data, i, j);
	        }
	        else if(data.get(j).getPrice() > pivot.getPrice() && sort == 1) {
	            i++;
	            swap(data, i, j);
	        }
	        else if(data.get(j).getProductName().compareTo( pivot.getProductName()) > 0 && sort == 2){
	            i++;
	            swap(data, i, j);
	        }
	        else if(data.get(j).getProductName().compareTo( pivot.getProductName()) < 0 && sort == 3){
	            i++;
	            swap(data, i, j);
	        }
	        else if(getDiscount(data.get(j).getPrice(),data.get(j).getDiscountPrice()) > getDiscount(pivot.getPrice(),pivot.getDiscountPrice()) && sort== 4) {
	        	i++;
	            swap(data, i, j);
	        }
	        else if(getDiscount(data.get(j).getPrice(),data.get(j).getDiscountPrice()) < getDiscount(pivot.getPrice(),pivot.getDiscountPrice()) && sort== 5) {
	            i++;
	            swap(data, i, j);
	        }
	    }
	    swap(data, i + 1, high);
	    return (i + 1);
	}
	public void printResults(ArrayList<Product> searchResults) {
		for(int i=0;i<searchResults.size();i++) {
			System.out.print(i+1+ ") ");
			searchResults.get(i).print();
		}
	}
	private void swap(ArrayList<Product> data,int index1,int index2) {
		Product temp = data.get(index2);
		data.set(index2, data.get(index1));
		data.set(index1, temp);
	}
	private double getDiscount(int price,int discount) {
		
		double p = (double) price , d=  (double)discount;
		return (double)100-(d/p*100);
	}
	private void quickSort(ArrayList<Product> data, int low, int high,int sort) {
	    if (low < high){
	        int pi = partition(data, low, high,sort);
	        quickSort(data, low, pi - 1,sort);
	        quickSort(data, pi + 1, high,sort);
	    }	
	}


}
