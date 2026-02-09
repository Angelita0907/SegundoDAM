package com.example.exament4_t5;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Docente extends AppCompatActivity {

    // Identificador único para el canal (obligatorio en API 26+)
    private static final String CHANNEL_ID = "canal_basico_1";
    private static final int NOTIFICATION_ID = 101;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_docente, menu);

        return true;
    }

    // con esto podremos usar el menú docente
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("menu",item.toString());
        // para poder decirle que si se pulsa cerrar sesión del menú salte un diálogo
        if (item.getItemId() == R.id.cerrar) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Seguro que quieres salir de esta maravillosa app?")
                    .setIcon(R.mipmap.ic_launcher)

                    .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.i("Elegido","Salir");
                        }
                    })
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.i("Elegido","No salir");
                        }
                    });
            // Creamos y mostramos el diálogo
            AlertDialog dialog = builder.create();
            dialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_docente);

        ListView listado = (ListView) findViewById(R.id.estudiantes);
        final String[] datos = new String[]{"Juan López\n1ºDAM",
                "Manuela Romero\n1ºDAM",
                "Ángel García\n1ºDAM",
                "Juan López\n1ºDAM",
                "Ana Sanz\n1ºDAM",
                "Raúl Ramirez\n1ºDAM"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adaptador);

        // voy a poner el boton de añadir que envie una notificacion cuando añadamos uno
        createNotificationChannel();

        Button btnNotificar = findViewById(R.id.nuevoEstudiante);
        btnNotificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarNotificacion();
            }
        });

    }
    // he quitado algunos comentarios porque eran los mismos que la presentación
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "noticacion nuevo estudiate";
            String description = "Canal para notificaciones";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Registrar el canal en el sistema
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void lanzarNotificacion() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("¡Hola Javii!")
                .setContentText("Has añadido un estudiante nuevo")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true); // Se cierra al tocarla

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // Si no hay permiso, aquí deberíamos pedirlo.
            return;
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }


}