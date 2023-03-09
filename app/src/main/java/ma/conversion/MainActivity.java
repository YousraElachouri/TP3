package ma.conversion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText monnaie;
    private RadioButton Euro,Dinar;
    private Button conv;
    private TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monnaie = findViewById(R.id.monnaie);
        Euro= findViewById(R.id.Euro);
        Dinar= findViewById(R.id.Dinar);
        conv=findViewById(R.id.conv);
        res=findViewById(R.id.res);
        conv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ch = monnaie.getText().toString().trim();
                if (ch.isEmpty()){
                   error();
                }
                else{
                    String m = monnaie.getText().toString().trim();
                    double number=0;
                    try{
                        number=Double.parseDouble(m);
                    }catch (NumberFormatException ex){
                        Log.i("MyInfos" , "entez un nomber svp");
                        return;
                    }
                    if (Euro.isChecked()) {
                        double result = number * 3.6;
                        res.setText(number + " DT =  " + result + " Euro");
                    } else {
                        double result = number * 1.8;
                        res.setText(number + " Euro =  " + result + " DT");
                    }

                }
            }
        });

    }
    private void error() {
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Erreur");
        alertDialog.setMessage("champs monnaie vide !!!");
        alertDialog.setButton(alertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}