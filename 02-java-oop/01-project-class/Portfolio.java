import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Project> Projects;

    public Portfolio(){
        this.Projects = new ArrayList<Project>();
    }
    public void setPortfolioProject(Project i){
        Projects.add(i);
    }
    public ArrayList<Project> getPortfolio(){
        return this.Projects;
    }
    public String getPortfolioCost(){
        double portCost = 0;
        for(Project i : this.Projects){
            portCost += i.getCost();
        }
        String costDisplay = ("Total Porfolio Cost: "+"$"+portCost);
        return costDisplay;
    }
    public String showPorfolio(){
        for(Project p : this.Projects){
            System.out.println("Project: "+p.elevatorPitch());
        }
        return getPortfolioCost();
    }
}