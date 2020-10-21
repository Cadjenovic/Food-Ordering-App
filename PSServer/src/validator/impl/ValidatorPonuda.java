/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.impl;

import domain.Ponuda;
import validator.Validator;

/**
 *
 * @author Luka
 */
public class ValidatorPonuda implements Validator{
    
    @Override
    public void validate(Object value) throws Exception {
            Ponuda ponuda = (Ponuda) value;
            if(ponuda.getPonudaNaziv().length() <= 2){
                throw new Exception("Naziv ponude mora biti 3 ili vise karaktera!");
            }
            if(ponuda.getStavkePonude().size() == 0){
                throw new Exception("Ponuda mora imati makar jednu stavku!");
            }
    }
    
}
