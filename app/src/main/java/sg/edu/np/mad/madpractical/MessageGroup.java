package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);
        Button grp1 = findViewById(R.id.group1);
        Button grp2 = findViewById(R.id.group2);
        TextView text = findViewById(R.id.textView3);
        ImageView image = findViewById(R.id.imageView3);
        image.setVisibility(View.INVISIBLE);
        text.setVisibility(View.INVISIBLE);
        grp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setVisibility(View.VISIBLE);
                image.setVisibility(View.INVISIBLE);
            }
        });
        grp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setVisibility(View.VISIBLE);
                text.setVisibility(View.INVISIBLE);
            }
        });
    }
}