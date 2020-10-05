package boleto;

import org.junit.jupiter.api.*;
import java.util.Date;
import static org.junit.Assert.*;

public class BoletoTest {
    
    private Boleto boleto;

    @BeforeEach
    public void inicializa() {
        boleto = new Boleto();
    }

    @DisplayName("Teste de set do Boleto")
    @Test
    public void testSetBoleto() {
        boleto.setCodigo("A000272");
        boleto.setDate("05/10/2020");
        boleto.setValorPago(600.98);
        assertNotEquals(boleto, new Boleto());
    }

    @Test
    public void testGetters() {
        boleto = new Boleto("A000272", "05/10/2020", 600.98);
        Assertions.assertAll("boleto",
                () -> assertEquals("A000272", boleto.getCodigo()),
                () -> assertNotNull(boleto.getData()),
                () -> assertEquals(600.98, boleto.getValorPago(), 0));
    }
}