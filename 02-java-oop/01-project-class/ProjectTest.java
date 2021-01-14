import java.util.ArrayList;

public class ProjectTest{
    public static void main(String[] args){
        Project comunitySquare = new Project();
        comunitySquare.setName("Town Square");
        comunitySquare.setCost(2000000);
        comunitySquare.setDesc("Town square, fenced in 'open' area. Closeable for alchohol serving or ticketed events. Daily opperations provides seating for tourists and some shade trees. Once a week farmers market. Gazeebo for periodic music events. Electricity and water hookups for market and music.");
        System.out.println(comunitySquare.elevatorPitch());
        Project deli = new Project("Jacks Deli","Small town local deli. Sanwiches are amazing, shelves are dusty.", 70000);
        System.out.println(deli.elevatorPitch());
        Project hardwareFeed = new Project("Julian Hardware & Feed", "Hardware store and construction materials. Feed Store and livestock supplies", 1000000);
        System.out.println(hardwareFeed.elevatorPitch());
        Project campSupply = new Project("PCT Supply Stop", 50000);
        System.out.println(campSupply.elevatorPitch());
        Project treeNursury = new Project("Julian Tree Nursury", "Plant nursury that raises and sells local flora and fauna. Specializing in trees. Yearly christmas tree lot, pumpkin patch and sledding. Vegetable stand for locals with in season year around selection");
        System.out.println(treeNursury.elevatorPitch());
        campSupply.setDesc("Backpacking and dry camping supply store with coin-op laundry and showers. Mail pickup and daily trail head shuttle services available. Firewood and drycamping spots available to purchase.");
        treeNursury.setCost(85000);
        System.out.println(campSupply.elevatorPitch());
        System.out.println(treeNursury.elevatorPitch());
        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioProject(comunitySquare);
        portfolio.setPortfolioProject(deli);
        portfolio.setPortfolioProject(treeNursury);
        portfolio.setPortfolioProject(campSupply);
        portfolio.setPortfolioProject(hardwareFeed);
        System.out.println(portfolio.getPortfolio().toString());
        System.out.println(portfolio.showPorfolio());
    }
}