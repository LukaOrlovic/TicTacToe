/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author orlov
 */
public class Korisnik extends GeneralDObject {

    private int idKorisnika;
    private String korisnickoIme;
    private String sifra;
    private Date datumPrijavljivanja;
    private String email;

    public Korisnik(){
        this.idKorisnika = 0;
        this.korisnickoIme = "";
        this.sifra = "";
        this.datumPrijavljivanja = new Date();
        this.email = "";
    }

    public Korisnik(int idKorisnika, String korisnickoIme, String sifra, Date datumPrijavljivanja, String email) {
        this.idKorisnika = idKorisnika;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.datumPrijavljivanja = datumPrijavljivanja;
        this.email = email;
    }
    
    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public Date getDatumPrijavljivanja() {
        return datumPrijavljivanja;
    }

    public void setDatumPrijavljivanja(Date datumPrijavljivanja) {
        this.datumPrijavljivanja = datumPrijavljivanja;
    }

    public java.util.Date getDatumRodjenjaSQLDate(java.util.Date datumRodjenja) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        this.datumPrijavljivanja = java.sql.Date.valueOf(sm.format(datumRodjenja));
        return this.datumPrijavljivanja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    @Override
    public String getAtrValue() {
        return (idKorisnika + ", '" + korisnickoIme + "', '" + sifra + "', '" + getDatumRodjenjaSQLDate(datumPrijavljivanja) + "', '" + email + "'");
    }

    @Override
    public String setAtrValue() {
        return "idKorisnika=" + idKorisnika + ", " + "korisnickoIme='" + korisnickoIme + "', " + "sifra='" + sifra 
                + "', datumRodjenja='" + getDatumRodjenjaSQLDate(datumPrijavljivanja) + "', " + "email='" + email + "'";

    }

    @Override
    public String getClassName() {
        return getClass().getSimpleName();
    }

    @Override
    public String getWhereCondition() {
        return "korisnickoIme='" + korisnickoIme + "' and sifra=" + sifra;
    }

    @Override
    public String getNameByColumn(int column) {
        Field[] fields = getClass().getDeclaredFields();
        return fields[column].getName();
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new Korisnik(rs.getInt("idKorisnika"), rs.getString("korisnickoIme"), rs.getString("sifra"), rs.getDate("datumPrijavljivanja"), rs.getString("email"));
    }

    @Override
    public int getPrimaryKey() {
        return this.idKorisnika;
    }

    @Override
    public void setID(int id) {
        this.idKorisnika = id;
    }

    @Override
    public String poruka1() {
        return "Problem oko brojaca korisnika.";
    }

    @Override
    public String poruka2() {
        return "Ne moze da se poveca brojac korisnika.";
    }

    @Override
    public String poruka3() {
        return "Korisnik je kreiran.";
    }

    @Override
    public String poruka4() {
        return "Nije mogao da bude kreiran korisnik.";
    }

    @Override
    public String poruka5() {
        return "Korisnik je obrisan.";
    }

    @Override
    public String poruka6() {
        return "Nije mogao da se obrise korisnik.";
    }

    @Override
    public String poruka7() {
        return "Ne moze se obrisati korisnik jer ne postoji.";
    }

    @Override
    public String poruka8() {
        return "Korisnik je promenjen.";
    }

    @Override
    public String poruka9() {
        return "Nije mogao da se promeni korisnik.";
    }

    @Override
    public String porukaX0() {
        return "Ne moze se promeniti korisnik jer ne postoji.";
    }

}
