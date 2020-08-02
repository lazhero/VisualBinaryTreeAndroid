package ac.cr.tec.tareaextraclase4arbolbinariodebusqueda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import ac.cr.tec.tareaextraclase4arbolbinariodebusqueda.BinaryTree.BinarySearchTree;
import ac.cr.tec.tareaextraclase4arbolbinariodebusqueda.BinaryTree.TreeNode;

public class TreeActivity extends AppCompatActivity{
    private BinarySearchTree tree;
    private int count=0;
    private EditText editText;
    private final int lapse=1000;
    private boolean running=false;
    private final String inputMessage="Number out of range";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        tree=(BinarySearchTree)findViewById(R.id.Hola);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        tree.setScreenSize(width);
        editText=(EditText)findViewById(R.id.NumberInput);





    }
    public  void ClearEditText(){
        editText.setText("");
    }
    public int getInfo(){
        try{
            String text = editText.getText().toString();
            ClearEditText();
            return Integer.parseInt(text);


        }
        catch (Exception e){

        }
        return -1;
    }
    public void callToast(String text){
        Toast toast=Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT);
        toast.show();
    }
    public void click(View view){
        if(running)return;
        running=true;
        int data=getInfo();
        if(data>=0 && data<100) tree.insert(data);
        else callToast(inputMessage);
        running=false;


    }
    public void delete(View view){
        if(running)return;
        running = true;
        int data = getInfo();
        if(data>0 && data<100) tree.delete(data);
        else callToast(inputMessage);
        running=false;

    }
    public void InOrder(View view){
        if(running)return;
        inTree(tree.getInOrder());
    }
    public void PostOrder(View view){
        if(running)return;
        inTree(tree.getPostOrder());

    }
    public void PreOrder(View view){
        if(running)return;
        inTree(tree.getListPreOrder());

    }
    public void inTree(ArrayList<TreeNode> get) {
        running=true;
        if(get==null)return;
        final ArrayList<TreeNode> List=get;
        count=0;
        new CountDownTimer(lapse*List.size(), lapse) {
            public void onFinish() {
                count=0;
                turnOff(List);
                running=false;
            }

            public void onTick(long millisUntilFinished) {
                Ticker(List);

            }
        }.start();

    }
    public void Ticker(ArrayList<TreeNode> nodes){
        if(count<=nodes.size()){
            nodes.get(count).highLight();
            tree.invalidate();
        }
        count++;
    }
    public void turnOff(ArrayList<TreeNode> nodes){
        if(nodes==null)return;
        for(int i=0;i<nodes.size();i++){
            nodes.get(i).turnOff();
        }
        tree.invalidate();
    }



}

