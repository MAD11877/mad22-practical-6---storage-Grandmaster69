package sg.edu.np.mad.madpractical;

import java.io.Serializable;

public class User implements Serializable {
    String Name;
    String Description;
    int Id;
    boolean Followed;

    public User(String name, String description, int id, boolean followed) {
        this.Name = name;
        this.Description = description;
        this.Id = id;
        this.Followed = followed;
    }
}
