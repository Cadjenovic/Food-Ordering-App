/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Korisnik;

/**
 *
 * @author Luka
 */
public class SOSelectKorisnik extends SystemOperation{

    public SOSelectKorisnik(Korisnik k) {
        super();
        odo = k;
    }

    @Override
    protected void operation() throws Exception {
        odo = dbbr.getOne(odo);
    }
    
    
    
    
}
