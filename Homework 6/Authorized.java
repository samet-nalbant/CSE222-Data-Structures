import java.io.FileNotFoundException;

public class Authorized implements User {

	private static int x= 0;
	private String password;
	private int ID;
	private boolean loginStatus=false;
	
	/**
	 * Constructor for Authorized Class.
	 */
	public Authorized(){
		x+=1;
		setID(x+10000000);
	}
	
	@Override
	public boolean logIn(int ID,String password) throws FileNotFoundException {
		return true;
		
	}

	/**
	 * Returns the password.
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Sets the password.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Returns the ID.
	 * @return
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Sets the ID.
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * Checks whether the user successfully loged in or not.
	 * @return
	 */
	public boolean getLoginStatus() {
		return loginStatus;
	}
	protected void changeLoginStatus() {
		loginStatus = true;
	}



}
