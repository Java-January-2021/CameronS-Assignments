import java.util.ArrayList;
import java.util.Arrays;

public class BasicJavaTest {
    public static void main(String[] args){
        BasicJava basicMethods = new BasicJava();
        int count = 255;
        basicMethods.printCount(count);
        basicMethods.printOdds(count);
        basicMethods.printSum(count);
        int[] myArray = {1,3,5,7,9,13};
        basicMethods.iterateArray(myArray);
        int[] maxValueArray = {1,3,5,7,9,0};
        System.out.println(basicMethods.maxValue(maxValueArray));
        int[] getAvgArray = {2, 10, 3};
        System.out.println(basicMethods.getAverage(getAvgArray));
        ArrayList<Integer> oddCount = new ArrayList<Integer>();
        ArrayList<Integer> oddCounter = basicMethods.printOdds(oddCount, count);
        System.out.println(oddCounter);
        double max = 3;
        int[] greaterThanArray = {1, 3, 5, 7};
        System.out.println(basicMethods.greaterThan(greaterThanArray,max));
        int[] sqValArray = {1, 5, 10, -2};
        System.out.println(Arrays.toString(basicMethods.squareValues(sqValArray)));
        int[] noNegArray = {1, 5, 10, -2};
        System.out.println(Arrays.toString(basicMethods.noNegatives(noNegArray)));
        Integer[] mmaArray = {1, 5, 10, -2};
        ArrayList<Double> mMA = new ArrayList<Double>();
        ArrayList<Double> maxminAvg = basicMethods.maxMinAvg(mmaArray, mMA);
        System.out.println(maxminAvg);
        int[] shiftValArray = {1, 5, 10, 7, -2};
        System.out.println(Arrays.toString(basicMethods.shiftValues(shiftValArray)));
    }
}