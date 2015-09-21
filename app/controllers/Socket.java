package controllers;

import models.Authentication;
import models.Message;
import models.User;
import play.mvc.Controller;
import play.mvc.WebSocket;

import java.util.ArrayList;
import java.util.List;

/**
 * Web sockets
 * @todo Implement socket.io for easier bi-directional communication instead of using plain websocket
 * @author denzyl
 */
public class Socket extends Controller {
    static List<User> connectedUsers = new ArrayList<>();
    static Authentication aut = new Authentication();

    public static WebSocket<String> index() {
       return new WebSocket<String>() {

            public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {
                if(aut.isAuthentic()) {
                    User connected = new User(in,out);
                    connectedUsers.add(connected);
                    out.write("Hello there !");
                    in.onMessage(s -> {
                        connectedUsers.stream().filter((user) -> connected.isCouple(user)).forEach(i -> {

                                i.sentMessage(new Message(s));

                        });

                    });


                }else{
                   out.close();
                }

            }




        };

    }
}
