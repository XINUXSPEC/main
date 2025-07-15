import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B <T> implements Deque61B<T>{

    public Node virtual;
    int size;
    static public class Node<T>{
        Node pre,next;
        T item;
        public Node(){
            this.pre=this.next=this;
        }
    }

    public LinkedListDeque61B(){
        this.virtual=new Node<T>();
        size=0;
    }
//
    @Override
    public void addFirst(T x) {
        this.size++;
        Node<T> p=new Node<>();
        p.item=x;
        p.next=this.virtual.next;
        p.pre=this.virtual;
        this.virtual.next.pre=p;
        this.virtual.next=p;
    }

    @Override
    public void addLast(T x) {
        this.size++;
        Node<T> p=new Node<>();
        p.item=x;
        p.pre=this.virtual.pre;
        this.virtual.pre.next=p;
        p.next=this.virtual;
        this.virtual.pre=p;
    }

    @Override
    public List<T> toList() {
        Node<T> p=this.virtual;
        List<T> list=new ArrayList<>();
        p=p.next;
        while (p!=this.virtual){
            list.add(p.item);
            p=p.next;
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return this.virtual.pre==this.virtual?true:false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (this.virtual.pre==this.virtual){
            return null;
        }
        this.size--;
        Node<T> p=this.virtual.next;
        p.next.pre=this.virtual;
        this.virtual.next=this.virtual.next.next;
        return p.item;
    }

    @Override
    public T removeLast() {
        if (this.virtual.pre==this.virtual){
            return null;
        }
        this.size--;
        Node<T> p=this.virtual.pre;
        p.pre.next=this.virtual;
        this.virtual.pre=p.pre;
        return p.item;
    }

    @Override
    public T get(int index) {
        Node<T> p=new Node<>();
        p=this.virtual;
        p=p.next;
        int cnt=0;
        while (p!=this.virtual&&cnt<index){
            p=p.next;
            cnt++;
        }
        return cnt==index?p.item:null;
    }

    private T getRecursiveHelp(Node p,int index){
        if (index==0){
            return (T) p.item;
        }else if (this.virtual==p){
            return null;
        }
        return getRecursiveHelp(p.next,index-1);
    }

    @Override
    public T getRecursive(int index) {
        return getRecursiveHelp(this.virtual.next,index);
    }
}
