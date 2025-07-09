public class Fiction extends Book{
    
    private String genreId;

    public Fiction () {

        super();
        genreId = "";
    }

    public Fiction (String title, String genreId, Customer cust) {

        super(title, cust);
        this.genreId = genreId;

    }

    public void setGenreId (String genreId) { this.genreId = genreId; }
    public String getGenreId () { return genreId; }

    public double calcAdditionalFee () {

        double addFee = 0.0;

        if (super.getBookDayOfRenting() > 5) {

            addFee = (super.getBookDayOfRenting() - 5) * 2;
        }
        
        return addFee;
    }

    public double calcTotalFiction () {

        double totalFiction = 0.0;

        totalFiction = super.calcTotal() + calcAdditionalFee();

        return totalFiction;
    }

     public double calcFinalTotal() {
        return calcTotalFiction();
    }

    public String SubGenre () {

        String subGenre = "";

        if (genreId.equalsIgnoreCase("H"))
            subGenre = "HORROR";
        else if (genreId.equalsIgnoreCase("F"))
            subGenre = "FANTASY";
        else if (genreId.equalsIgnoreCase("R"))
            subGenre = "ROMANCE";
        
        return subGenre;
    }

    public String toString () {

        return super.toString() + 
        "Additional fee : RM" + calcAdditionalFee() + 
        "\nGenre : " + SubGenre();
    }


}
