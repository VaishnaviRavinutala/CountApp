package e.vaishnavi.countappsp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button black,red,blue,green;
    int c=0;
    private int colorcode;
    SharedPreferences sp;
    private String spFileName="e.vaishnavi.countappsp";
    private String countKey="countKey";
    private String colorKey="colorKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
        black=findViewById(R.id.btn1);
        red=findViewById(R.id.btn2);
        blue=findViewById(R.id.btn3);
        green=findViewById(R.id.btn4);
        sp= getSharedPreferences( spFileName,MODE_PRIVATE);
        if (sp!=null){
            c=sp.getInt(countKey,0);
            if( c!=0){
                tv.setText(String.valueOf(c));
            }
            colorcode=sp.getInt(colorKey,1);


                tv.setBackgroundColor(colorcode);

        }

    }

    public void count(View view) {
        c++;
        tv.setText(String.valueOf(c));
    }

    public void reset(View view) {
        c=0;
        tv.setText(""+c);
        colorcode= getResources().getColor(R.color.grey);
        tv.setBackgroundColor(colorcode);
    }

    public void black(View view) {
        colorcode=getResources().getColor(R.color.black);
        tv.setBackgroundColor(colorcode);
    }

    public void red(View view) {
        colorcode= getResources().getColor(R.color.red);
        tv.setBackgroundColor(colorcode);
    }

    public void blue(View view) {
        colorcode= getResources().getColor(R.color.blue);
        tv.setBackgroundColor(colorcode);
    }

    public void green(View view) {
        colorcode= getResources().getColor(R.color.green);
        tv.setBackgroundColor(colorcode);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //c= Integer.parseInt(tv.getText().toString());
        //colorcode= Integer.parseInt(tv.getBackground().toString());
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt(countKey,c);
        editor.putInt(colorKey,colorcode);
        editor.apply();
        Toast.makeText(this,"count : "+c+"\n"+colorcode+"Successfully Saved in sp",Toast.LENGTH_SHORT).show();
    }
}
