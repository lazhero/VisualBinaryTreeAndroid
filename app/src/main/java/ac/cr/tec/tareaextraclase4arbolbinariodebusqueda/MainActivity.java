package ac.cr.tec.tareaextraclase4arbolbinariodebusqueda;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import ac.cr.tec.tareaextraclase4arbolbinariodebusqueda.BinaryTree.BinarySearchTree;

public class MainActivity extends AppCompatActivity {
    private BinarySearchTree tree;
    private int count=0;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void init(View view){
        Intent intent=new Intent(this,TreeActivity.class);
        startActivity(intent);
    }



}
