/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.DomainObject;
import domain.Korisnik;
import domain.Ponuda;
import java.util.List;

/**
 *
 * @author Luka
 */
public class SOSelectOffers extends SystemOperation{
    
    private List<DomainObject> ponude;
    private Korisnik k;
    
    public SOSelectOffers(Ponuda p, Korisnik k){
        odo = p;
        this.k = k;
    }

    @Override
    protected void operation() throws Exception {
        ponude = dbbr.getAllWithJoinCondition(odo, k);
    }
    
    public List<DomainObject> getPonude(){
        return ponude;
    }
}
