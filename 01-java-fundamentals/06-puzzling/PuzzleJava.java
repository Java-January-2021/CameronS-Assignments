import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;
import java.util.AbstractCollection;
import java.util.stream.Collectors;

public class PuzzleJava{
    public ArrayList<Integer> sumMax(int[] input, ArrayList<Integer> maxVals, int max){
        int sum = 0;
        for(int i = 0; i < input.length; i++){
            sum += i;
            if(input[i] > max){
                maxVals.add(input[i]);
            }
        }
        System.out.println("Total: "+sum);
        return maxVals;
    }
    public ArrayList<String> mixNamesMax(String[] namesArray,ArrayList<String> namesList, ArrayList<String> largeNames, int charMax){
        for(int i = 0; i < namesArray.length; i++){
            namesList.add(namesArray[i]);
            String temp = namesArray[i];
            int max = temp.length();
            if(max > charMax){
                largeNames.add(namesArray[i]);
            }
        }
        System.out.println("Origonal Array: "+Arrays.toString(namesArray));
        Collections.shuffle(namesList);
        System.out.println("Shuffled List: "+namesList);
        return largeNames;
    }
    public ArrayList<Character> alphabetSoup(ArrayList<Character> input){
        for(char alph = 'a'; alph <= 'z'; ++alph){
            input.add(alph);
        }
        System.out.println("A-Z: "+input);
        Collections.shuffle(input);
        System.out.println("Shuffled: "+input);
        System.out.println("First Letter: "+input.get(0));
        System.out.println("Last Letter: "+input.get(25));
        char first = input.get(0);
        char[] vowels = {'a','e','i','o','u'};
        for(int i = 0; i < vowels.length; i++){
            if(vowels[i] == first){
                System.out.print("The first letter seems to be a vowel! ");
            }
        }
        return input;
    }
    public ArrayList<Integer> randomList(ArrayList<Integer> input){
        for(int i = 55; i <= 100; i++){
            input.add(i);
        }
        Random random = new Random();
        ArrayList<Integer> randomTen = new ArrayList<Integer>();
        for( int i = 0; i < 10; i++){
            int randomNum = random.nextInt(45);
            randomTen.add(input.get(randomNum));
        }
        return randomTen;
    }
    public void sortedList(ArrayList<Integer> input){
        ArrayList<Integer> listToSort = randomList(input);
        System.out.println("Ten Random #'s between 55-100 in an List: ");
        System.out.println(listToSort);
        Collections.sort(listToSort);
        System.out.println("That list sorted in ascending order:");
        System.out.println(listToSort);
        System.out.println("Min value:");
        System.out.println(Collections.min(listToSort));
        System.out.println("Max value:");
        System.out.println(Collections.max(listToSort));
    }
    public String randomString(int max){
        ArrayList<Character> input = new ArrayList<Character>();
        Random random = new Random();
        ArrayList<Character> randCharList = new ArrayList<Character>();
        ArrayList<String> randStrList = new ArrayList<String>();
        for(char alph = 'a'; alph <= 'z'; ++alph){
            input.add(alph);
        }
        for(int i = 0; i < max; i++){
            int randomNum = random.nextInt(25);
            randCharList.add(input.get(randomNum));
        }
        String str = new String();
        for(int i = 0; i < randCharList.size(); i++){
            char temp = randCharList.get(i);
            str = String.valueOf(temp);
            randStrList.add(str);
        }
        StringBuffer sb = new StringBuffer();
        for(String s : randStrList){
            sb.append(s);
            sb.append("");
        }
        String finalStr = sb.toString();
        return finalStr;
    }
    public ArrayList<String> randomStringS(int strMax, int arrMax){
        ArrayList<String> listOfRandomStrings = new ArrayList<String>();
        for(int i = 0; i < arrMax; i++){
            Random random = new Random();
            ArrayList<Character> randCharList = new ArrayList<Character>();
            ArrayList<Character> input = new ArrayList<Character>();
            ArrayList<String> randStrList = new ArrayList<String>();
            for(char j = 'a'; j <= 'z'; ++j){
                input.add(j);
            }
            for(int d = 0; d < strMax; d++){
                int randomNum = random.nextInt(25);
                randCharList.add(input.get(randomNum));
            }
            String str = new String();
            for(int w = 0; w < randCharList.size(); w++){
                char temp = randCharList.get(w);
                str = String.valueOf(temp);
                randStrList.add(str);
            }
            StringBuffer sb = new StringBuffer();
            for(String s : randStrList){
                sb.append(s);
                sb.append("");
            }
        String finalStr = sb.toString();
        listOfRandomStrings.add(finalStr);
        }
        return listOfRandomStrings;
    }
}
