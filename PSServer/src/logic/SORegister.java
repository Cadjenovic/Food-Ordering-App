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
public class SORegister extends SystemOperation{

    public SORegister(Korisnik korisnik) {
        super();
        odo = korisnik;
    }
 
    @Override
    protected void operation() throws Exception {
        dbbr.insert(odo);
    }
   
}
