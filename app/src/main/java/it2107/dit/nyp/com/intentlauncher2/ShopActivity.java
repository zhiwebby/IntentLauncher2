package it2107.dit.nyp.com.intentlauncher2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {

    TextView welcomeTV;
    Button logoutBT;
    EditText quanET;
    static final String RETURN_MSG = "You have logged out";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        welcomeTV = (TextView)findViewById(R.id.welcomeTV);
        logoutBT = (Button)findViewById(R.id.logoutBT);
        quanET = (EditText)findViewById(R.id.quanET);

        Bundle extras = this.getIntent().getExtras();
        String usernameFromMain = extras.getString("username");

        welcomeTV.setText("Welcome " +usernameFromMain);

        logoutBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent output = new Intent();
                output.putExtra(RETURN_MSG, "You have bought " + quanET.getText().toString()+ " Android phones");
                setResult(RESULT_OK, output);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shop, menu);
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
}
