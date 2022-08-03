package facci.solangemarcillo.examensegundoparcial;

public class Episodes {
    //tendremos 3 variales de tipo privada
    private String episode, title, season, series,air_date;

    //creamos un constructor para que sea users publico
    //Se pasa como parámetro lo que queremos que se muestre
    public Episodes(String episode, String title, String season, String series,String air_date){
        this.episode = episode;
        this.title = title ;
        this.season = season;
        this.series=series;
        this.air_date=air_date;
    }

    //Se generan Getter
    public String getEpisode() {
        return episode;
    }

    public String getTitle() {
        return title;
    }

    public String getSeason() {
        return season;
    }

    public String getSeries() {
        return series;
    }

    public String getAir_date() {
        return air_date;
    }
}

