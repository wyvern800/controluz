package mlhvproductions.controluz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.util.Date;

public class InsereDado extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BancoController crud = new BancoController(getBaseContext());
        ToggleButton botao = (ToggleButton) findViewById(R.id.btnLigaDesligaSala);
        String data = DateFormat.getDateTimeInstance().format(new Date());

        if (botao.isChecked()) { //luz ligada
            crud.insereDado("As luzes foram ligadas", data);
        } else {
            crud.insereDado("As luzes foram desligadas", data);
        }

    }
}
