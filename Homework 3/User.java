/**
 * User
 */
public class User extends Person{

    private String userMail;
    private String userPassword;
    /**
     * Constructor for user.
     * @param name of the user.
     * @param surname of the user.
     * @param mail of the user.
     * @param password of the user.
     */
    public User(String name,String surname,String mail,String password){
        super(name,surname);
        this.setMail(mail);
        this.setPassword(password);
    }
    /**
     * Setter function for mail.
     * @param mail of user.
     */
    public void setMail(String mail){this.userMail = mail;}
    /**
     * Setter function for password.
     * @param password of user.
     */
    public void setPassword(String password){this.userPassword = password;}
    /**
     * Getter function for mail
     * @return mail of user.
     */
    public String getMail(){return this.userMail;}
    /**
     * Getter function for password.
     * @return password of user.
     */
    public String getPassword(){return this.userPassword;}
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(!(o instanceof User)){
            return false;
        }
        return getName() == ((User)o).getName() && getSurname() == ((User)o).getSurname() && getMail() == ((User)o).getMail() && getPassword() == ((User)o).getPassword(); 
    }
}