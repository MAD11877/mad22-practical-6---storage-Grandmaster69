package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProfileViewHolder extends RecyclerView.ViewHolder {
    TextView username;
    TextView description;
    public ProfileViewHolder(View item) {
        super(item);

        username = item.findViewById(R.id.Username);
        description = item.findViewById(R.id.Description);
    }
}
