package co.edu.uniquindio.Model;

import java.util.List;

import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.Persistencia.GestorArchivo;

public class TransaccionServicio {

    private GestorArchivo gestorArchivo;

    public TransaccionServicio() {
        this.gestorArchivo = new GestorArchivo();
    }

    public void realizarTransaccion(TransaccionDTO transaccionDTO, double montoUsuario) {
        double monto = transaccionDTO.getMonto();

        if (monto <= 0 || monto > montoUsuario) {
            ArchivoUtil.mostrarAlerta("ERROR","Monto inválido o insuficiente.");
            return;
        }

        Transaccion transaccion = new Transaccion(
            transaccionDTO.getIdTransaccion(), 
            transaccionDTO.getFechaTransaccion(), 
            String.valueOf(monto), 
            transaccionDTO.getDescripcionOpcional(), 
            transaccionDTO.getNumeroCuenta(), 
            transaccionDTO.getNombreUsuario()
        );



        try {
            gestorArchivo.guardarTransaccion(transaccion);
            ArchivoUtil.mostrarAlerta("ÉXITO!!!", "Transacción realizada con éxito.");
        } catch (Exception e) {
            ArchivoUtil.mostrarAlerta("ERROR!!!", "Error al guardar la transacción");
        }
    }

    public List<TransaccionDTO> listarTransacciones() {
        try {
            return GestorArchivo.cargarTransaccionesDTO();
        } catch (Exception e) {
            ArchivoUtil.mostrarAlerta("ERROR!!!", "Error al cargar las transacciones.");
            return null;
        }
    }

    public void actualizarSaldoUsuario(double saldoDisponible, double montoTransaccion) {
        double nuevoSaldo = saldoDisponible - montoTransaccion;
        gestorArchivo.actualizarSaldoUsuario(nuevoSaldo);
    }
    
}
