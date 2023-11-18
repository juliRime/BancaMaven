import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @BeforeEach
    void beforeClass(){
        System.out.println("Esto se ejecuta primero");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("Esto se ejecuta una sola vez");
    }

    @Test
    void depositarConSaldoInical5SeObtieneSaldoFinalDe10Depositando5() {
        System.out.println("Test de depositar");
        // A -> Arrange - Preparaciòn
        double saldoADepositar = 5;
        Cuenta cuenta = new Cuenta("Fuli", "123", 5);
        double saldoEsperado = 10;

        // A -> Act - Ejecuciòn
        cuenta.depositar(saldoADepositar);

        // A -> Assert - Verificaciòn
        assertEquals(saldoEsperado, cuenta.getSaldo());
    }

    @Test
    void retirarConSaldoSuficiente() {
        System.out.println("Test de retirar");
        // A -> Arrange - Preparación
        double saldoActual = 7;
        double saldoARetirar = 3;
        double saldoEsperado = 4;
        Cuenta cuentilla = new Cuenta("Leguxito", "1234", saldoActual);

        // A -> Act - Ejecución
        cuentilla.retirar(saldoARetirar);

        // A -> Assert - Verificación
        assertEquals(saldoEsperado, cuentilla.getSaldo());
    }

    @Test
    void retirarSinSaldoSuficiente() {
        System.out.println("Test de retirar");

        // A -> Arrange - Preparación
        double saldoActual = 8;
        double saldoARetirar = 10;
        double saldoEsperado = 8;
        Cuenta cuenta = new Cuenta("Leguxito", "1234", saldoActual);

        // A -> Act - Ejecución
        try {
            cuenta.retirar(saldoARetirar);
            fail("Permitió retirar");
        } catch (RuntimeException err){
            // A -> Assert - Verificación
            assertEquals(saldoEsperado, cuenta.getSaldo());
        }

    }

    @Test
    void transferenciaNoSeHaceCuandoValorTranferidoMenorA0() {
        System.out.println("Test de tranferencia");

        // A -> Arrange - Preparación
        double saldoActual = 10;
        double valorTranferencia = 0;
        double saldoEsperado = 10;
        Cuenta cuentaOrigen = new Cuenta("Fuli", "123", saldoActual);
        Cuenta cuentaDestino = new Cuenta("Leguxito", "1234", saldoActual);

        // A -> Act - Ejecución
        boolean resultado = cuentaOrigen.transferencia(cuentaDestino,valorTranferencia);

        // A -> Assert - Verificación

        assertEquals(saldoEsperado, cuentaOrigen.getSaldo());
        assertEquals(saldoEsperado, cuentaDestino.getSaldo());
        assertFalse(resultado);
    }

    @Test
    void transferenciaExitosa() {
        System.out.println("Test de tranferencia");

        // A -> Arrange - Preparación
        double saldoActual = 10;
        double valorTranferencia = 5;
        double saldoEsperado = 5;
        double saldoActualDestino = 10;
        double saldoEsperadoDestino = 15;
        Cuenta cuentaOrigen = new Cuenta("Fuli", "123", saldoActual);
        Cuenta cuentaDestino = new Cuenta("Leguxito", "1234", saldoActualDestino);

        // A -> Act - Ejecución
        boolean resultado = cuentaOrigen.transferencia(cuentaDestino,valorTranferencia);

        // A -> Assert - Verificación

        assertEquals(saldoEsperado, cuentaOrigen.getSaldo());
        assertEquals(saldoEsperadoDestino, cuentaDestino.getSaldo());
        assertTrue(resultado);
    }

    @Test
    void transferenciaNoSeHaceCuandoElSaldoEsMenorAlValorATransferir() {
        System.out.println("Test de tranferencia");

        // A -> Arrange - Preparación
        double saldoActual = 10;
        double valorTranferencia = 15;
        double saldoEsperado = 10;
        double saldoActualDestino = 10;
        double saldoEsperadoDestino = 10;
        Cuenta cuentaOrigen = new Cuenta("Fuli", "123", saldoActual);
        Cuenta cuentaDestino = new Cuenta("Leguxito", "1234", saldoActualDestino);

        // A -> Act - Ejecución
        boolean resultado = cuentaOrigen.transferencia(cuentaDestino,valorTranferencia);

        // A -> Assert - Verificación

        assertEquals(saldoEsperado, cuentaOrigen.getSaldo());
        assertEquals(saldoEsperadoDestino, cuentaDestino.getSaldo());
        assertFalse(resultado);
    }
}