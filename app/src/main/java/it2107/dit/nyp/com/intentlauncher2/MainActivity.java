package it2107.dit.nyp.com.intentlauncher2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView recentActTV;
    EditText usernameET, passwordET;
    Button loginBT;
    final int SHOP_ACTIVITY_RESULT_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recentActTV = (TextView)findViewById(R.id.recentActTV);
        usernameET = (EditText)findViewById(R.id.userNameET);
        passwordET = (EditText)findViewById(R.id.passwordET);
        loginBT = (Button)findViewById(R.id.loginBT);

        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,ShopActivity.class);
                myIntent.putExtra("username", usernameET.getText().toString());
                startActivityForResult(myIntent,SHOP_ACTIVITY_RESULT_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == SHOP_ACTIVITY_RESULT_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                String recentActivity = data.getStringExtra(ShopActivity.RETURN_MSG);
                Log.i("recentActivity", recentActivity);
                recentActTV.setText(recentActivity);
            }
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
        else
        {
            if(id == R.id.action_about)
            {
                Intent myIntent = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(myIntent);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
