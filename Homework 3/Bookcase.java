
/**
 * Bookcase
 */
public class Bookcase extends Product{

    private String [] models = {"Long Size","Short size","Middle size","Narrow","Wide","Circle","Square","Rectangle","Wooden","Plastic","Grid","Reverse"};
    private String [] colours = {};
    /**
     * Constructor for the bookcase.
     * @param model of the bookcase.
     */
    public Bookcase(String model){
        super(model);
    }

    @Override
    public String toString(){
        return this.getModel()+ " "+this.getClass().getName();
    }
    @Override
    /**
     *@return models of the bookcase
     */
    public String [] getModels(){return models;}
    @Override
    /**
     *@return colours of the bookcase
     */
    public String [] getColours(){return colours;}
    @Override
    /**
     * Prints available models of the bookcase.
     */
    public void showModels(){
        System.out.println("Models:");
        for(int i=0;i<getModels().length;i++){
            System.out.println((i+1)+") "+getModels()[i]);
        }
        System.out.println("\n");
    }
    @Override
    public boolean equals(Object o){
        
        if(o == null){
            return false;
        }
        if(!(o instanceof Bookcase)){
            return false;
        }
        return getModel().equals(((Bookcase)o).getModel());
    }
}