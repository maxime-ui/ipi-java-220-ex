package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe implements Comparable<Technicien>   {

    private Integer grade;
    public static final Double PRIME_MANAGER_PAR_TECHNICIEN = 250d;
    public Integer getGrade() {return grade;}
    public void setGrade(Integer grade) {this.grade = grade;}

    public Technicien() { }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;}


    @Override
    public void setSalaire(Double salaire) {super.setSalaire( salaire * (1 + (double) grade / 10));}

    public Integer getNbConges() {return super.getNbConges() + this.getNombreAnneeAnciennete();}

    @Override
    public Double getPrimeAnnuelle() {

        Double primeAnnuelleBase = Entreprise.primeAnnuelleBase();
        return primeAnnuelleBase + primeAnnuelleBase * ((double)grade / 10 )+ Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
    }
    @Override
    public int compareTo(Technicien o) {
        return Integer.compare(this.grade, o.getGrade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }
}
