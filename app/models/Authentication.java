package models;

import play.mvc.Http;

import java.util.HashMap;

/**
 * Created by denzyl on 9/19/15.
 */
public class Authentication {
    static Http.Session session = new Http.Session(new HashMap<String, String>() {{

    }});
    public boolean isAuthentic()
    {
        if(session.get("user") == null)
        {
            return true;
        }else
        {
            return true;
        }

    }
    public void addAuthentication(int id)
    {
     session.put("user",String.valueOf(id));

    }
    public void remove(){

        session.remove("user");
    }
}
