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
public class Ponuda implements Serializable, DomainObject{
    
    private int ponudaID;
    private String ponudaNaziv;
    private Korisnik korisnikID;
    private double ponudaCena;
    private List<StavkaPonude> stavkePonude;
    public Ponuda() {
        stavkePonude = new ArrayList<>();
    }

    public Ponuda(int ponudaID, String ponudaNaziv, Korisnik korisnikID, double ponudaCena, List<StavkaPonude> stavkePonude) {
        this.ponudaID = ponudaID;
        this.ponudaNaziv = ponudaNaziv;
        this.korisnikID = korisnikID;
        this.ponudaCena = ponudaCena;
        this.stavkePonude = stavkePonude;
    }

    public int getPonudaID() {
        return ponudaID;
    }

    public void setPonudaID(int ponudaID) {
        this.ponudaID = ponudaID;
    }

    public String getPonudaNaziv() {
        return ponudaNaziv;
    }

    public void setPonudaNaziv(String ponudaNaziv) {
        this.ponudaNaziv = ponudaNaziv;
    }

    public Korisnik getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Korisnik korisnikID) {
        this.korisnikID = korisnikID;
    }

    public List<StavkaPonude> getStavkePonude() {
        return stavkePonude;
    }

    public void setStavkePonude(List<StavkaPonude> stavkePonude) {
        this.stavkePonude = stavkePonude;
    }
    
    public void setPonudaCena(double cena){
        this.ponudaCena = cena;
    }
    
    public double getPonudaCena(){
        return ponudaCena;
    }

    @Override
    public String getTableName() {
        return "ponuda";
    }

    @Override
    public String getAttributeNamesForInsert() {
        return "ponudaid, ponudanaziv, korisnikid, ponudacena";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return ponudaID+", '" + ponudaNaziv + "', " + korisnikID.getId() + ", " + ponudaCena;
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(int id) {
        setPonudaID(id);
    }

    @Override
    public String toString() {
        return getPonudaNaziv() + " " + getKorisnikID().getId();
    }

    @Override
    public int getId(){
        return getPonudaID();
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) {
        List<DomainObject> ponude = new ArrayList<DomainObject>();
        try{
            while(rs.next()){
                int f = rs.getInt("p.ponudaid");
                List<StavkaPonude> stavke = new ArrayList<>();
                Ponuda p = new Ponuda();
                p.setPonudaID(rs.getInt("p.ponudaid"));
                p.setPonudaNaziv(rs.getString("p.ponudanaziv"));
                p.setPonudaCena(rs.getDouble("p.ponudacena"));
                Korisnik k = new Korisnik();
                k.setId(rs.getInt("k.korisnikid"));
                k.setNazivKorisnika(rs.getString("k.nazivkorisnika"));
                TipKorisnika t = new TipKorisnika();
                t.setTipKorisnikaID(rs.getInt("k.tipkorisnikaid"));
                k.setTipKorisnikaID(t);
                p.setKorisnikID(k);
                while((rs.getInt("p.ponudaid") == f)){
                    StavkaPonude sp = new StavkaPonude();
                    sp.setStavkaPonudeID(rs.getInt("sp.stavkaponudeid"));
                    sp.setStavkaPonudeNaziv(rs.getString("sp.stavkaponudenaziv"));
                    sp.setCena(rs.getDouble("sp.cena"));
                    stavke.add(sp);
                    if(!rs.next()){
                        break;
                    }
                }
                p.setStavkePonude(stavke);
                ponude.add(p);
                rs.relative(-1);
            }
        }catch(Exception e){
            
        }
        return ponude;
    }

    @Override
    public String getWhereConditionOne() {
        return " p.korisnikid = ";
    }

    @Override
    public DomainObject getOne(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereConditionAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoin() {
        return " p JOIN korisnik k ON (p.korisnikid = k.korisnikid) JOIN stavkaponude sp ON (p.ponudaid = sp.ponudaid)";
    }

    @Override
    public String getUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
