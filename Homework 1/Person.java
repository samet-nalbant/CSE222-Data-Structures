/**
 * Person
 */
public class Person{

    private String personName;
    private String personSurname;
    /**
     * Constructor for Person
     * @param name of the person
     * @param surname of the person
     */
    Person(String name,String surname){
        this.setName(name);
        this.setSurname(surname);
    }
    /**
     * Setter function for name.
     * @param name of the person.
     */
    public void setName(String name){this.personName = name;}   
    /**
     * Setter function for surname.
     * @param surname of the person.
     */ 
    public void setSurname(String surname){this.personSurname = surname;}
    /**
     * Getter function for name.
     * @return name of the person.
     */    
    public String getName(){return this.personName;}
    /**
     * Getter function for surname.
     * @return surname of the person.
     */
    public String getSurname(){return this.personSurname;}

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(!(o instanceof Person)){
            return false;
        }
        return getName() == ((Person)o).getName() && getSurname() == ((Person)o).getSurname();
    }
}