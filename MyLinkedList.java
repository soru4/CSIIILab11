public class MyLinkedList<E> implements GenericList<E>
{
    private Node<E> head; 
    private int size ;
    public MyLinkedList(){
        head = new Node(null);
        size = 0;
    }
    /**
     *  Add obj to the end of the list.
     *  This method always returns true
     */
    public boolean add(E obj){
        Node<E> n =head;
        while(n.getNext()!=null){
            n = n.getNext();
        }
        n.setNext(new Node(obj));
        size++;
        return true;
    }
    
    /**
     *  Add obj to the specified index of the list.
     *  If index is too big, then add obj to the end of the list
     *  If index is too small, then add obj to the start of the list
     */
    public void add(int index, E obj){
       
            Node<E> n = new Node(obj);
            Node<E> before = getIndex(index - 1);
            if(index <= 0)
                before = head;
            Node<E> after = before.getNext();
            before.setNext(n);
            n.setNext(after);
            size ++;
        
            
            
   
            
    }
    
    /**
     *  Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(E obj){
        Node<E> n = head.getNext(); 
        while(n != null){
           
            if(n.getValue().equals(obj)){
                
                return true;
            }
            n = n.getNext();
           
        }
        return false; 
    }
    
    /**
     *  Return the Object located at the specified index
     *  If index is too big or too small, return null
     */
    public E get(int index){
          int count= 0;
        Node<E> n = head.getNext();
        
        E prevValue = null;
        if(count == index){
                prevValue = n.getValue();
                return prevValue;
            }
        if(index < 0 || index >= size()){
            return null;
        }
        while(n.getNext() != null){
            
            count++;
            n = n.getNext();
                
            if(count == index){
                prevValue = n.getValue();
                return prevValue;
            }
        }
        return prevValue;
    }
    
    /**
     *  Return true if there are no elements in the list
     */
    public boolean isEmpty(){
        return size() == 0 ;
    }
    
    
    private Node<E> getIndex(int index){
        int count= 0;
        Node<E> n = head.getNext();
        E prevValue = null;
        if(index < 0 || index >= size()){
            return null;
        }
      
        while(n != null){
             if(count == index){
                 break;
            }
            count++;
            n = n.getNext();
                
          
        }
        return n;
    }
    /**
     *  Remove the Object at the specified index from the list
     *  Return the Object that was removed
     *  If index is too big or to small, do not remove anything from the list and return null
     *  If the list is empty, return null
     */
    public E remove(int index){
        
        if(index <0 || index > size() - 1 || isEmpty() ){
            return null;
        }
        Node<E> b = getIndex(index - 1);
        Node<E> n = getIndex(index);
        if(n==null){
            return null;
        }
        Node<E> a = n.getNext();
        if(b!=null){
        b.setNext(a);
        return n.getValue();
        }
        else{
            b = head;
            b.setNext(a);
            return n.getValue();
        }
 
    }
    
    
    /**
     *  Remove the first Object that is .equals() to obj
     *  Return true if an object was removed
     */
    public boolean remove(E obj){
        if(obj == null || !(contains(obj)))
            return false;
        remove(indexOf(obj));
        return true;
        
    }
    private int indexOf(E obj){
        int spot = 0;
        Node<E> n = head.getNext();
        while(n != null){
            if(n==null)
                return -1;
            if(n.getValue().equals(obj))
                return spot;
            spot++;
            n = n.getNext();
        }
        return -1;
    }
    
    /**
     *  Change the value stored at index to obj
     *  Return the value that was replaced
     *  If index is too big or too smalll, do not change and values and return null
     */
    public E set(int index, E obj){
         int count= 0;
        if(index < 0 || index > size() -1 ){return null;}
        Node<E> prevValue = getIndex(index);
        if(prevValue == null){
        return null;
        }
        E x = prevValue.getValue();
        getIndex(index).setValue(obj);
        return x;
    }
    
    /**
     *  Return the number of elements that are in the list
     */
    public int size(){
        int count= 0;
        Node<E> n = head.getNext();
        while(n != null){
            count++;
            n = n.getNext();
        }
        return count;
    }
    class Node<E>
    {
        // instance variables - replace the example below with your own
        private Node<E> next; 
        private E value; 
    
        /**
         * Constructor for objects of class Node
         */
        public Node(E data)
        {
            value = data; 
        }
        
        public E getValue(){
            return value; 
        }
        
        public E setValue(E data){
            E prev = value;
            value = data; 
            return prev; 
        }
        
        public Node<E> getNext(){
            return next; 
        }
        
        public Node<E> setNext(Node<E> node){
            Node<E> nexts = next;
            next = node; 
            return nexts;
        }
    }
}


