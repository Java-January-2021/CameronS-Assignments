public class PythagoreanTest {
    public static void main(String[] args){
        Pythagorean math = new Pythagorean();
        double legA = 1.5;
        double legB = 2.5;
        double hypotenuse = math.calculateHypotenuse(legA,legB);
        System.out.println(hypotenuse);
    }
}