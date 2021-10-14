import java.io.FileNotFoundException;

public interface User {

	boolean logIn(int ID, String password) throws FileNotFoundException;
	
}
