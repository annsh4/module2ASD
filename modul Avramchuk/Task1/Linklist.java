package Module2;

public class Linklist {
    public int data;int Players;
    public Linklist next;
    public Linklist prev;
    public Linklist(int data,int Players){
        this.data=data;
        this.Players=Players;
    }
    public Linklist(int data) {
        this.Players = data;
    }
}
