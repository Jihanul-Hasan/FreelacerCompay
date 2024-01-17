package freelancingcompany;

import java.io.Serializable;
import java.time.LocalDate;

class User implements Serializable {

    protected String Name;
    protected String Email;
    protected LocalDate DOB;
    protected String password;

    public User(String Name, String Email, LocalDate DOB, String password) {
        this.Name = Name;
        this.Email = Email;
        this.DOB = DOB;
        this.password = password;
    }

    protected String getName() {
        return this.Name;
    }
}
