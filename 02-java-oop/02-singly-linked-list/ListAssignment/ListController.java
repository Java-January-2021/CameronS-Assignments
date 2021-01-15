public class ListController {
    public static void main(String[] args) {
        List sll = new List();
        sll.addToList(3);
        sll.addToList(4);
        sll.addToList(6);
        sll.addToList(20);
        sll.addToList(21);
        sll.addToList(35);
        sll.addToList(2);
        sll.addToList(5);
        sll.addToList(1);
        sll.printValues();
        sll.find(20);
        sll.deleteEnd();
        sll.find(1);
        sll.deleteAtNode(2);
        //sll.printValues();
        sll.deleteValue(20);
        //sll.printValues();
        sll.insert(22,35);
        sll.printValues();
    }
}