public class FirstJavaProgram {
    public static void main(String[] args){
String name = "Cameron,";
        String namestring = "My name is ";
        String agestring1 = "I am ";
        String agestring2 = " years old.";
        String hometown = "Julian, CA.";
        String homestring = "My hometown is ";
        double myage = 33.12;
        float namestrlength = (namestring + name).length();
        float agestringlength = (agestring1 + agestring2 + myage).length();
        double homestringlength = (hometown + homestring).length();
        int j = (int) namestrlength;
        int p = (int) agestringlength;
        int i = (int) homestringlength;
        int age = (int) myage;
        System.out.println(namestring + name + "(str.len = " + j + ")");
        System.out.println(agestring1 + age + agestring2 + "(str.len = " + p + ")");
        System.out.println(homestring + hometown + "(str.len = " + i + ")");
    }
}