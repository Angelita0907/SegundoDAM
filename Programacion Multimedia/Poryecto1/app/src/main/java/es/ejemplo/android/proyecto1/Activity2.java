package es.ejemplo.android.proyecto1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Activity2 extends AppCompatActivity {

    private static final int REQUEST_CAMERA_PERMISSION = 1;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_actividad2);
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
        Log.i("Cámara", "onCreate: La actividad ha sido creada");
        // Verificar si el permiso de cámara está concedido
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            Log.i("Cámara", "Permiso de cámara concedido previamente");
            // Si ya tiene permiso, abrir la cámara
            abrirCamara();
        } else {
            // Si no tiene permiso, solicitarlo
            Log.i("Cámara", "Solicitando permiso de cámara");
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
        }
    }
    private void abrirCamara() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); // Acción para abrir la cámara
        startActivity(intent);  // Lanzar la actividad de la cámara
    }


    @Override
    public void onStart() {
        super.onStart();

        // Verificar si se concedió el permiso de cámara
        setContentView(R.layout.activity_actividad2);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            Log.i("Cámara", "Permiso de cámara concedido por el usuario");
            // Si ya tiene permiso, abrir la cámara
            abrirCamara();
        } else {
            // Si no tiene permiso, solicitarlo
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
            Log.i("Cámara", "Permiso de cámara denegado");

        }
    }

/*
    @Override
    protected  void onDestroy(){
            super.onDestroy();
            Intent ejemplo = new Intent(this, Activity2.class);
            startActivity(ejemplo);

            Intent ejemplo2 = new Intent(Intent.ACTION_VIEW);
            ejemplo2.setData(Uri.parse("https://www.google.es"));
            startActivity(ejemplo2);


    }
   */

}
