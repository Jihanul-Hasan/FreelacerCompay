package freelancingcompany;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomerCareExecutive extends User implements Serializable {

    protected String Gender;
    protected String ID;

    public CustomerCareExecutive(String Name, String Gender,String ID, String Email, LocalDate DOB, String password) {
        super(Name, Email, DOB, password);
        this.Gender = Gender;
        this.ID=ID;
    }

}
