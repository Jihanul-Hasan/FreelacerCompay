
package freelancingcompany;

import java.io.Serializable;

public class Post implements Serializable {
   protected String Name;
   protected String Email;
   protected String delivery;
   protected String Description;

    public Post(String Name, String Email, String delivery, String Description) {
        this.Name = Name;
        this.Email = Email;
        this.delivery = delivery;
        this.Description = Description;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getDescription() {
        return Description;
    }
   
   
}
