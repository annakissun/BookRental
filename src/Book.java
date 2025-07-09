public abstract class Book {
    
    private String title;
    private Customer c;

    public Book () {

        title = "";

    }

    public Book (String title, Customer cust) {

        this.title = title;
        this.c = cust;
    }

    public void setTitle (String title) { this.title = title; }

    public String getTitle () { return title; }
    public Customer getCustomer () { return c; }

    //get full title
    public String getfullTitle () {

        String fullTitle = "";

        //fiction
        if (title.equalsIgnoreCase("IEWU"))
            fullTitle = "IT ENDS WITH US";
        else if (title.equalsIgnoreCase("SOA"))
            fullTitle = "SONG OF ACHILLES";

        //nonfiction
        else if (title.equalsIgnoreCase("CP"))
            fullTitle = "COLLEGE PHYSICS";
        else if (title.equalsIgnoreCase("MAFL"))
            fullTitle = "MALAY AS A FIRST LANGUAGE";
        

        return fullTitle;
    }

    //get full ISBN
    public String getfullISBN () {

        String fullISBN = "";

        //fiction
        if (title.equalsIgnoreCase("IEWU"))
            fullISBN = "154111";
        else if (title.equalsIgnoreCase("SOA"))
            fullISBN = "231189";

        //nonfiction
        else if (title.equalsIgnoreCase("CP"))
            fullISBN = "779441";
        else if (title.equalsIgnoreCase("MAFL"))
            fullISBN = "090191";

        return fullISBN;
    }

    public String getfullAuthor () {

        String fullAuthor = "";

        //fiction
        if (title.equalsIgnoreCase("IEWU"))
            fullAuthor = "COLLEEN HOOVER";
        else if (title.equalsIgnoreCase("SOA"))
            fullAuthor = "MADELINE MILLER";
        
        //nonfiction
        else if (title.equalsIgnoreCase("CP"))
            fullAuthor = "RAYMOND SERWAY/CHRIS VUILLE";
        else if (title.equalsIgnoreCase("MAFL"))
            fullAuthor = "AZFA BT ISHAK/ZURAIMA BT MOHAMAD";
            
        return fullAuthor;
    }

    //get price per day
    public double getpricePerDay () {

        double price = 0;

            if (title.equalsIgnoreCase("IEWU"))
            price = 5.50;
        else if (title.equalsIgnoreCase("SOA"))
            price = 6.0;
        else if (title.equalsIgnoreCase("CP"))
            price = 3.0;
        else if (title.equalsIgnoreCase("MAFL"))
            price = 2.0;

        return price;

    }

    //get total
    public int getBookDayOfRenting () { return c.getDayOfRenting(); }

    public double calcTotal () {

        double calcTotal = 0.0;

        calcTotal = c.getDayOfRenting() * getpricePerDay();

        return calcTotal;
    }

    public abstract double calcFinalTotal();

    public String toString () {

        return c.toString() +

        "\nTitle : " +getfullTitle()+ 
        "\nAuthor : " +getfullAuthor()+ 
        "\nISBN : " +getfullISBN()+ 
        "\nPrice per day : RM" +getpricePerDay()+ 
        "\nTotal before additional fee/student discount : RM" +calcTotal()+ "\n";
    }

}
