package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Commercial extends  Employe{


    private Integer performance;
    private Double caAnnuel;
    public Commercial() {

    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire,Double caAnnuel, Integer performance) {
        this(nom, prenom, matricule, dateEmbauche, salaire,caAnnuel);

        this.performance = performance;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }
    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Boolean performanceEgale(Integer performance){

        return this.performance.equals(performance);
    }

    public Double getPrimeAnnuelle() {

        if (this.caAnnuel != null && this.caAnnuel*0.05 >500 ) {
             return  Math.ceil(this.caAnnuel*0.05);
        }
        return (500d);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commercial)) return false;
        if (!super.equals(o)) return false;

        Commercial that = (Commercial) o;

        return Double.compare(that.caAnnuel, caAnnuel) == 0;
    }

    public Note equivalenceNote() {

        switch (this.performance) {
            case 0:
            case 50:
                return  Note.INSUFFISANT;
            case 100:
                return  Note.PASSABLE;
            case 150:
                return  Note.BIEN;
            case 200:
                return  Note.TRES_BIEN;
            default:
                return  null;
        }
    }
}
