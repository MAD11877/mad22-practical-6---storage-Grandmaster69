package sg.edu.np.mad.madpractical;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button loginbutton = findViewById(R.id.loginbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().trim().isEmpty()){
                    username.setError("Username cannot be empty!");
                    return;
                }
                if (password.getText().toString().trim().isEmpty()){
                    password.setError("Password cannot be empty!");
                    return;
                }

                FirebaseDatabase db = FirebaseDatabase.getInstance("https://madpractical6-660c9-default-rtdb.asia-southeast1.firebasedatabase.app/");
                DatabaseReference dr = db.getReference("Users");
                dr.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot user : snapshot.getChildren()) {
                            if (user.child("username").getValue().toString().equals(username.getText().toString())) {
                                if (user.child("password").getValue().toString().equals(password.getText().toString())) {
                                    startActivity(new Intent(LoginPage.this, ListActivity.class));
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}