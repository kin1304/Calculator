package com.example.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public ArrayList<Character> pheptinh;
    public ArrayList<Integer> operator;
    private void Xuly(String s){
        TextView Tinh=findViewById(R.id.Function);
        TextView Ans=findViewById(R.id.Answer);
        String tmp=Ans.getText().toString();
        if(tmp!="") {
            Tinh.setText(tmp+s);
            Ans.setText("");
        }
        else {
            String txt = Tinh.getText().toString();
            Tinh.setText(txt + s);
        }
    }
    public int TinhToan(String bt){
        operator= new ArrayList<Integer>();
        pheptinh = new ArrayList<Character>();
        int vt=0;
        int n=bt.length();
        for(int i=0;i<n;i++){
            char c=bt.charAt(i);
            if(c=='+'||c=='-'||c=='x'||c=='/'){
                String s=bt.substring(vt,i);
                vt=i+1;
                operator.add(Integer.parseInt(s));
                pheptinh.add(c);
            }
        }
        String s= bt.substring(vt,n);
        operator.add(Integer.parseInt(s));
        int i=0;
        while(i<pheptinh.size()){
            char c=pheptinh.get(i);
            if(c=='x'||c=='/'){
                int s1=operator.get(i);
                int s2=operator.get(i+1);
                int tong;
                if(c=='x') {tong=s1*s2;}
                else {tong=s1/s2;}
                operator.remove(i);
                operator.set(i,tong);
                pheptinh.remove(i);
            }
            else i++;
        }
        i=0;
        while(i<pheptinh.size()){
            char c= pheptinh.get(i);
            int tong;
            if(c=='+'){
                tong=operator.get(i)+operator.get(i+1);
            }
            else
            {
                tong=operator.get(i)-operator.get(i+1);
            }
            operator.remove(i);
            pheptinh.remove(i);
            operator.set(0,tong);
        }
        return operator.get(0);
    }

    public void Number1(View view) {
        Xuly("1");
    }

    public void Number2(View view) {
        Xuly("2");
    }

    public void Number3(View view) {
        Xuly("3");
    }

    public void Number4(View view) {
        Xuly("4");
    }

    public void Number5(View view) {
        Xuly("5");
    }

    public void Number6(View view) {
        Xuly("6");
    }

    public void Number7(View view) {
        Xuly("7");
    }

    public void Number8(View view) {
        Xuly("8");
    }

    public void Number9(View view) {
        Xuly("9");
    }

    public void Plus(View view) {
        Xuly("+");
    }

    public void Minus(View view) {
        Xuly("-");
    }

    public void Mul(View view) {
        Xuly("x");
    }

    public void Div(View view) {
        Xuly("/");
    }
    public void AC(View view) {
        TextView Tinh=findViewById(R.id.Function);
        Tinh.setText("");
        TextView Ans=findViewById(R.id.Answer);
        Ans.setText("");
    }

    public void Del(View view) {
        TextView Tinh=findViewById(R.id.Function);
        String txt=Tinh.getText().toString();
        int LengthTxt = txt.length()-1;
        Tinh.setText(txt.substring(0,LengthTxt));
    }

    public void Number0(View view) {
        Xuly("0");
    }

    public void dot(View view) {
        Xuly(".");
    }

    public void Equal(View view) {
        TextView Ans = findViewById(R.id.Answer);
        TextView Bieuthuc = findViewById(R.id.Function);
        String bt = Bieuthuc.getText().toString();
        int tong=TinhToan(bt);
        String s= String.valueOf(tong);
        Ans.setText(s);
    }
}