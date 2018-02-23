package es.formacion.cip.diego.model;

import javax.persistence.*;

@Entity
public class Series {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private int id;

    private String name;
    private String date;
    private double rate;
    private int temporade;

    public Series() {
    }

    public Series(String name, String date, double rate, int temporade) {
        this.name = name;
        this.date = date;
        this.rate = rate;
        this.temporade = temporade;
    }


    public int getTemporade() {
        return temporade;
    }

    public void setTemporade(int temporade) {
        this.temporade = temporade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
