public class FizzBuzz {
    public String FizzBuzz(int val){
        if(val % 3 == 0 && val % 5 == 0){
            return "FizzBuzz";
        }else if(val % 3 == 0){
            return "Fizz";
        }else if(val % 5 == 0){
            return "Buzz";
        }else{
            return Integer.toString(val);
        }
    }
    public void fizzBuzzCounter(){
        for(int i = 0; i <=100; i++){
            String result = FizzBuzz(i);
            System.out.println("Number "+ i +" - "+"Result: " + result);
        }
    }
}