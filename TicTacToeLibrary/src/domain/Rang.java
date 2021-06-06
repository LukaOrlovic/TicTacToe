/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author orlov
 */
public class Rang extends GeneralDObject{
    
    private int brojPoteza;
    private String korisnickoIme;

    
    @Override
    public String toString() {
        return "Korisnik: " + korisnickoIme + "\t" + " Rezultat: " + brojPoteza;
    }
    
    public Rang() {
        brojPoteza = 0;
        korisnickoIme = "";
    }

    public Rang(int brojPoteza, String korisnickoIme) {
        this.brojPoteza = brojPoteza;
        this.korisnickoIme = korisnickoIme;
    }

    public int getBrojPoteza() {
        return brojPoteza;
    }

    public void setBrojPoteza(int brojPoteza) {
        this.brojPoteza = brojPoteza;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String getAtrValue() {
        return (brojPoteza + ", " + korisnickoIme);
    }

    @Override
    public String setAtrValue() {
        return "brojPoteza=" + brojPoteza + ", korisnickoIme='" + korisnickoIme + "'";
    }

    @Override
    public String getClassName() {
        return "Igra";
    }

    @Override
    public String getWhereCondition() {
        return "INNER JOIN Korisnik ON Igra.idKorisnika = Korisnik.idKorisnika WHERE Igra.pobeda=1 ORDER BY brojPoteza DESC";
    }

    @Override
    public String getNameByColumn(int column) {
        Field[] fields = getClass().getDeclaredFields();
        return fields[column].getName();
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new Rang(rs.getInt("brojPoteza"), rs.getString("korisnickoIme"));
    }

    @Override
    public int getPrimaryKey() {
        return 0;
    }

    @Override
    public void setID(int id) {
        return;
    }

    @Override
    public String poruka1() {
        return "Problem oko brojaca ranga.";
    }

    @Override
    public String poruka2() {
        return "Ne moze da se poveca brojac ranga.";
    }

    @Override
    public String poruka3() {
        return "Rang je kreiran.";
    }

    @Override
    public String poruka4() {
        return "Nije mogao da bude kreiran rang.";
    }

    @Override
    public String poruka5() {
        return "Rang je obrisan.";
    }

    @Override
    public String poruka6() {
        return "Nije mogao da se obrise rang.";
    }

    @Override
    public String poruka7() {
        return "Ne moze se obrisati rang jer ne postoji.";
    }

    @Override
    public String poruka8() {
        return "Rang je promenjen.";
    }

    @Override
    public String poruka9() {
        return "Nije mogao da se promeni rang.";
    }

    @Override
    public String porukaX0() {
        return "Ne moze se promeniti rang jer ne postoji.";
    }
    
}
