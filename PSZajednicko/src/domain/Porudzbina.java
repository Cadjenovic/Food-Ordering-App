/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luka
 */
public class Porudzbina implements Serializable, DomainObject{
    
    private int porudzbinaID;
    private String porudzbinaNaziv;
    private Korisnik korisnikC;
    private Korisnik korisnikR;
    private double porudzbinaCena;
    private Date datumPorudzbine;
    private boolean status;
    private List<StavkaPorudzbine> stavkePorudzbine;

    public Porudzbina() {
        stavkePorudzbine = new ArrayList<>();
    }

    public Porudzbina(int porudzbinaID, String porudzbinaNaziv, Korisnik korisnikC, Korisnik korisnikR, double porudzbinaCena, Date datumPorudzbine, boolean status, List<StavkaPorudzbine> stavkePorudzbine) {
        this.porudzbinaID = porudzbinaID;
        this.porudzbinaNaziv = porudzbinaNaziv;
        this.korisnikC = korisnikC;
        this.korisnikR = korisnikR;
        this.porudzbinaCena = porudzbinaCena;
        this.datumPorudzbine = datumPorudzbine;
        this.status = status;
        this.stavkePorudzbine = stavkePorudzbine;
    }

    public int getPorudzbinaID() {
        return porudzbinaID;
    }

    public void setPorudzbinaID(int porudzbinaID) {
        this.porudzbinaID = porudzbinaID;
    }

    public String getPorudzbinaNaziv() {
        return porudzbinaNaziv;
    }

    public void setPorudzbinaNaziv(String porudzbinaNaziv) {
        this.porudzbinaNaziv = porudzbinaNaziv;
    }

    public Korisnik getKorisnikC() {
        return korisnikC;
    }

    public void setKorisnikC(Korisnik korisnikC) {
        this.korisnikC = korisnikC;
    }

    public Korisnik getKorisnikR() {
        return korisnikR;
    }

    public void setKorisnikR(Korisnik korisnikR) {
        this.korisnikR = korisnikR;
    }

    public double getPorudzbinaCena() {
        return porudzbinaCena;
    }

    public void setPorudzbinaCena(double porudzbinaCena) {
        this.porudzbinaCena = porudzbinaCena;
    }

    public Date getDatumPorudzbine() {
        return datumPorudzbine;
    }

    public void setDatumPorudzbine(Date datumPorudzbine) {
        this.datumPorudzbine = datumPorudzbine;
    }

    public List<StavkaPorudzbine> getStavkePorudzbine() {
        return stavkePorudzbine;
    }

    public void setStavkePorudzbine(List<StavkaPorudzbine> stavkePorudzbine) {
        this.stavkePorudzbine = stavkePorudzbine;
    }

    public boolean getStatus(){
        return status;
    }
    
    public void setStatus(boolean status){
        this.status = status;
    }

    @Override
    public String getTableName() {
        return "porudzbina";
    }

    @Override
    public String getAttributeNamesForInsert() {
        return "porudzbinaid, cenaporudzbine, korisnikCID, korisnikRID, nazivporudzbine, datumporudzbine, status";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return getPorudzbinaID() + ", " + getPorudzbinaCena() + ", " + getKorisnikC().getId() + ", " + getKorisnikR().getId() + ", '" + getPorudzbinaNaziv() + "', '" + new java.sql.Date(datumPorudzbine.getTime()) + "', " + getStatus();
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(int id) {
        setPorudzbinaID(id);
    }

    @Override
    public int getId(){
        return getPorudzbinaID();
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) {
        List<DomainObject> porudzbine = new ArrayList<DomainObject>();
        try{
            while(rs.next()){
                int f = rs.getInt("p.porudzbinaid");
                List<StavkaPorudzbine> stavke = new ArrayList<>();
                Porudzbina p = new Porudzbina();
                p.setPorudzbinaID(rs.getInt("p.porudzbinaid"));
                p.setPorudzbinaNaziv(rs.getString("p.nazivporudzbine"));
                p.setPorudzbinaCena(rs.getDouble("cenaporudzbine"));
                Korisnik kc = new Korisnik();
                kc.setId(rs.getInt("kc.korisnikid"));
                kc.setNazivKorisnika(rs.getString("kc.nazivkorisnika"));
                kc.setPasswordKorisnika(rs.getString("kc.passwordkorisnika"));
                TipKorisnika tkc = new TipKorisnika();
                tkc.setTipKorisnikaID(rs.getInt("kc.tipkorisnikaid"));
                kc.setTipKorisnikaID(tkc);
                p.setKorisnikC(kc);
                Korisnik kr = new Korisnik();
                kr.setId(rs.getInt("kr.korisnikid"));
                kr.setNazivKorisnika(rs.getString("kr.nazivkorisnika"));
                kr.setPasswordKorisnika(rs.getString("kr.passwordkorisnika"));
                TipKorisnika tkr = new TipKorisnika();
                tkr.setTipKorisnikaID(rs.getInt("kr.tipkorisnikaid"));
                kr.setTipKorisnikaID(tkc);
                p.setKorisnikR(kr);
                p.setDatumPorudzbine(new Date(rs.getDate("p.datumporudzbine").getTime()));
                while((rs.getInt("p.porudzbinaid") == f)){
                    StavkaPorudzbine sp = new StavkaPorudzbine();
                    sp.setStavkaPorudzbineID(rs.getInt("sp.stavkaporudzbineid"));
                    sp.setStavkaPorudzbineNaziv(rs.getString("sp.stavkaporudzbinenaziv"));
                    sp.setCena(rs.getDouble("sp.cena"));
                    stavke.add(sp);
                    if(!rs.next()){
                        break;
                    }
                }
                p.setStavkePorudzbine(stavke);
                porudzbine.add(p);
                rs.relative(-1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return porudzbine;
    }

    @Override
    public String getWhereConditionOne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return " p INNER JOIN Korisnik kc ON (p.korisnikcID = kc.korisnikid) INNER JOIN Korisnik kr ON (p.korisnikrid = kr.korisnikid) INNER JOIN StavkaPorudzbine sp ON (p.porudzbinaid = sp.porudzbinaid)";
    }

    @Override
    public String getUpdate() {
        return "status = true WHERE porudzbinaid = " + getId();
    }
    
    
    
}
