package com.example.t_10a.estacion;

import android.util.Log;

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
      URL url=new URL("http://www.weatherlink.com/user/sierraguadalupe/index.php?view=summary&headers=0");
        URLConnection con= url.openConnection();
        InputStreamReader in=new InputStreamReader(con.getInputStream());
        BufferedReader reader=new BufferedReader(in);

        int numeroLineas=0;
        boolean encontrada=false;
        String lineaActual="nada";
        while((lineaActual=reader.readLine())!=null){

            if(encontrada && numeroLineas<=1){
                System.out.println(lineaActual);
                numeroLineas++;
            }
           if(lineaActual.contains("Outside Temp")){
               encontrada=true;
               System.out.println("SI LA ENCONTRO!!!");
               numeroLineas++;
           }

        }
        System.out.println("este se ve una vez por estar afuera del while");



        return mensaje;
    }
}
