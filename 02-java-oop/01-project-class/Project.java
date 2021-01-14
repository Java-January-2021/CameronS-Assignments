public class Project{
    private String projName;
    private String description;
    private double initialCost;

    public String elevatorPitch(){
        return projName+" ($"+initialCost+")"+" : "+description;
    }
    public Project(){
    }
    public Project(String name){
        this.projName = name;
    }
    public Project(String name, String desc){
        this.projName = name;
        this.description = desc;
    }
    public Project(String name, String desc, double cost){
        this.projName = name;
        this.description = desc;
        this.initialCost = cost;
    }
    public Project(String name, double cost){
        this.projName = name;
        this.initialCost = cost;
    }
    public void setName(String name){
        this.projName = name;
    }
    public void setDesc(String desc){
        this.description = desc;
    }
    public void setCost(double cost){
        this.initialCost = cost;
    }
    public String getName(){
        return projName;
    }
    public String getDesc(){
        return description;
    }
    public double getCost(){
        return initialCost;
    }





}