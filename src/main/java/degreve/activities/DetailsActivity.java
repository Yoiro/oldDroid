package degreve.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import be.helha.degreve.la141353.degreve.R;

public class DetailsActivity extends AppCompatActivity {

    private Object item;
    private Button btnMainMenu;
    private TextView tvTitre;
    private TextView tvType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras=getIntent().getExtras();
        item=extras.getSerializable("Class");
        int index=extras.getInt("id");

        tvTitre=(TextView)findViewById(R.id.tvTitre_Details);
        tvType=(TextView)findViewById(R.id.tvType_Details);

        btnMainMenu=(Button)findViewById(R.id.btnMainMenu_Details);
        btnMainMenu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
