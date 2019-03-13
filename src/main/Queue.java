package main;

public class Queue
{
    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node front=null,rear=null;
    private int size=0;
    public void enqueue(int data)
    {
        Node newnode=new Node(data,null);
        if(this.front==null && this.rear==null)
        {
            this.front=newnode;
            this.rear=newnode;
        }
        else
        {
            this.rear.next=newnode;
            this.rear=newnode;

        }
        size++;
    }

    public void dequeue()
    {
        if(this.front!=null)
        {
            this.front=this.front.next;
            size--;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder response= new StringBuilder();
        response.append("[");
        Node temp=this.front;
        while(temp!=null)
        {
            response.append(temp.getData());
            if(temp.getNext()!=null) {
                response.append(" ==> ");
            }
            temp=temp.getNext();
        }
        response.append("]");
        return response.toString();
    }

    public static void main(String[] args)
    {
        Queue queue=new Queue();
        for(int i=0;i<5;i++)
        {
            queue.enqueue(i+2);
        }
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);

    }
}
