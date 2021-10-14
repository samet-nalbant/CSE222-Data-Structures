/**
 * OfficeChair
 */

public class OfficeChair extends Product{
    private String [] models = {"Narrow","Wide","Circle","Square","Rectangle","Wooden","Plastic"};
    private String [] colours = {"Red","Blue","Black","White","Orange"};
    /**
     * Constructor for the office chair.
     * @param model of the office chair.
     * @param colour of the office chair.
     */
    public OfficeChair(String model,String colour){
        super(model,colour);
    }
    public String toString(){
        return this.getModel()+ " "+this.getColour() +" "+this.getClass().getName();
    }
    @Override
    /**
     *@return models of the office chair.
     */
    public String [] getModels(){return models;}
    @Override
    /**
     *@return colours of the office chair.
     */    
    public String [] getColours(){return colours;}
    @Override
    /**
     * Prints available models of the meeting table.
     */
    public void showModels(){
        System.out.println("Models:");
        for(int i=0;i<getModels().length;i++){
            System.out.println((i+1)+")"+getModels()[i]);
        }
        System.out.println("\n");
        System.out.println("Colours:");
        for(int i=0;i<getColours().length;i++){
            System.out.println((i+1)+")"+getColours()[i]);
        }
        System.out.println("\n");
    }
    @Override
    public boolean equals(Object o){
        
        if(o == null){
            return false;
        }
        if(!(o instanceof OfficeChair)){
            return false;
        }
        return getModel().equals(((OfficeChair)o).getModel()) && getColour().equals(((OfficeChair)o).getColour());
    }
    
}