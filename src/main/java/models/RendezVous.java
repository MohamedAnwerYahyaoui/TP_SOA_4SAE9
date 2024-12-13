package models;

import java.util.Objects;

public class RendezVous {
    int id;
    private String date;
    private String heure;
    private Logement logement;
    private String numTel;

    public RendezVous() {
    }

    public RendezVous(int id, String date, String heure, Logement logement, String numTel) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.logement = logement;
        this.numTel = numTel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RendezVous)) return false;
        RendezVous that = (RendezVous) o;
        return id == that.id && Objects.equals(date, that.date) && Objects.equals(heure, that.heure) && Objects.equals(logement, that.logement) && Objects.equals(numTel, that.numTel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, heure, logement, numTel);
    }
}
