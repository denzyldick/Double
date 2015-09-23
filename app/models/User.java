package models;


import java.util.Random;

import static play.mvc.WebSocket.*;

/**
 * Created by denzyl on 9/19/15.
 */
public class User {

    private In in;
    private Out out;

    private int couple;
    private Authentication aut;
    public User()
    {

    }

    public boolean login(String email,String password)
    {
        if(email.equals("denzyl@live.nl") || email.equals("ddenzyl@gmail.com"))
        {
            this.couple = 1;
            this.aut.addAuthentication(new Random().nextInt());
        }
        return true;
    }
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
        return this.couple;
    }

    public boolean isCouple(User user)
    {
        return(user.getCouple() == this.getCouple());
    }

    public void sentMessage(Message s)
    {
        this.out.write(s.get());

        /**
         * Log message
         */
    }

}

