package co.edu.uniquindio.Exceptions;

public class Exceptions extends Exception {
    
    public Exceptions(String message) {
        super(message);
    }

    public static class SaldoInsuficienteException extends Exceptions {
        public SaldoInsuficienteException() {
            super("No tiene saldo suficiente para realizar la transacción.");
        }
    }

    public static class TransaccionInvalidaException extends Exceptions {
        public TransaccionInvalidaException() {
            super("La transacción es inválida.");
        }
    }

    public static class WalletNoEncontradaException extends Exceptions {
        public WalletNoEncontradaException() {
            super("No se encontró la billetera.");
        }
    }

    public static class OperacionInvalidaException extends Exceptions {
        public OperacionInvalidaException() {
            super("Operación no válida para la billetera.");
        }
    }

    public static class TarjetaBloqueadaException extends Exceptions {
        public TarjetaBloqueadaException() {
            super("La tarjeta está bloqueada.");
        }
    }
    
    public static class CuentaInactivaException extends Exceptions {
        public CuentaInactivaException() {
            super("La cuenta está inactiva.");
        }
    }
    
    public static class LimiteTransaccionException extends Exceptions {
        public LimiteTransaccionException() {
            super("Ha superado el límite de transacción.");
        }
    }
    
    public static class InformacionInvalidaException extends Exceptions {
        public InformacionInvalidaException() {
            super("La información proporcionada es inválida.");
        }
    }

    public static class ContraseniaInvalidaException extends Exceptions {
        public ContraseniaInvalidaException() {
            super("La contraseña es inválida.");
        }
    }

    public static class GeneralException extends Exceptions{
        public GeneralException(){
            super("Hoy hay quiz muchachos");
        }
    }
}
