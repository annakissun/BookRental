public class NonFiction extends Book{

    private String subject;
    private String studentDiscount;

    public NonFiction () {

        super();
        subject = "";
        studentDiscount = "";
    }

    public NonFiction (String title, String subject, String studentDiscount, Customer cust) {

        super (title, cust);
        this.subject = subject;
        this.studentDiscount = studentDiscount;
    }

    public void setSubject (String subject) { this.subject = subject; }
    public void setStudentDiscount (String studentDiscount) { this.studentDiscount = studentDiscount; }
    public String getSubject () { return subject; }
    public String getStudentDiscount () { return studentDiscount; }

    public double calcDiscountFee () {

        double studDis = 0.0;

        if (studentDiscount.equalsIgnoreCase("Y"))
            studDis = super.calcTotal() * 0.3;
        else if (studentDiscount.equalsIgnoreCase("N"))
            studDis = 0;

        return studDis;
    }

    public double calcTotalNonFiction () {

        double totalNonFiction = 0.0;
        
        totalNonFiction = super.calcTotal() - calcDiscountFee();

        return totalNonFiction;
    }

     public double calcFinalTotal() {
        return calcTotalNonFiction();
    }

    public String FullSubject () {

        String fullSubject = "";

        if (subject.equalsIgnoreCase("PHY"))
            fullSubject = "PHYSICS";
        else if (subject.equalsIgnoreCase("BM"))
            fullSubject = "BAHASA MELAYU";

        return fullSubject;
    }

    public String toString () {

        return super.toString() + 
        "Total fiction : RM" + calcDiscountFee() + 
        "\nSubject : " + FullSubject();
    }
}
