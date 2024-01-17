package freelancingcompany;

import java.io.Serializable;
import java.time.LocalDate;

public class CEO extends User implements Serializable {

    protected String Gender;
    protected String ID;

    public CEO(String Name, String Gender, String ID,String Email, LocalDate DOB, String password) {
        super(Name, Email, DOB, password);
        this.Gender = Gender;
        this.ID= ID;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public String getPassword() {
        return password;
    }

}
