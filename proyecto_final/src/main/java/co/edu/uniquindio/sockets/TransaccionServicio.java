package co.edu.uniquindio.sockets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import co.edu.uniquindio.DTO.TransaccionDTO;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Transaccion;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.Persistencia.GestorArchivo;

public class TransaccionServicio {

    private GestorArchivo gestorArchivo = new GestorArchivo();
    LuxoraWallet luxora = LuxoraWallet.getInstanciaUnica();

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
            //gestorArchivo.guardarTransaccion(transaccion);
            ArchivoUtil.mostrarAlerta("ÉXITO!!!", "Transacción realizada con éxito.");
        } catch (Exception e) {
            ArchivoUtil.mostrarAlerta("ERROR!!!", "Error al guardar la transacción");
        }
    }
/*
    public LinkedList<Transaccion> listarTransacciones(LuxoraWallet luxora, Usuario usuario) {
        try {
            return gestorArchivo.cargarTransacciones(luxora, usuario);
            ArchivoUtil.mostrarAlerta("ERROR!!!", "Error al cargar las transacciones.");
            return null;
        }
    }

    public void actualizarSaldoUsuario(double saldoDisponible, double montoTransaccion) {
        double nuevoSaldo = saldoDisponible - montoTransaccion;
        gestorArchivo.actualizarSaldoUsuario(nuevoSaldo);
    }*/
}
