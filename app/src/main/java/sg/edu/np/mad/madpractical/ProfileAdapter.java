package sg.edu.np.mad.madpractical;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder> {
    ArrayList<User> data;
    public ProfileAdapter(ArrayList<User> data){
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        String user = data.get(position).Name;
        String lastnum = user.substring(user.length()-1);
        if(lastnum.equals("7")) {
            return 1;
        }
        return 0;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item;
        if (viewType == 1){
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.seventh_layout, null, false);
        }
        else{
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_layout, null, false);
        }
        return new ProfileViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        User u = data.get(position);
        holder.username.setText(u.Name);
        holder.description.setText(u.Description);
        ImageView img = holder.itemView.findViewById(R.id.profileimg);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(img.getContext());
                alert.setTitle("Profile");
                alert.setMessage(u.Name);
                alert.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent tomain = new Intent(img.getContext(), MainActivity.class);
                        tomain.putExtra("user", u);
                        img.getContext().startActivity(tomain);
                    }
                });
                alert.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
