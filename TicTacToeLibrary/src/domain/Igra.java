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
public class Igra extends GeneralDObject{
    
    private int idIgre;
    private int idKorisnika;
    private boolean pobeda;
    private int brojPoteza;
    private Date datumOdigravanja;

    public Igra() {
        idIgre = 0;
        idKorisnika = 0;
        pobeda = false;
        brojPoteza = 0;
        datumOdigravanja = new Date();
    }

    public Igra(int idIgre, int idKorisnika, boolean pobeda, int brojPoteza, Date datumOdigravanja) {
        this.idIgre = idIgre;
        this.idKorisnika = idKorisnika;
        this.pobeda = pobeda;
        this.brojPoteza = brojPoteza;
        this.datumOdigravanja = datumOdigravanja;
    }
    
    public int getIdIgre() {
        return idIgre;
    }

    public void setIdIgre(int idIgre) {
        this.idIgre = idIgre;
    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public boolean isPobeda() {
        return pobeda;
    }

    public void setPobeda(boolean pobeda) {
        this.pobeda = pobeda;
    }

    public int getBrojPoteza() {
        return brojPoteza;
    }

    public void setBrojPoteza(int brojPoteza) {
        this.brojPoteza = brojPoteza;
    }

    public Date getDatumOdigravanja() {
        return datumOdigravanja;
    }

    public void setDatumOdigravanja(Date datumOdigravanja) {
        this.datumOdigravanja = datumOdigravanja;
    }
    
    public java.util.Date getDatumOdigravanjaSQLDate(java.util.Date datumOdigravanja) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        this.datumOdigravanja = java.sql.Date.valueOf(sm.format(datumOdigravanja));
        return this.datumOdigravanja;
    }
    
    @Override
    public String getAtrValue() {
        return (idIgre + ", " + idKorisnika + ", " + pobeda + ", " + brojPoteza + ", '" + getDatumOdigravanjaSQLDate(datumOdigravanja) + "'");
    }

    @Override
    public String setAtrValue() {
        return "idIgre=" + idIgre + ", " + "idKorisnika=" + idKorisnika + ", " + "pobeda=" + pobeda 
                + ", brojPoteza=" + brojPoteza + ", " + "datumOdigravanja='" + getDatumOdigravanjaSQLDate(datumOdigravanja) + "'";
    }

    @Override
    public String getClassName() {
        return getClass().getSimpleName();
    }

    @Override
    public String getWhereCondition() {
        return "idIgre=" + idIgre + " and idKorisnika=" + idKorisnika;
    }
    
    public String getOrderBy(){
        return "INNER JOIN Korisnik ON Igra.idKorisnika = Korisnik.idKorisnika WHERE Igra.pobeda=1 ORDER BY brojPoteza DESC";
    }

    @Override
    public String getNameByColumn(int column) {
        Field[] fields = getClass().getDeclaredFields();
        return fields[column].getName();
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new Igra(rs.getInt("idIgre"), rs.getInt("idKorisnika"), rs.getBoolean("pobeda"), rs.getInt("brojPoteza"), rs.getDate("datumOdigravanja"));
    }

    @Override
    public int getPrimaryKey() {
        return this.idIgre;
    }

    @Override
    public void setID(int id) {
        this.idIgre = id;
    }

    @Override
    public String poruka1() {
        return "Problem oko brojaca igre.";
    }

    @Override
    public String poruka2() {
        return "Ne moze da se poveca brojac igre.";
    }

    @Override
    public String poruka3() {
        return "Igra je kreirana.";
    }

    @Override
    public String poruka4() {
        return "Nije mogla da bude kreirana igra.";
    }

    @Override
    public String poruka5() {
        return "Igra je obrisana.";
    }

    @Override
    public String poruka6() {
        return "Nije mogla da se obrise igra.";
    }

    @Override
    public String poruka7() {
        return "Ne moze se obrisati igra jer ne postoji.";
    }

    @Override
    public String poruka8() {
        return "Igra je promenjena.";
    }

    @Override
    public String poruka9() {
        return "Nije mogla da se promeni igra.";
    }

    @Override
    public String porukaX0() {
        return "Ne moze se promeniti igra jer ne postoji.";
    }
    
}
