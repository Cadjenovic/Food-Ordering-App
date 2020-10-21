/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.impl;

import domain.Porudzbina;
import validator.Validator;

/**
 *
 * @author Luka
 */
public class ValidatorPorudzbina implements Validator{

    @Override
    public void validate(Object value) throws Exception {
        Porudzbina porudzbina = (Porudzbina) value;
            if(porudzbina.getStatus() == true){
                throw new Exception("Porudzbina je vec odobrena!");
            }
    }
    
}
