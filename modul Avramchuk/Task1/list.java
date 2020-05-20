package Module2;




public class list{
    private Linklist head;
    private Linklist tail;



    private boolean error=true;
    private int sum;

    public list(){
        head=null;
        tail=null;
    }

    public boolean isError() {
        return error;
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
   /* public void addLast(int data,int Players){
        Linklist temp = new Linklist(data,Players);
        if (isEmpty()) {
            head = temp;
        } else {
            tail.next = temp;
        }
        temp.prev =tail;
        tail =temp;

    }*/

    public int getSum() {
        return sum;
    }

    public void Endless() {
        Linklist temp =head;
        if(temp == null ){

        }else {
            int sum = 0;
            while (temp != null) {

                sum += temp.Players;

                temp = temp.next;
            }
            System.out.println("sum=" + sum);
            this.sum = sum;
        }
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
        if(temp == null ){
          //  System.out.println("error");
           this.error=false;
        }
        else {
            if (head.next == null) {
                tail = temp;
            } else {
                head.next.prev = null;
            }
            head = head.next;
        }
    }
    public void print(){
        Linklist temp =head;
        if(temp == null ){
            System.out.println("error");
        }
        else{
            while(temp !=null) {
                System.out.println(temp.Players);
                temp = temp.next;
            }Endless();
        }
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