package controllers;

import models.Authentication;
import models.User;
import play.mvc.Controller;
import play.mvc.WebSocket;

import java.util.ArrayList;
import java.util.List;

/**
 * Web sockets
 * @todo Implement socket.io for easier bi-directional communication insteaad of using plain websocket
 * @author denzyl
 */
public class Socket extends Controller {
    static List<User> connectedUsers = new ArrayList<>();
    static Authentication aut = new Authentication();

    public static WebSocket<String> index() {
       return new WebSocket<String>() {

            public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {
                if(aut.isAuthentic()) {
                    connectedUsers.add(new User(in, out));
                    System.out.println("New Connection" + connectedUsers.size());
                    in.onMessage(s -> {

                        for (User user : connectedUsers) {
                            user.getOut().write(s);
                        }

                    });
                }else{
                   out.close();
                }

            }



        };

    }
}
