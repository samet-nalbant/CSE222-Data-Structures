/**
 * OfficeCabinet
 */

public class OfficeCabinet extends Product{

    private String [] colours = {};
    private String [] models  = {"Long Size","Short size","Middle size","Narrow","Wide","Circle","Square","Rectangle","Wooden","Plastic","Grid","Reverse"};
    /**
     * Constructor for the office cabinet.
     * @param model of the office cabinet.
     */
    public OfficeCabinet(String model){
        super(model);
    }
    public String toString(){
        return this.getModel()+ " "+this.getClass().getName();
    }
    @Override
    /**
     *@return models of the office cabinet.
     */
    public String [] getModels(){return models;}
    @Override
    /**
     *@return colours of the office cabinet.
     */
    public String [] getColours(){return colours;}
    @Override
    /**
     * Prints available models of the office cabinet.
     */
    public void showModels(){
        System.out.println("Models:");
        for(int i=0;i<getModels().length;i++){
            System.out.println((i+1)+")"+getModels()[i]);
        }
        System.out.println("\n");
    }
    @Override
    public boolean equals(Object o){
        
        if(o == null){
            return false;
        }
        if(!(o instanceof OfficeCabinet)){
            return false;
        }
        return getModel().equals(((OfficeCabinet)o).getModel());
    }
}