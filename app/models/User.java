package models;

import com.ning.http.client.websocket.WebSocket;

import static play.mvc.WebSocket.*;

/**
 * Created by denzyl on 9/19/15.
 */
public class User {
    private In in;
    private Out out;
    public User(In in,Out out)
    {
        this.in = in;
        this.out = out;
    }

    public In getIn()
    {
        return this.in;
    }
    public Out getOut()
    {
        return this.out;
    }
    public int getCouple()
    {
        return 1;
    }
}

