package ac.cr.tec.tareaextraclase4arbolbinariodebusqueda.BinaryTree;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BinarySearchTree extends View {
    private TreeNode root;
    private int screenSize;
    private final int spaceFromUpward=200;

    public BinarySearchTree(Context context) {
        super(context);
    }

    public BinarySearchTree(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BinarySearchTree(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BinarySearchTree(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void insert(int data){
       root=insertion(root,data,0,screenSize/2,TreeNode.getRadius()+spaceFromUpward);
       invalidate();

    }
    public TreeNode insertion(TreeNode node,int data,int height,int XPos,int YPos){
        if(node==null){
            TreeNode temp= new TreeNode(data,height);
            temp.setX_Axis(XPos);
            temp.setY_Axis(YPos);
            return temp;
        }
        if(node.getData()==data)return node;
        int changing=screenSize/((int)Math.pow(2,height+2));
        if(node.getData()<data){
            node.setRight(insertion(node.getRight(),data,height+1,XPos+changing,YPos+(height+1)*TreeNode.getRadius()));
        }
        else node.setLeft(insertion(node.getLeft(),data,height+1,XPos-changing,YPos+(height+1)*TreeNode.getRadius()));
        return node;
    }
    public void delete(int data){
        this.root=deletion(root,data);
        invalidate();
    }
    public TreeNode deletion(TreeNode node,int data){
        if(node==null)return null;
        if(node.getData()==data){
            if(node.getLeft()==null && node.getRight()==null){
                return null;
            }
            int info;
            if(node.getLeft()==null){
                info=findMin(node.getRight()).getData();
                node.setRight(deletion(node.getRight(),info));
            }
            else{
                info=findMax(node.getLeft()).getData();
                node.setLeft(deletion(node.getLeft(),info));
            }
            node.setData(info);
            return node;
        }
        else if(node.getData()<data)node.setRight(deletion(node.getRight(),data));
        else node.setLeft(deletion(node.getLeft(),data));
        return node;
    }
    public boolean find(int data){
        TreeNode node=finding(root,data);
        return !(node==null);

    }
    private TreeNode findMax(TreeNode node){
        if(node==null)return null;
        if(node.getRight()==null)return node;
        return node.getRight();
    }
    private TreeNode findMin(TreeNode node){
        if(node==null)return null;
        if(node.getLeft()==null)return node;
        return node.getLeft();
    }
    public TreeNode finding(TreeNode node,int data){
        if(node==null)return null;
        if(node.getData()==data)return node;
        if(node.getData()<data)return finding(node.getRight(),data);
        return finding(node.getLeft(),data);
    }
    public ArrayList<TreeNode> getInOrder(){
        ArrayList<TreeNode> ArrayList=new ArrayList<>();
        gettingListInOrder(root,ArrayList);
        return ArrayList;
    }
    public void gettingListInOrder(TreeNode node,ArrayList<TreeNode> arrayList){
        if(arrayList==null)return;
        if(node==null)return;
        gettingListInOrder(node.getLeft(),arrayList);
        arrayList.add(node);
        gettingListInOrder(node.getRight(),arrayList);
    }
    public ArrayList<TreeNode> getPostOrder(){
        ArrayList<TreeNode> arrayList= new ArrayList<>();
        gettingListPostOrder(root,arrayList);
        return arrayList;

    }
    public void gettingListPostOrder(TreeNode node, ArrayList<TreeNode> arrayList){
        if(arrayList==null)return;
        if(node==null)return;
        gettingListPostOrder(node.getLeft(),arrayList);
        gettingListPostOrder(node.getRight(),arrayList);
        arrayList.add(node);
    }
    public ArrayList<TreeNode>  getListPreOrder(){
        ArrayList<TreeNode> arrayList=new ArrayList<>();
        gettingListPreOrder(root,arrayList);
        return arrayList;
    }
    public void gettingListPreOrder(TreeNode node,ArrayList<TreeNode> arrayList){
        if(arrayList==null)return;
        if(node==null)return;
        arrayList.add(node);
        gettingListPreOrder(node.getLeft(),arrayList);
        gettingListPreOrder(node.getRight(),arrayList);
    }
    public int TreeHeight(){
        return GetNodeHeight(root);
    }
    public int GetNodeHeight(TreeNode node){
        if(node==null)return 0;
        int right=GetNodeHeight(node.getRight());
        int left=GetNodeHeight(node.getLeft());
        int res;
        if(left>right){
            res=left;
        }
        else res=right;
        return res+1;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(root!=null) root.draw(canvas);
    }

    public int getScreenSize() {
        return screenSize;
    }
    public void setScreenSize(int screenSize){
        this.screenSize=screenSize;
    }
}
