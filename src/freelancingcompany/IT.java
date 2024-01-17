
package freelancingcompany;

import java.io.Serializable;
import java.time.LocalDate;

public class IT extends User implements Serializable{
    
      protected String Gender;
    public IT(String Name, String Email, LocalDate DOB, String password) {
        super(Name, Email, DOB, password);
    }
    
}
