
package Dictionary;


public class DLinkedListNode {
        
    private DLinkedListNode nextNode;
    private DLinkedListNode prevNode;
    private String data;
    private final String nodeType;
    
    public DLinkedListNode(String Data, String Type){
        data = Data;
        nodeType = Type;
    }  
    public String getNodeType(){
        return nodeType;
    }
    public String getData(){
        return data;
    }
    public DLinkedListNode getNext(){
        return nextNode;
    }
    public DLinkedListNode getPrev(){
        return prevNode;
    }   
    public void setNext(DLinkedListNode givenNode){
        nextNode = givenNode;
    }  
    public void setPrev(DLinkedListNode givenNode){
        prevNode = givenNode;
    }
    public void setData(String givenData){
        data = givenData;
    }
    public String toString(){
        return "Dictionary Node Linked List \n" + nodeType + "\n " + data;
    }
}
