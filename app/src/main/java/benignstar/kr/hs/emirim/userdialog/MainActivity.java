package benignstar.kr.hs.emirim.userdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text_name, text_email;
    Button but;
    EditText edit_name, edit_email;
    TextView toast_text;
    View dialogView, toastView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_name=(TextView)findViewById(R.id.text_name);
        text_email=(TextView)findViewById(R.id.text_email);
        but=(Button)findViewById(R.id.but);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView=(View) View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("User Information Input");
                dlg.setIcon(R.drawable.user);
                dlg.setView(dialogView);
                dlg.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edit_name=(EditText)dialogView.findViewById(R.id.edit_name);
                        edit_email=(EditText)dialogView.findViewById(R.id.edit_email);

                        text_name.setText(edit_name.getText().toString());
                        text_email.setText(edit_email.getText().toString());
                    }
                });
                dlg.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView=(View)View.inflate(MainActivity.this, R.layout.toast, null);
          //              toast_text=(TextView)view.findViewById(R.id.to)
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });

    }


}
