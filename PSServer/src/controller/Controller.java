/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Artikl;
import domain.Korisnik;
import domain.Ponuda;
import domain.Porudzbina;
import domain.StavkaPonude;
import java.util.List;
import logic.SODeletePonuda;
import logic.SODeletePorudzbina;
import logic.SOInsertPonuda;
import logic.SOInsertPorudzbina;
import logic.SORegister;
import logic.SOSelectArtikle;
import logic.SOSelectKorisnik;
import logic.SOSelectOffers;
import logic.SOSelectPorudzbine;
import logic.SOSelectRestorane;
import logic.SOUpdatePorudzbina;
import logic.SystemOperation;




/**
 *
 * @author Luka
 */
public class Controller {
    
    private static Controller instance;

    private Controller() {

    }
    
    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }
    
    public Korisnik login(Korisnik korisnik) throws Exception{
        SOSelectKorisnik so = new SOSelectKorisnik(korisnik);
        so.execute();
        return (Korisnik) so.getDomainObject();
    }
    
    public void register(Korisnik korisnik) throws Exception{
        SystemOperation so = new SORegister(korisnik);
        so.execute();
    }
    
    public List<Korisnik> getAllRestaurants() throws Exception{
        SOSelectRestorane so = new SOSelectRestorane(new Korisnik());
        so.execute();
        return (List<Korisnik>)(List<?>) so.getRestorani();
    }
    
    public List<Ponuda> getAllOffers(Korisnik k) throws Exception{
        SOSelectOffers so = new SOSelectOffers(new Ponuda(), k);
        so.execute();
        return (List<Ponuda>)(List<?>) so.getPonude();
    }
    
    public List<Porudzbina> getAllOrders() throws Exception{
        SOSelectPorudzbine so = new SOSelectPorudzbine(new Porudzbina());
        so.execute();
        return (List<Porudzbina>)(List<?>) so.getPorudzbine();
    }

    public List<Artikl> getAllArticles() throws Exception{
        SOSelectArtikle so = new SOSelectArtikle(new Artikl());
        so.execute();
        return (List<Artikl>)(List<?>) so.getArtikle();

    }

    public Ponuda saveOffer(Ponuda p) throws Exception{
        SOInsertPonuda so = new SOInsertPonuda(p);
        so.execute();
        return (Ponuda) so.getDomainObject();
    }
    
    public Porudzbina saveOrder(Porudzbina p) throws Exception{
        SOInsertPorudzbina so = new SOInsertPorudzbina(p);
        so.execute();
        return (Porudzbina) so.getDomainObject();
    }
    
    public Porudzbina updateOrder(Porudzbina p) throws Exception{
        SOUpdatePorudzbina so = new SOUpdatePorudzbina(p);
        so.execute();
        return (Porudzbina) so.getDomainObject();
    }
    
    
    public Ponuda deleteOffer(Ponuda p) throws Exception{
        SODeletePonuda so = new SODeletePonuda(p);
        so.execute();
        return (Ponuda) so.getDomainObject();
    }
    
    public Porudzbina deleteOrder(Porudzbina p) throws Exception{
        SODeletePorudzbina so = new SODeletePorudzbina(p);
        so.execute();
        return (Porudzbina) so.getDomainObject();
    }
    
}
