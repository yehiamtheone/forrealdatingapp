package forrealdatingapp.routes;

import com.fasterxml.jackson.databind.ObjectMapper;

import forrealdatingapp.App;
import forrealdatingapp.TokenManager;
public class RouterUtils {
    private static String  HOST;
    private static ObjectMapper om = new ObjectMapper();
    private static TokenManager tm = new TokenManager();

    public static String getHost(){
        HOST = App.getEnv("EXPRESS_HOST");
        return HOST;
    }
    public static TokenManager manageToken(){
        return tm;
    }
    public static  ObjectMapper manageJSON(){
        return om;
    }




    
    
    
}
