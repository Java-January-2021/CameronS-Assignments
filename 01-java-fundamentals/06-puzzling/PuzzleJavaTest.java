import java.util.ArrayList;


public class PuzzleJavaTest{
    public static void main(String[] args){
        PuzzleJava methods = new PuzzleJava();
        System.out.println("#1---------------");
        int[] sumMaxArray = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> maxVals = new ArrayList<Integer>();
        int max = 10;
        methods.sumMax(sumMaxArray,maxVals,max);
        System.out.println("Values > "+max+":" +maxVals);
        System.out.println("#2---------------");
        String[] namesArray = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        ArrayList<String> namesList = new ArrayList<String>();
        ArrayList<String> largeNames = new ArrayList<String>();
        int charMax = 5;
        methods.mixNamesMax(namesArray,namesList,largeNames,charMax);
        System.out.println("Names > "+charMax+" characters: "+ largeNames);
        System.out.println("#3---------------");
        ArrayList<Character> alphabet = new ArrayList<Character>();
        methods.alphabetSoup(alphabet);
        System.out.println("#4---------------");
        ArrayList<Integer> randomFortyFive = new ArrayList<Integer>(45);
        System.out.println("Ten Random #'s between 55-100 in an list: "+methods.randomList(randomFortyFive));
        System.out.println("#5---------------");
        ArrayList<Integer> randomTen = new ArrayList<Integer>();
        methods.sortedList(randomTen);
        System.out.println("#6---------------");
        int strMax = 5;
        System.out.println(methods.randomString(strMax));
        System.out.println("#7---------------");
        int arrMax = 10;
        System.out.println(methods.randomStringS(strMax, arrMax));
    }
}