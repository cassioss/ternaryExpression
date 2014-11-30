package ternary;

/**
 * Created by Cassio dos Santos Sousa on Nov/29/2014.
 */

public class Node {
    private Node left;
    private Node right;
    private String variable_name;

    public Node(){
        this.left = new Node();
        this.right = new Node();
    }

    public String getVariable_name(){
        return this.variable_name;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public void setRight(Node right){
        this.right = right;
    }

}
