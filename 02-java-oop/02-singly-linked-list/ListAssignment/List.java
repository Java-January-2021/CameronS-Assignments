public class List{
    Node head;
    int size;

    public List(){
        this.head = null;
        this.size = 0;
    }

    public void addToList(int value){
        Node newNode = new Node(value);
        if(this.head == null){
            this.head = newNode;
            System.out.println("Node: "+value+" has been added as the head node.");
            this.size ++;
        }else{
            Node runner = this.head;
            while(runner.next != null){
                runner = runner.next;
            }
            runner.next = newNode;
            System.out.println("Node: "+value+" has been added to the end of the list");
            this.size ++;
        }
    }
    public boolean find(int value){
        if(this.head == null){
            System.out.println("List is empty.");
        }
        Node runner = this.head;
        int counter = 0;
        while(runner != null){
            if(runner.value == value){
                System.out.println(value+" is at node #"+counter);
                return true;
            }
            runner = runner.next;
            counter++;
        }
        System.out.println(value+" is  not in the list.");
        return false;
    }
    public void deleteEnd(){
        if(this.head == null){
            System.out.println("List is empty.");
        }
        Node runner = this.head;
        while(runner.next.next != null){
            runner = runner.next;
        }
        runner.next = null;
    }
    public void deleteAtNode(int value){
        if(this.head == null){
            System.out.println("List is empty.");
        }
        Node runner = this.head;
        if(value == 0 && this.size > 1){
            this.head = runner.next;
        }else{
            int counter = 0;
            while(runner.next != null){
                if(counter == value-1){
                    runner.next = runner.next.next;
                    return;
                }
                runner = runner.next;
                counter++;
            }
        }
    }
    public void deleteValue(int value){
        if(this.head == null){
            System.out.println("List is empty.");
        }
        Node runner = this.head;
        if(value == this.head.value && this.size > 1){
            this.head = runner.next;
        }else{
            int counter = 0;
            while(runner.next != null){
                if(runner.next.value == value){
                    runner.next = runner.next.next;
                    return;
                }
                runner = runner.next;
                counter++;
            }
        }
    }
    public void insert(int value, int atNode){
        Node newNode = new Node(value);
        if(this.head == null){
            this.head = newNode;
            System.out.println("Node: "+value+" has been added as the head node.");
            this.size ++;
        }else{
            Node runner = this.head;
            Node previousRunner = null;
            while(runner.next != null && runner.value != atNode){
                previousRunner = runner;
                runner = runner.next;
            }
            newNode.value = value;
            newNode.next = runner;
            previousRunner.next = newNode;

            System.out.println("Node Value: "+value+" has been added before "+runner.value);
            this.size ++;
        }
    }
    public void printValues(){
        if(this.head == null){
            System.out.print("this list is empty.");
        }
        Node runner = this.head;
        int counter = 0;
        while(runner != null){
            if(counter < 1){
                System.out.println("Node "+counter+" is the head: Value of "+runner.value);
                counter++;
                runner = runner.next;
            }else{
                System.out.println("Node "+counter+": Value of "+runner.value);
                runner = runner.next;
                counter++;
            }
        }
    }
}