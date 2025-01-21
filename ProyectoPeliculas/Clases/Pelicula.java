package ProyectoPeliculas.Clases;

public class Pelicula {
    //Atributos

    private String id;
    private String rank;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;

    public  Pelicula(){}
    public Pelicula (String id, String title, String year, String dir, String act1, String act2,String imDbRating){

        setTitle(title);
        setYear(year);
        setFullTitle();
        setCrew(dir, act1, act2);
        setImDbRating(imDbRating);
        setId(id);

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        try {
            if (Integer.parseInt(rank) > 0 || Integer.parseInt(rank) < 250) {
                this.rank = rank;
            } else {
                this.rank = "-1";
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
            this.rank = "-1";
        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
        setFullTitle();
    }

    public String getFullTitle() {
        return fullTitle;
    }

    private void setFullTitle() {

        //Set fullTitle se compone de title + year
        this.fullTitle = this.title + " (" + this.year + ")";


    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        //El año no puede ser negativo y debe ser un número
        try {
            if (Integer.parseInt(year) > 0) {
                this.year = year;
                setFullTitle();
            } else {
                this.year = "1900";
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
            this.year = "1900";
        }

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String dir, String act1, String act2) {
        this.crew = dir + act1+ ", " + act2 ;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        try {
            if (Double.parseDouble(imDbRating) > 0) {
                this.imDbRating = imDbRating;
            } else {
                this.imDbRating = "0.0";
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
            this.imDbRating = "0.0";
        }

    }




    public String getImDbRatingCount() {
        return imDbRatingCount;
    }

    public void setImDbRatingCount(String imDbRatingCount) {
        this.imDbRatingCount = imDbRatingCount;
    }
}
