/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Luka
 */
public class Operation implements Serializable{
    
    public static final int OPERATION_LOGIN_USER = 1;
    public static final int OPERATION_REGISTER_USER = 2;
    public static final int OPERATION_GET_ALL_OFFERS = 3;
    public static final int OPERATION_GET_ALL_ARTICLES = 4;
    public static final int OPERATION_SAVE_OFFER_ITEM = 5;
    public static final int OPERATION_DELETE_OFFER_ITEM = 6;
    public static final int OPERATION_SAVE_OFFER = 7;
    public static final int OPERATION_DELETE_OFFER = 8;
    public static final int OPERATION_GET_ALL_ORDERS = 9;
    public static final int OPERATION_GET_ALL_RESTAURANTS = 10;
    public static final int OPERATION_SAVE_ORDER = 11;
    public static final int OPERATION_DELETE_ORDER = 12;
    public static final int OPERATION_UPDATE_ORDER = 13;
    
    
}
