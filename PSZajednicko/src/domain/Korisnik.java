/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luka
 */
public class Korisnik implements Serializable, DomainObject{
    
    private int id;
    private String nazivKorisnika;
    private TipKorisnika tipKorisnikaID;
    private String passwordKorisnika;

    public Korisnik() {
    }

    public Korisnik(int id, String nazivKorisnika, TipKorisnika tipKorisnikaID, String passwordKorisnika) {
        this.id = id;
        this.nazivKorisnika = nazivKorisnika;
        this.tipKorisnikaID = tipKorisnikaID;
        this.passwordKorisnika = passwordKorisnika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivKorisnika() {
        return nazivKorisnika;
    }

    public void setNazivKorisnika(String nazivKorisnika) {
        this.nazivKorisnika = nazivKorisnika;
    }

    public TipKorisnika getTipKorisnikaID() {
        return tipKorisnikaID;
    }

    public void setTipKorisnikaID(TipKorisnika tipKorisnikaID) {
        this.tipKorisnikaID = tipKorisnikaID;
    }

    public String getPasswordKorisnika() {
        return passwordKorisnika;
    }

    public void setPasswordKorisnika(String passwordKorisnika) {
        this.passwordKorisnika = passwordKorisnika;
    }

    @Override
    public String getTableName() {
        return "Korisnik";
    }

    @Override
    public String getAttributeNamesForInsert() {
        return "korisnikid, nazivkorisnika, passwordkorisnika, tipkorisnikaid";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return id + ", '" + nazivKorisnika+"', '" + passwordKorisnika + "', " + tipKorisnikaID.getId();
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(int id) {
        setId(id);
    }

    @Override
    public String toString() {
        return getNazivKorisnika();
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) {
        List<DomainObject> restorani = new ArrayList<DomainObject>();
        try{
            while(rs.next()){
                Korisnik r = new Korisnik();
                r.setId(rs.getInt("korisnikid"));
                r.setNazivKorisnika(rs.getString("nazivkorisnika"));
                r.setPasswordKorisnika(rs.getString("passwordkorisnika"));
                TipKorisnika tip = new TipKorisnika();
                tip.setTipKorisnikaID(2);
                tip.setTipKorisnikaNaziv("Restaurant");
                r.setTipKorisnikaID(tip);
                restorani.add(r);
            }
        }catch(Exception e){
            
        }
        return restorani;
    }

    @Override
    public String getWhereConditionOne() {
        return "nazivkorisnika = '" + getNazivKorisnika() + "' AND passwordkorisnika = '" + getPasswordKorisnika() + "'";
    }

    @Override
    public DomainObject getOne(ResultSet rs) {
        Korisnik k = null;
        try{
            if(rs.next()){
                k = new Korisnik();
                k.setId(rs.getInt("Korisnikid"));
                k.setNazivKorisnika(rs.getString("nazivkorisnika"));
                k.setPasswordKorisnika(rs.getString("passwordkorisnika"));
                int t = rs.getInt("tipkorisnikaid");
                TipKorisnika tip = new TipKorisnika();
                tip.setTipKorisnikaID(t);
                if(t == 1){
                    tip.setTipKorisnikaNaziv("Customer");
                }
                else{
                    tip.setTipKorisnikaNaziv("Restaurant");
                }
                k.setTipKorisnikaID(tip);
            }
        }catch(Exception e){
            
        }
        return k;
    }

    @Override
    public String getWhereConditionAll() {
        return "tipkorisnikaid = 2";
    }

    @Override
    public String getJoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
