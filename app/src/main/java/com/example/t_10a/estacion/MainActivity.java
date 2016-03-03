package com.example.t_10a.estacion;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
String temperaturaActual="--";
public static String radiacionActual="--";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TareaEstacion tarea=new TareaEstacion();
                tarea.execute(null,null,null);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.radiacionUV) {
            Intent intent=new Intent(getApplicationContext(), ActividadRadiacionUV.class);
            Tareauv tarea=new Tareauv();
            tarea.execute(null,null,null);
            startActivity(intent);


            return true;
        }else if(id==R.id.pronostico){

            Intent intent=new Intent(getApplicationContext(), ActividadPronostico.class);
            startActivity(intent);

        }else if(id==R.id.salir){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
  class  TareaEstacion extends AsyncTask<String, Integer, Integer> {

      @Override
      protected Integer doInBackground(String... params) {
          try{
              System.out.println(cargar());
              temperaturaActual=cargar();
          }catch(Exception e)
          {
            System.out.println("Algo malo sucedio:"+e.getMessage());
          }
          return 0;
      }

      @Override
      protected void onPostExecute(Integer integer) {
          super.onPostExecute(integer);
       TextView tv= (TextView) findViewById(R.id.textoTemperaturaActual);
          tv.setText(temperaturaActual);



      }
      public String cargar()throws Exception{
           ServicioEstacion servicio=new ServicioEstacion();
          return servicio.leerEstacion();
      }


      }

    class  Tareauv extends AsyncTask<String, Integer, Integer> {

        @Override
        protected Integer doInBackground(String... params) {
            try{
                System.out.println(cargar());
                radiacionActual=cargar();
            }catch(Exception e)
            {
                System.out.println("Algo malo sucedio:"+e.getMessage());
            }
            return 0;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            TextView tv= (TextView) findViewById(R.id.textoTemperaturaActual);
            tv.setText(radiacionActual);



        }
        public String cargar()throws Exception{
            ServicioEstacion servicio=new ServicioEstacion();
            return servicio.leerUV();
        }


    }





}
