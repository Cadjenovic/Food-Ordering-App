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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;

/**
 *
 * @author Luka
 */
public class CommunicationController {
    private static CommunicationController instance;
    private Socket socket;
    private CommunicationController() throws IOException{
        socket=new Socket("localhost", 9000);
    }
    public static CommunicationController getInstance() throws IOException{
        if(instance==null){
            instance=new CommunicationController();
        }
        return instance;
    }

    public Korisnik login(Korisnik korisnik) throws IOException, ClassNotFoundException, Exception {
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_LOGIN_USER);

        request.setData(korisnik);
        
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return (Korisnik)response.getData();
    }

    public void registerUser(Korisnik korisnik) throws IOException, ClassNotFoundException, Exception {
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_REGISTER_USER);
        
        request.setData(korisnik);
        
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
    } 
    
    public List<Korisnik> getAllRestaurants() throws Exception{
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_GET_ALL_RESTAURANTS);
        
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return (List<Korisnik>)response.getData();
    }
    
    public List<Ponuda> getAllOffers(Korisnik k) throws Exception{
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_GET_ALL_OFFERS);
        request.setData(k);
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return (List<Ponuda>)response.getData();
    }
    
    public List<Porudzbina> getAllOrders() throws Exception{
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_GET_ALL_ORDERS);
        
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return (List<Porudzbina>)response.getData();
    }
    
    public List<Artikl> getAllArticles() throws Exception{
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_GET_ALL_ARTICLES);
        
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return (List<Artikl>)response.getData();
    }
    
    public StavkaPonude deleteOfferItem(StavkaPonude s) throws Exception{
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_DELETE_OFFER_ITEM);
        
        request.setData(s);
        
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return (StavkaPonude)response.getData();
    }
    
    public Ponuda deleteOffer(Ponuda p) throws Exception{
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_DELETE_OFFER);
        
        request.setData(p);
        
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return (Ponuda)response.getData();
    }
    
    public Porudzbina deleteOrder(Porudzbina p) throws Exception{
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_DELETE_ORDER);
        
        request.setData(p);
        
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return (Porudzbina)response.getData();
    }
    
//    public Ponuda saveChangedOffer(Ponuda ponuda) throws Exception{
//        RequestObject request=new RequestObject();
//        request.setOperation(Operation.OPERATION_SAVE_CHANGED_OFFER);
//        
//        request.setData(ponuda);
//        
//        sendRequest(request);
//        ResponseObject response=receiveResponse();
//        
//        if(response.getException()!=null){
//            throw response.getException();
//        }
//        return (Ponuda)response.getData();
//    }
  
    public StavkaPonude saveOfferItem(StavkaPonude stavka) throws Exception{
        
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_SAVE_OFFER_ITEM);
        
        request.setData(stavka);
        
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return (StavkaPonude)response.getData();
    }
    
    public Ponuda saveOffer(Ponuda ponuda) throws Exception{
        
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_SAVE_OFFER);
        
        request.setData(ponuda);
        
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getException()!= null){
            throw response.getException();
        }
        
        return (Ponuda)response.getData();
        
    }
    
    public Porudzbina saveOrder(Porudzbina porudzbina) throws Exception{
        
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_SAVE_ORDER);
        
        request.setData(porudzbina);
        
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return (Porudzbina)response.getData();
        
    }
    
    public Porudzbina updateOrder(Porudzbina p) throws Exception{
        
        RequestObject request=new RequestObject();
        request.setOperation(Operation.OPERATION_UPDATE_ORDER);
        
        request.setData(p);
        
        sendRequest(request);
        ResponseObject response=receiveResponse();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return (Porudzbina)response.getData();
    }
    
    private void sendRequest(RequestObject request) throws IOException{
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(request);
        out.flush();
    }
    
    private ResponseObject receiveResponse() throws Exception{
        ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
        ResponseObject response=(ResponseObject)in.readObject();
        return response;
    }
    
    
}
