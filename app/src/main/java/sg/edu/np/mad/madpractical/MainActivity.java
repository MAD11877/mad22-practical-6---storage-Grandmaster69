package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User u = (User) getIntent().getSerializableExtra("user");
        Button btn = findViewById(R.id.button);
        Button messagebtn = findViewById(R.id.button2);
        TextView t = findViewById(R.id.name);
        TextView d = findViewById(R.id.description);
        Intent receive = getIntent();
        t.setText(u.Name);
        d.setText(u.Description);
        if (u.Followed == true){
            btn.setText("UNFOLLOW");
        }
        else{
            btn.setText("FOLLOW");
        }
        messagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(i);
            }
        });
        DBHandler db = new DBHandler(this);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (btn.getText() == "FOLLOW") {
                    Toast toast = Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT);
                    toast.show();
                    btn.setText("UNFOLLOW");
                    u.Followed = false;
                    db.updateUser(u);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT);
                    toast.show();
                    btn.setText("FOLLOW");
                    u.Followed = true;
                    db.updateUser(u);
                }
            }
        });
    }
}