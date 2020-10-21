/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Ponuda;
import domain.Porudzbina;
import validator.Validator;
import validator.impl.ValidatorPonuda;
import validator.impl.ValidatorPorudzbina;

/**
 *
 * @author Luka
 */
public class SOUpdatePorudzbina extends SystemOperation{

    
    public SOUpdatePorudzbina(Porudzbina porudzbina) throws Exception{
        super();
        odo = porudzbina;
    }
    
    @Override
    protected void operation() throws Exception {
        odo=dbbr.update(odo);
        Porudzbina porudzbina = (Porudzbina) odo;
    }
    
}
