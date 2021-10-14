/**
 * Office Desk
 */

public class OfficeDesk extends Product{

    private String [] models = {"Square","Rectangle","Wooden","Plastic","Narrow"};
    private String [] colours = {"Red","Black","White","Gray"};
    /**
     * Constructor for the office desk.
     * @param model of the office desk.
     * @param colour of the office desk.
     */
    public OfficeDesk(String model,String colour){
        super(model,colour);
    }
    @Override
    /**
     *@return models of the office desk table
     */
    public String[] getModels() {
        return models;
    }
    @Override
    /**
     *@return colours of the office desk table
     */    
    public String[] getColours() {
        return colours;
    }
    @Override
    public String toString(){
        return this.getModel()+ " "+this.getColour() +" "+this.getClass().getName();
    }
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
        if(!(o instanceof OfficeDesk)){
            return false;
        }
        return getModel().equals(((OfficeDesk)o).getModel()) && getColour().equals(((OfficeDesk)o).getColour());
    }
}