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
      URL url=new URL("http://www.weatherlink.com/user/sierraguadalupe/index.php?view=summary&headers=0");
        URLConnection con= url.openConnection();
        InputStreamReader in=new InputStreamReader(con.getInputStream());
        BufferedReader reader=new BufferedReader(in);

        int numeroLineas=0;
        boolean encontrada=false;
        String lineaActual="nada";
        while((lineaActual=reader.readLine())!=null){

            if(encontrada && numeroLineas<=0){
                System.out.println(lineaActual);
                int indice1=lineaActual.indexOf(">")+1;
                int indice2=lineaActual.indexOf("</");

                 mensaje= lineaActual.substring(indice1,indice2);
                numeroLineas++;
            }
           if(lineaActual.contains("Outside Temp")){
               encontrada=true;
               System.out.println("SI LA ENCONTRO!!!");

           }

        }
        System.out.println("este se ve una vez por estar afuera del while:"+mensaje);



        return mensaje;
    }
}
