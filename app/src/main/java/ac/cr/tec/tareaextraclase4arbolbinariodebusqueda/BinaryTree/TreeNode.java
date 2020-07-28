package ac.cr.tec.tareaextraclase4arbolbinariodebusqueda.BinaryTree;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class TreeNode {
    private static int TextSize;
    private static Paint linePaint;
    private static Paint downColor;
    private static Paint highLight;
    private static Paint TextPaint;
    private Paint onScreenPaint;
    private static int radius=70;
    private int data;
    private int X_Axis;
    private int Y_Axis;
    private TreeNode right,left;
    {
        TextSize=radius-10;
        downColor=getPaint(Color.rgb(20,20,20));
        downColor.setStyle(Paint.Style.FILL);
        highLight=getPaint(Color.rgb(40,60,90));
        highLight.setStyle(Paint.Style.FILL);
        linePaint=getPaint(Color.BLACK);
        TextPaint=getPaint(Color.WHITE);
        TextPaint.setTextSize(TextSize);
    }

    public  TreeNode(int data){
        this.data=data;
        onScreenPaint=downColor;
    }
    public void setLeft(TreeNode node){
        if(node==null)return;
        this.left=node;
    }
    public void setRight(TreeNode node){
        if(node==null)return;
        this.right=node;
    }
    public TreeNode getRight(){
        return right;
    }
    public TreeNode getLeft(){
        return left;
    }
    public int getData(){
        return data;
    }
    public void setData(int data){
        this.data=data;
    }
    public int getX_Axis(){
        return X_Axis;
    }
    public int getY_Axis(){
        return Y_Axis;
    }
    public void setX_Axis(int data){
        this.X_Axis=data;
    }
    public void setY_Axis(int data){
        this.Y_Axis=data;
    }
    public void highLight(){
        this.onScreenPaint=highLight;
    }
    public void turnOff(){
        this.onScreenPaint=downColor;
    }
    public void draw(Canvas canvas){
        if(canvas==null) return;
        if(this.right!=null){
            canvas.drawLine(X_Axis,Y_Axis,right.getX_Axis(),right.getY_Axis(),linePaint);
            right.draw(canvas);
        }
        if(this.left!=null){
            canvas.drawLine(X_Axis,Y_Axis,left.getX_Axis(),left.getY_Axis(),linePaint);
            left.draw(canvas);

        }
        canvas.drawCircle(X_Axis,Y_Axis,radius,onScreenPaint);
        canvas.drawText(String.valueOf(data),X_Axis-(TextSize/2),Y_Axis+(TextSize/3),TextPaint);
    }

    private static Paint getPaint(int color){
        Paint linePaint = new Paint();
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(3);
        linePaint.setColor(color);
        return linePaint;
    }
    private static int getRadius(){
        return radius;
    }
    private static  void setRadius(int Radius){
        radius=Radius;
    }
    private int getDigits(){
        if(data==0)return 1;
        int returning=0;
        int info=Math.abs(data);
        while(info>0){
            info=info/10;
            returning++;
        }
        return returning;
    }
}
