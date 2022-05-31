package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> ulist = new ArrayList<>();
        DBHandler db = new DBHandler(this);
        for (int i = 0; i < 20; i++) {
            Random rand = new Random();
            int random = rand.nextInt();
            int random2 = rand.nextInt();
            Boolean random3 = rand.nextBoolean();
            User u = new User(("Name"+random),("Description "+random2),i,random3);
            db.insertUser(u);
        }
        ulist = db.getUsers();
        RecyclerView rv = findViewById(R.id.recyclerView);
        ProfileAdapter adapter = new ProfileAdapter(ulist);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);

        /**
        ImageView i = findViewById(R.id.imageView2);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(ListActivity.this);
                b.setTitle("Profile");
                b.setMessage("MADness");
                b.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                b.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Random r = new Random();
                        int num = r.nextInt(1000000000);
                        Intent intent = new Intent(ListActivity.this, MainActivity.class);
                        intent.putExtra("random", num);
                        startActivity(intent);
                    }
                });
                AlertDialog a = b.create();
                a.show();
            }
        });**/
    }
}