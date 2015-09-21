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
            return false;
        }else
        {
            return true;
        }

    }
    public void addAuthentication(String id)
    {
     session.put("user",id);
    }
    public void remove(){
        session.remove("user");
    }
}
