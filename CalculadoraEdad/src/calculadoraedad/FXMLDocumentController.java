package calculadoraedad;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    public Label salida, error;
    public TextField eDia, eMes, eAño;
    
    public void calcularEdad(ActionEvent event) {
        
        if (eDia.getText().length() == 0 || eMes.getText().length() == 0 || eAño.getText().length() == 0) {
            error.setText("Completa los datos primero");
            salida.setText("");
        } else {
            
            error.setText("");
            salida.setText("");
            
            int diaUsuario = parseInt(eDia.getText());
            int mesUsuario = parseInt(eMes.getText());
            int añoUsuario = parseInt(eAño.getText());
            
            Calendar c = Calendar.getInstance();
            int diaActual = c.get(Calendar.DATE);
            int mesActual = c.get(Calendar.MONTH)+1;
            int añoActual = c.get(Calendar.YEAR);
            
            System.out.print(diaActual+" de "+mesActual+" del "+añoActual);
            
            int edadUsuario;
            edadUsuario = añoActual - añoUsuario - 1;
            
            if (mesActual >= mesUsuario) {
                if (diaActual >= diaUsuario) {
                    edadUsuario++;
                }
            }
            
            salida.setText(valueOf(edadUsuario + " año(s)"));
            
        }
    }
    
    public void limpiarDatos(ActionEvent event) {
        eDia.setText("");
        eMes.setText("");
        eAño.setText("");
        salida.setText("");
        error.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
