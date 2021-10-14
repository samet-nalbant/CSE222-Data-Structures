import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Test {
	public static void main(String[] args) throws NumberFormatException, IOException{
		test();
		menu();

	}

	public static void test() throws IOException{
		ArrayList<Product> searchResults = new ArrayList<>();
		System.out.println("---Test Started---");
		try {
			readAndWrite();
		} catch (NumberFormatException e) {
			System.out.println("CSV file is not suitable!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File couldn't open!");
			e.printStackTrace();
			return;
		}
		System.out.println("CSV file readed and 'products.txt' is created!\nTrader's pasword is 123456");
		System.out.println("Customer created and It's registered with this password : 123456");
		Customer samet = new Customer();
		System.out.println(samet.register("123456"));
		System.out.println("--------------");
		System.out.println("Customer trying to register to system again:");
		System.out.println(samet.register("123456"));
		System.out.println("--------------");
		System.out.println("Customer logging to system!");
		System.out.println(samet.logIn(samet.getID(), "123456"));
		System.out.println("--------------");
		System.out.println("--------------\n\n");

		System.out.println("Customer searcing products which is given word as a Shorts.\nSearch results are printing to terminal as a sorted way!");
		searchResults = samet.searchProducts("Shorts");
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("--------------\n\n");
		System.out.println("Products which are searched filtering by category name as an Jeans & Shorts!");
		searchResults = samet.filterResultsbyCategory(searchResults, "Jeans & Shorts");
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("--------------\n\n");
		System.out.println("Search results are sorting acording to their prices to increasing order");
		samet.sortProducts(searchResults, 0);
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("--------------\n\n");
		System.out.println("Search results are sorting acording to their prices to decreasing order");
		samet.sortProducts(searchResults, 1);
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("--------------\n\n");
		System.out.println("Search results are sorting acording to their names to decreasing order");
		samet.sortProducts(searchResults, 2);
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("--------------\n\n");
		System.out.println("Search results are sorting acording to their names to increasing order");
		samet.sortProducts(searchResults, 3);
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("--------------\n\n");
		System.out.println("Search results are sorting acording to their discount amount increasing order");
		samet.sortProducts(searchResults, 4);
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("--------------\n\n");
		System.out.println("Search results are sorting acording to their discount amount decreasing order");
		samet.sortProducts(searchResults, 5);
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("--------------\n\n");
		System.out.println("Search results are filtering by lower bound 250");
		searchResults = samet.filterResults(searchResults, 250, -1);
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("--------------\n\n");
		System.out.println("Search results are filtering by upper bound 1000");
		searchResults = samet.filterResults(searchResults, -1, 1000);
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("--------------\n\n");
		System.out.println("Search results are filtering by lower bound 250 and upper bound 750");
		searchResults = samet.filterResults(searchResults, 250, 750);
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("Customer creating order by first of search results and the second one:");
		System.out.println(samet.createOrder(searchResults.get(0)));
		System.out.println(samet.createOrder(searchResults.get(1)));
		System.out.println("Customer searching products of trader Alisha");
		searchResults = samet.getProductsOfTrader("Alisha");
		for(int i=0;i<searchResults.size();i++) {
			searchResults.get(i).print();
		}
		System.out.println("--------------\n\n");
		System.out.println("Trader is creating named as Alisha from csv file and logging In");
		Trader alisha = new Trader("Alisha");
		System.out.println(alisha.logIn(10000001, "123456"));
		System.out.println("--------------\n\n");
		Product product = new Product("Table", "12324241", "Metal Tables", 750, 400,"Alisha");
		product.addCategory("Furniture");
		product.addCategory("Tables");
		System.out.println("Alisha adding product named as table");
		System.out.println(alisha.addProduct(product));
		System.out.println("--------------\n\n");
		System.out.println("Alisha trying to add same product again");
		System.out.println(alisha.addProduct(product));
		System.out.println("--------------\n\n");
		System.out.println("Alisha trying to edit table prices");
		System.out.println(alisha.editProduct("12324241", 0, 0));
		System.out.println("--------------\n\n");
		System.out.println("Alisha trying to edit product which is not in the storage");
		System.out.println(alisha.editProduct("34343", 0, 0));
		System.out.println("--------------\n\n");
		System.out.println("Alisha trying to remove table product");
		System.out.println(alisha.removeProduct(product.getID()));
		System.out.println("--------------\n\n");
		System.out.println("Alisha trying to remove table product again");
		System.out.println(alisha.removeProduct(product.getID()));
		System.out.println("--------------\n\n");
		System.out.println("New trader logging in as an Big Company to check orders.");
		Trader bigCompany = new Trader("Big Company");
		System.out.println(bigCompany.logIn(10000153, "123456"));
		System.out.println("--------------\n\n");
		Queue<Order> orders = new LinkedList<>();
		orders = bigCompany.getOrders();
		bigCompany.displayOrders(orders);
		System.out.println("--------------\n\n");
		System.out.println("Big company meets first order.");
		System.out.println(bigCompany.approveOrder(orders, orders.peek(), true));
		System.out.println("Big company cancel second order.");
		System.out.println(bigCompany.approveOrder(orders, orders.peek(), false));
		
	}
	
	public static void menu() throws IOException {
		int choice=0,selection=0,choice2 = 5,ID,sort =0,upper,lower,number,price,discount;
		String password,name,id,describtion;
		Customer customer;
		Trader trader;
		Scanner input = new Scanner(System.in);
		ArrayList<Product> searchResults = new ArrayList<>();
		Product product;
		Queue<Order> orders;
		while(choice != 3) {
			choice=0;
			System.out.println("1)Customer Menu\n2)Trader Menu\n3)Exit");
			choice = input.nextInt();
			switch(choice) {
				case 1:
					selection = 0;
					while(selection !=3) {
						System.out.println("1)Log In\n2)Register\n3)Exit");
						selection = input.nextInt();
						switch(selection) {
							case 1:
								System.out.println("Enter your ID:");
								ID = input.nextInt();
								System.out.println("Enter your password:");
								input.nextLine();
								password = input.nextLine();
								customer = new Customer();
								if(customer.logIn(ID, password)) {
									System.out.println("Successfully Loged In!");
									choice2 = 1;
									while(choice2 !=0) {
										System.out.println("1)Search Products\n2)Filter search by category\n3)Sort Search Results\n4)Filter by bounds\n5)Make an order\n0)Exit");
										choice2 = input.nextInt();
										switch(choice2) {
											case 1:
												System.out.println("Enter the search text:");
												input.nextLine();
												name = input.nextLine();
												searchResults= customer.searchProducts(name);
												customer.printResults(searchResults);
												break;
											case 2:
												System.out.println("Enter the category name:");
												input.nextLine();
												name = input.nextLine();
												searchResults = customer.filterResultsbyCategory(searchResults, name);
												customer.printResults(searchResults);
												break;
											case 3:
												System.out.println("1)Sort acording to their prices to increasing order\n2)Sort acording to their prices to decreasing order\n3)Sort acording to their names to decreasing order\n4)Sort acording to their names to increasing order");
												System.out.print("5)Sort acording to their discount rate to increasing order\n6)Sort acording to their discount rate to increasing order\n");
												sort = input.nextInt();
												if(sort >5 || sort < 1) {
													System.out.println("Wrong Selection!");
												}
												else {
													customer.sortProducts(searchResults, sort-1);
													customer.printResults(searchResults);
												}
												break;
											case 4:
												System.out.println("Enter lower bound first then enter upper bound.If any of them will enter -1 single bounds will aceppted");
												lower = input.nextInt();
												upper = input.nextInt();
												if(upper == -1 && lower == -1) {
													System.out.println("Wrong selection!");
												}
												else {
													searchResults = customer.filterResults(searchResults, lower, upper);
													customer.printResults(searchResults);
												}
												break;
											case 5:
												System.out.println("-----PRODUCTS-----");
												customer.printResults(searchResults);
												System.out.println("Enter the number of product which you want to make an order");
												number = input.nextInt();
												if(number < 1 || number> searchResults.size()) {
													System.out.println("Wrong Selection!");
												}
												else {
													customer.createOrder(searchResults.get(number-1));
												}
												break;
											case 0:
												selection = 3;
												break;
										}
									}
								}
								else {
									System.out.println("Password or ID is wrong!");
								}
								break;
							case 2:
								System.out.println("Enter your password:");
								input.nextLine();
								password = input.nextLine();
								if(password.length() != 8) {
									System.out.println("Password must be 8 digit");
								}
								else {
									customer = new Customer();
									customer.register(password);
								}
								break;
							case 3:
								break;
							default:
								System.out.println("Wrong Selection");
								break;
							
						}						
					}
					break;
				case 2:
					selection = 0;
					while(selection !=3) {
						System.out.println("1)Log In\n2)Register\n3)Exit");
						selection = input.nextInt();
						switch(selection) {
							case 1:
								System.out.println("Enter your ID:");
								ID = input.nextInt();
								System.out.println("Enter your password:");
								input.nextLine();
								password = input.nextLine();	
								trader = new Trader();
								if(trader.logIn(ID, password)) {
									choice2 = 1;
									System.out.println("Successfully Loged In!");
									while(choice2 !=0) {
										System.out.println("1)Add Product\n2)Remove Product\n3)Edit Product\n4)Meet Orders\n0)Exit");
										choice2 = input.nextInt();
										switch(choice2) {
											case 1:
												System.out.println("Enter the name of product:");
												input.nextLine();
												name = input.nextLine();
												System.out.println("Enter the id of product:");
												id = input.nextLine();
												System.out.println("Enter the describtion of product:");
												describtion = input.nextLine();
												System.out.println("Enter the price of product:");
												price = input.nextInt();
												System.out.println("Enter the discounted price of product:");
												discount = input.nextInt();
												product = new Product(name,id,describtion,price,discount,trader.getName());
												while(!name.equals("-1")) {
													System.out.println("Enter the category of the product as a hiearachly.Enter -1 to exit! (Example first 'Furniture' then 'Chair')");
													name = input.nextLine();
													if(!name.equals("-1")) {
														product.addCategory(name);
													}
												}
												if(trader.addProduct(product) == false) {
													System.out.println("Product already in storage!");
												}
												else {
													System.out.println("Operation is succesful");
												}
												break;
											case 2:
												System.out.println("Enter the id of product which you want to remove:");
												input.nextLine();
												id = input.nextLine();
												if(trader.removeProduct(id)) {
													System.out.println("Operation is succesful");
												}
												else {
													System.out.println("Product couldn't found!");
												}
												break;
											case 3:
												System.out.println("Enter the id of product which you want to edit:");
												input.nextLine();
												id = input.nextLine();
												System.out.println("Enter the new price of product:");
												price = input.nextInt();
												System.out.println("Enter the new disccounter price of product:");
												discount = input.nextInt();
												if(trader.editProduct(id, price, discount)) {
													System.out.println("Operation is succesful");
												}
												else {
													System.out.println("Product couldn't found!");
												}
												break;
											case 4:
												orders = trader.getOrders();
												trader.displayOrders(orders);
												System.out.println("Enter the number of order to meet or cancel:");
												number = input.nextInt();
												if(orders != null) {
													if(number < 1 || number > orders.size()) {
														System.out.println("Wrong Selection");
													}
													else {
														System.out.println("Enter 1 to meet,Enter 0 to cancel");
														int flag = input.nextInt();
														if(flag != 1 && flag != 0) {
															System.out.println("Wrong Choice!");
														}
														else {
															int i=0;
															if(orders != null) {
																Iterator<Order> iter = orders.iterator();
																while(iter.hasNext()) {
																	i++;
																	if(i == number-1) {
																		break;
																	}
																}
																if(trader.approveOrder(orders,iter.next(), flag == 1)) {
																	System.out.println("Operation is succesfull.");
																}
																else {
																	System.out.println("Proceses couldn't done!");
																}
															}

														}
													}
												}
												
												break;
											case 0:
												selection = 3;
												break;
										}
									}
								}
								break;
							case 2:
								System.out.println("Enter your name:");
								input.nextLine();
								name = input.nextLine();
								System.out.println("Enter your password:");
								password = input.nextLine();
								if(password.length() != 8) {
									System.out.println("Password must be 8 digit");
								}
								else {
									trader = new Trader();
									trader.register(name, password);
								}
								break;
							case 3:
								
								break;
							default:
								System.out.println("Wrong Selection\n");
								break;
						}
					}
					break;
					
				case 3:
					break;
				default:
					System.out.println("Wrong Choice!");
					break;
			
			}
		}
		input.close();
	}
	
	
	public static void readAndWrite() throws NumberFormatException, IOException{
		File csvFile = new File("e-commerce-samples.csv");
		File productFile = new File("products.txt");
		File traderFile = new File("users.txt");
		FileWriter writer = new FileWriter(productFile);
		FileWriter writer2 = new FileWriter(traderFile);
		ArrayList<Trader> temp = new ArrayList<>();
		BinarySearchTree<String> traders = new BinarySearchTree<>();
		String row,category;
		BufferedReader csvReader = new BufferedReader(new FileReader(csvFile));
		productFile.createNewFile();
		row = csvReader.readLine();
		if (csvFile.isFile()) {
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(";");
				for(int i=0;i<data.length;i++) {
					if(i == 2) {
						category = data[i];
						category = category.substring(4,category.length()-4);
						writer.write(category);
						writer.write("\n");
					}
					else {
						writer.write(data[i]);
						writer.write("\n");
					}
				}
				traders.add(data[data.length-1]);
			}

		}
		traverseTree(temp,traders);
		for(int i=0;i<temp.size();i++) {
			writer2.write("trader");
			writer2.write("\n");
			writer2.write(temp.get(i).getName());
			writer2.write("\n");
			writer2.write("123456");
			writer2.write("\n");
			writer2.write(Integer.toString(temp.get(i).getID()));
			writer2.write("\n");
		}
		FileWriter writer3 = new FileWriter("orders.txt");
		writer.close();
		csvReader.close();
		writer2.close();
		writer3.close();
		
	}

	public static void traverseTree(ArrayList<Trader> traders,BinaryTree<String> traderTree) {
		if(traderTree == null) {
			return;
		}
		traders.add(new Trader(traderTree.getData()));
		traverseTree(traders,traderTree.getLeftSubtree());
		traverseTree(traders,traderTree.getRightSubtree());
		
	}
}
