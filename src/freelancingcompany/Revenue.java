package freelancingcompany;

import java.io.Serializable;

public class Revenue implements Serializable {

    protected String Month;
    protected String Year;
    protected double Week1;
    protected double Week2;
    protected double Week3;
    protected double Week4;

    public Revenue(String Month, String Year, double Week1, double Week2, double Week3, double Week4) {
        this.Month = Month;
        this.Year = Year;
        this.Week1 = Week1;
        this.Week2 = Week2;
        this.Week3 = Week3;
        this.Week4 = Week4;
    }

    double ShowTotalRevenueOfMonth() {

        return Week1 + Week2 + Week3 + Week4;

    }
}
