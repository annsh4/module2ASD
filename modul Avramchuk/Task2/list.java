package Test122;


public class list{
    private Linklist head;
    private Linklist tail;

    public list(){
        head=null;
        tail=null;
    }

    private  boolean isEmpty(){
        return head ==null;
    }

    public void add(int data, int Players) {
        Linklist temp = new Linklist(data,Players);
        if (isEmpty()) {
            tail = temp;
        } else{
            head.prev = temp;
        }
        temp.next = head;
        head =temp;
    }
    public void add(int data) {
        Linklist temp = new Linklist(data);
        if (isEmpty()) {
            tail = temp;
        } else{
            head.prev = temp;
        }
        temp.next = head;
        head =temp;
    }

    public void addLast(int data,int Players){
        Linklist temp = new Linklist(data,Players);
        if (isEmpty()) {
            head = temp;
        } else {
            tail.next = temp;
        }
        temp.prev =tail;
        tail =temp;

    }

    public void Endless() {
        Linklist temp =head;
        int sum=0;
        while(temp !=null){
            if(temp.Players>sum){
                sum=temp.Players;
            }
            temp =temp.next;
        }
        System.out.println("Endless num="+sum);
    }
    public void check(){
        Linklist temp=head;

        while(temp !=null){

            System.out.println(temp.data+" "+temp.Players);
            temp =temp.next;
        }
        temp=tail;

        while(temp !=null){
            System.out.println(temp.data+""+temp.Players);
        }
    }
    public void remove(){
        Linklist temp=head;
        if (head.next==null) {
            tail = temp;
        } else {
            head.next.prev = null;
        }
        head =head.next;
    }
    public void print(){
        Linklist temp =head;

        while(temp !=null){
            System.out.println(temp.data+" "+temp.Players);
           
            temp =temp.next;
        }
    }
    public void printTT(){
        Linklist temp =head;
        System.out.println("Head to tail");
        while(temp !=tail){
            System.out.println(temp.data+" "+temp.Players);
            temp =temp.next;
        }
        System.out.println(temp.data+" "+temp.Players);

        System.out.println("Tail to head");

        while(temp !=null){
            System.out.println(temp.data+" "+temp.Players);

            temp =temp.prev;
        }

    }
    public void printTTT(){
        Linklist temp =head;

        while(temp !=null){
            System.out.print(temp.data+" ");
            temp =temp.next;
        }

    }
    public void change(){
        Linklist temp =head;
        while(temp !=null){
            main.list.addLast(temp.data,temp.Players);
            temp =temp.next;
        }
        main.list.printTT();
    }
    public void removeLast(){
        if (head.next ==null)
            head=null;
        else
            tail.prev.next =null;

        tail =tail.prev;
    }
    public void removeAt(int key){
        Linklist temp =head;

        while(temp.data !=key) {
            temp = temp.next;

            if (temp == null)
                return;
        }
        if (temp == head)
            remove();
        else
            temp.prev.next = temp.next;

        if (temp == tail)
            removeLast();
        else
            temp.next.prev = temp.prev;
    }

}