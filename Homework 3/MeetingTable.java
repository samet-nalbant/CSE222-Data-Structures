/**
 * Meeting Table
 */
public class MeetingTable extends Product{

    private String [] models = {"Long Size","Short size","Narrow","Wide","Circle","Square","Rectangle","Wooden","Plastic","Grid"};
    private String [] colours = {"Red","Black","White","Gray"};
    /**
     * Constructor for the meeting table.
     * @param model of the meeting table.
     * @param colour of the meeting table.
     */
    public MeetingTable(String model,String colour){
        super(model,colour);
    }

    public String toString(){
        return this.getModel()+ " "+this.getColour() +" "+this.getClass().getName();
    }
    @Override
    /**
     *@return models of the meeting table
     */
    public String [] getModels(){return models;}
    @Override
    /**
     *@return colours of the meeting table
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
        if(!(o instanceof MeetingTable)){
            return false;
        }
        return getModel().equals(((MeetingTable)o).getModel()) && getColour().equals(((MeetingTable)o).getColour());
    }

}