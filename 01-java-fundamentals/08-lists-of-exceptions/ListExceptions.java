import java.util.ArrayList;

public class ListExceptions {
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hello World");
        myList.add(48);
        myList.add("Goodbye World");

            for(int i = 0; i < myList.size(); i++) {
                try{
                Integer castedValue = (Integer) myList.get(i);
                //System.out.println(castedValue);
            } catch (Exception e) {
                System.out.println("Error: "+e);
                System.out.println("At Index of: "+i);
                System.out.println("Index Value: "+myList.get(i));
                //StackTraceElement castedValue[] = cause.getStackTrace();
                //for (int x = 0, n = castedValue.length-1; x < n; x++) {
                    //System.err.println(.getFileName()
                        //+ ":" + castedValue[x].getLineNumber()
                        //+ ">> "
                        //+ castedValue[i].getMethodName() + "()");
                    //}
                }
            }
            System.out.println(myList);
        }
    }
