package com.example.t_10a.estacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by T-10A on 10/02/2016.
 */
public class ServicioEstacion {


    public String leerEstacion()throws Exception{
        String mensaje="nada todavia";
      URL url=new URL("http://www.weatherlink.com/user/sierraguadalupe");
        URLConnection con= url.openConnection();
        InputStreamReader in=new InputStreamReader(con.getInputStream());
        BufferedReader reader=new BufferedReader(in);
        int numeroLineas=0;
        while(reader.readLine()!=null){
            numeroLineas++;
            if(numeroLineas==155)mensaje=reader.readLine().toString();
        }

        return mensaje;
    }
}
