package com.example.notificaciones;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // mensaje Toast
/*
        Toast toast = Toast.makeText(getApplicationContext(),"Prueba mensaje Toast",Toast.LENGTH_LONG);
        toast.show();
*/

        // mensajes de diálogo para elegir
        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        String[] choices = {"Mandarinas", "Naranjas", "Manzanas"};

        builder.setTitle("Elige una fruta para continuar")
                .setSingleChoiceItems(choices, 0, (dialog, which) -> {
                    // 'which' contiene el índice de la fruta seleccionada
                    Log.i("Fruta", "Has marcado: " + choices[which]);
                })
                .setPositiveButton("Enviar", (dialog, which) -> {
                    // Aquí va la lógica al pulsar enviar
                    Toast.makeText(this, "Enviando selección...", Toast.LENGTH_LONG).show();
                })
                .setNegativeButton("Atrás", (dialog, which) -> {
                    dialog.dismiss();
                });

        AlertDialog dialog = builder.create();
        dialog.show();
*/
    // Identificador único para el canal (obligatorio en API 26+)
    private static final String CHANNEL_ID = "canal_basico_1";
    // ID único para la notificación (para actualizarla o cancelarla luego)

    private static final int NOTIFICATION_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Crear el canal de notificaciones (Solo necesario en Android 8.0+)
        createNotificationChannel();

        Button btnNotificar = findViewById(R.id.btnNotificar);
        btnNotificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarNotificacion();
            }
        });
    }

    private void createNotificationChannel() {
        // Solo se crea el canal si la versión es Android 8.0 (API 26) o superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notificaciones Básicas";
            String description = "Canal para aprender notificaciones";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Registrar el canal en el sistema
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    /*
    private void lanzarNotificacion() {
        // 2. Construir la notificación
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info) // Icono del sistema (puedes usar el tuyo propio)
                .setContentTitle("¡Hola Javii!")
                .setContentText("Hice mi primera notificacion!!!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true); // Se cierra al tocarla
        // 3. Mostrar la notificación
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // Chequeo de permisos para Android 13+ (necesario para evitar crashes en versiones nuevas)
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // Si no hay permiso, aquí deberíamos pedirlo.
            // Para este ejemplo básico, simplemente retornamos.
            return;
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());


    }
*/
    // notificacion con imagen
    private void lanzarNotificacion() {
        // 1. Primero necesitas obtener el Bitmap de tu imagen
        // Opción A: Desde recursos drawable
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.descarga);

        // Opción B: Desde una URL (requiere hacerlo en un hilo separado)
        // Bitmap myBitmap = obtenerImagenDeUrl("https://ejemplo.com/imagen.jpg");

        // 2. Crear el PendingIntent (opcional, si quieres que la notificación abra algo)
        Intent intent = new Intent(this, MainActivity.class);
        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            flags |= PendingIntent.FLAG_IMMUTABLE;
        }
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, flags);

        // 3. Construir la notificación con imagen grande
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notificacion)
                .setContentTitle("Notificación con imagen")
                .setContentText("Mira un hamster!!!")
                .setLargeIcon(myBitmap) // Imagen pequeña circular al lado del texto
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(myBitmap) // Imagen grande cuando expandes la notificación
                        .bigLargeIcon((Bitmap) null)) // Oculta el icono grande cuando se expande
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // 4. Mostrar la notificación
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
            // En Android 13+ necesitas solicitar el permiso
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
            return;
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }


    // lo mismo pero la notificación no lleva a otro activity
    /*
    private void lanzarNotificacion() {
        // 1. Crear el Intent explícito para abrir la SecondActivity
        Intent intent = new Intent(this, segunda.class);

        // Esto sirve para que al dar atrás, no vuelvas a la notificación, sino que se maneje la pila de apps
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // 2. Crear el PendingIntent
        // IMPORTANTE: Desde Android 12 (API 31) es obligatorio especificar MUTABLE o IMMUTABLE
        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            flags |= PendingIntent.FLAG_IMMUTABLE;
        }

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, flags);

        // 3. Construir la notificación con el .setContentIntent
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("¡Hola Mundo!")
                .setContentText("Tócame para ver el mensaje secreto.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // AQUI conectamos el PendingIntent:
                .setContentIntent(pendingIntent)
                // AQUI decimos que la notificación desaparezca al tocarla:
                .setAutoCancel(true);

        // 4. Mostrar la notificación (esto sigue igual)
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
     */

}


