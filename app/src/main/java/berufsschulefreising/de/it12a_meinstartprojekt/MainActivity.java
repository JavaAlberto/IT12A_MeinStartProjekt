package berufsschulefreising.de.it12a_meinstartprojekt;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView label;
    Button red;
    Button yellow;
    Button end;
    String farbwert = "green";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label = (TextView)findViewById(R.id.textView_Anzeige);
        red   = (Button)findViewById(R.id.buttonRed);
        yellow = (Button) findViewById(R.id.buttonYellow);
        end = (Button)findViewById(R.id.buttonEnde);
        red.setOnClickListener(this);
        yellow.setOnClickListener(this);
        end.setOnClickListener(this);
        if (savedInstanceState == null)label.setBackgroundColor(Color.BLUE);
        else
        {
            String textfarbe = savedInstanceState.getString("textfarbe");
            Toast.makeText(this,"Die folgende Farbe wurde in onCreate ausgelesen " + textfarbe, Toast.LENGTH_LONG).show();
            switch (textfarbe) {
                case "red":
                    label.setBackgroundColor(Color.RED);
                    break;
                case "yellow":
                    label.setBackgroundColor(Color.YELLOW);
                    break;
                default:
                    label.setBackgroundColor(Color.GREEN);

            }
        }


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("textfarbe", farbwert);
        Toast.makeText(this,"Die folgende Farbe wird gespeichert " + farbwert, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        String textfarbe = savedInstanceState.getString("textfarbe");
        Toast.makeText(this,"Die folgende Farbe wurde ausgelesen " + textfarbe, Toast.LENGTH_LONG).show();
        switch (textfarbe) {
            case "red":
                label.setBackgroundColor(Color.RED);
                break;
            case "yellow":
                label.setBackgroundColor(Color.YELLOW);
                break;
            default:
                label.setBackgroundColor(Color.GREEN);

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
switch(v.getId()) {
    case R.id.buttonRed:
        label.setBackgroundColor(Color.RED);
        farbwert = "red";
        break;
    case R.id.buttonYellow:
        label.setBackgroundColor(Color.YELLOW);
        farbwert = "yellow";
        break;
    case R.id.buttonEnde:
        finish();
}
    }
}
