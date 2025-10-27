package com.example.appejemplo;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CAMERA_PERMISSION = 1;
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
    }

 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // Verificar si el permiso de cámara está concedido
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            // Si ya tiene permiso, abrir la cámara
            abrirCamara();
        } else {
            // Si no tiene permiso, solicitarlo
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
        }

/*
        setContentView(R.layout.activity_actividad1);

        Intent ejemplo = new Intent(MainActivity.this, Activity2.class);
        startActivity(ejemplo);

        /*Intent ejemplo2 = new Intent(Intent.ACTION_VIEW);
        ejemplo2.setData(Uri.parse("https://www.google.es"));
        startActivity(ejemplo2);

        Intent ejemplo3 = new Intent(Intent.ACTION_DIAL );
        ejemplo3.setData(Uri.parse("tel:NUMERO"));
        startActivity(ejemplo3);

        Intent ejemplo4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(ejemplo4);
*/


    }

    private void abrirCamara() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); // Acción para abrir la cámara
        startActivity(intent);  // Lanzar la actividad de la cámara
    }
    @Override
    protected void onStart(){
        super.onStart();

        Intent ejemplo = new Intent(this, Activity2.class);
        ejemplo.putExtra("Surname", "Chica");
        startActivity(ejemplo);

        /*
        setContentView(R.layout.activity_main);
        // Verificar si el permiso de cámara está concedido
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            // Si ya tiene permiso, abrir la cámara
            abrirCamara();
        } else {
            // Si no tiene permiso, solicitarlo
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
        }

         */
    }


}





