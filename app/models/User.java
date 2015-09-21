package models;


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

