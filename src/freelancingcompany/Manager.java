package freelancingcompany;

import java.io.Serializable;
import java.time.LocalDate;

public class Manager extends User implements Serializable {

    protected String Gender;
    protected String ID;

    public Manager(String Name, String Gender, String ID, String Email, LocalDate DOB, String password) {
        super(Name, Email, DOB, password);
        this.Gender = Gender;
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return password;
    }
     public void show(){
         System.out.println(this.Email);
         System.out.println(this.password);
     }
}
