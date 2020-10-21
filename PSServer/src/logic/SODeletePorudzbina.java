/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Porudzbina;
import validator.Validator;
import validator.impl.ValidatorPorudzbina;

/**
 *
 * @author Luka
 */
public class SODeletePorudzbina extends SystemOperation{
    

    
    public SODeletePorudzbina(Porudzbina p) {
        super();
        odo = p;

    }
    @Override
    protected void operation() throws Exception {
        
        Porudzbina p = (Porudzbina) odo;
        odo = dbbr.delete(odo);
    }
    
}
