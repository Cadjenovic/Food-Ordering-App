/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import controller.Controller;
import domain.Artikl;
import domain.Korisnik;
import domain.Ponuda;
import domain.Porudzbina;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;

/**
 *
 * @author Luka
 */
public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        RequestObject request = null;
        ResponseObject response = null;
        while (!socket.isClosed()) {
            try {
                request = receiveRequest();

                switch (request.getOperation()) {
                    case Operation.OPERATION_LOGIN_USER:
                        response = operationLogin(request);
                        break;
                    case Operation.OPERATION_REGISTER_USER:
                        response = operationRegisterUser(request);
                        break;
                    case Operation.OPERATION_GET_ALL_OFFERS:
                        response = operationGetAllOffers(request);
                        break;
                    case Operation.OPERATION_GET_ALL_ARTICLES:
                        response = operationGetAllArticles(request);
                        break;
                    case Operation.OPERATION_SAVE_OFFER:
                        response = operationSaveOffer(request);
                        break;
                    case Operation.OPERATION_DELETE_OFFER:
                        response = operationDeleteOffer(request);
                        break;
                    case Operation.OPERATION_GET_ALL_ORDERS:
                        response = operationGetAllOrders(request);
                        break;
                    case Operation.OPERATION_GET_ALL_RESTAURANTS:
                        response = operationGetAllRestaurants(request);
                        break;
                    case Operation.OPERATION_SAVE_ORDER:
                        response = operationSaveOrder(request);
                        break;
                    case Operation.OPERATION_DELETE_ORDER:
                        response = operationDeleteOrder(request);
                        break;
                    case Operation.OPERATION_UPDATE_ORDER:
                        response = operationUpdateOrder(request);
                        break;
                }
                sendResponse(response);
            } catch (Exception ex) {
                //ex.printStackTrace();
            }
        }
    }

    public RequestObject receiveRequest() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return (RequestObject) in.readObject();
    }

    public void sendResponse(ResponseObject response) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(response);
        out.flush();
    }

    public ResponseObject operationLogin(RequestObject request) {
        ResponseObject response = null;
        Korisnik k = (Korisnik) request.getData();
        try {
            response = new ResponseObject();
            Korisnik korisnik = Controller.getInstance().login(k);
            response.setData(korisnik);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }
    

    public ResponseObject operationRegisterUser(RequestObject request){
          ResponseObject response = null;
          Korisnik korisnik = (Korisnik) request.getData();

        try{
            response = new ResponseObject();
            Controller.getInstance().register(korisnik);
        }
        catch(Exception ex){
            ex.printStackTrace();
            response.setException(ex);
        }
        
        return response;
    }
    
    public ResponseObject operationGetAllRestaurants(RequestObject request){
          ResponseObject response = null;

        try{
            response = new ResponseObject();
            List<Korisnik> restorani = Controller.getInstance().getAllRestaurants();
            response.setData(restorani);
        }
        catch(Exception ex){
            ex.printStackTrace();
            response.setException(ex);
        }
        
        return response;
    }
    
        private ResponseObject operationGetAllOffers(RequestObject request) {
            ResponseObject response = null;
            Korisnik korisnik = (Korisnik) request.getData();
            try {
                response = new ResponseObject();
                List<Ponuda> offers = Controller.getInstance().getAllOffers(korisnik);
                response.setData(offers);
            } catch (Exception ex) {
                response.setException(ex);
            }
            return response;
        }
    
        private ResponseObject operationGetAllOrders(RequestObject request) {
            ResponseObject response = null;

            try {
                response = new ResponseObject();
                List<Porudzbina> orders = Controller.getInstance().getAllOrders();
                response.setData(orders);
            } catch (Exception ex) {
                ex.printStackTrace();
                response.setException(ex);
            }
            return response;
        }
        
        private ResponseObject operationGetAllArticles(RequestObject request){
            ResponseObject response = null;
            
            try {
                response = new ResponseObject();
                List<Artikl> articles = Controller.getInstance().getAllArticles();
                response.setData(articles);
            } catch (Exception ex) {
                ex.printStackTrace();
                response.setException(ex);
            }
            return response;
        }
        

        
        private ResponseObject operationSaveOffer(RequestObject request) {
            ResponseObject response = null;
            Ponuda ponuda = (Ponuda) request.getData();

           try {
               response = new ResponseObject();
               ponuda = Controller.getInstance().saveOffer(ponuda);
               response.setData(ponuda);
           } catch (Exception ex) {
               ex.printStackTrace();
               response.setException(ex);
           }
           return response;
        }
        
        private ResponseObject operationSaveOrder(RequestObject request) {
            ResponseObject response = null;
            Porudzbina porudzbina = (Porudzbina) request.getData();

           try {
               response = new ResponseObject();
               porudzbina = Controller.getInstance().saveOrder(porudzbina);
               response.setData(porudzbina);
           } catch (Exception ex) {
               ex.printStackTrace();
               response.setException(ex);
           }
           return response;
        }
        
        private ResponseObject operationUpdateOrder(RequestObject request) {
            ResponseObject response = null;
            Porudzbina porudzbina = (Porudzbina) request.getData();

           try {
               response = new ResponseObject();
               porudzbina = Controller.getInstance().updateOrder(porudzbina);
               response.setData(porudzbina);
           } catch (Exception ex) {
               ex.printStackTrace();
               response.setException(ex);
           }
           return response;
        }

    
    private ResponseObject operationDeleteOffer(RequestObject request) {
         ResponseObject response = null;
         Ponuda ponuda = (Ponuda) request.getData();
        
        try {
            response = new ResponseObject();
            ponuda = Controller.getInstance().deleteOffer(ponuda);
            response.setData(ponuda);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }
    
    private ResponseObject operationDeleteOrder(RequestObject request) {
         ResponseObject response = null;
         Porudzbina porudzbina = (Porudzbina) request.getData();
        
        try {
            response = new ResponseObject();
            porudzbina = Controller.getInstance().deleteOrder(porudzbina);
            response.setData(porudzbina);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }
    
    public Socket getSocket() {
        return socket;
    }

    

}
