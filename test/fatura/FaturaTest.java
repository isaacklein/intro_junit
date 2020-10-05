package fatura;

import fatura.StatusFaturaEnum.StatusFatura;
import org.junit.jupiter.api.*;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FaturaTest {
    private static final Date DATA_ATUAL = new Date(System.currentTimeMillis());
    private Fatura fatura;

    @BeforeEach
    public void inicializaTest() {
        fatura = new Fatura();
    }

    @DisplayName("Test set Fatura")
    @Test
    public void testaSet() {
        fatura.setDate(DATA_ATUAL);
        fatura.setValorTotal(999.66);
        fatura.setNomeCliente("Isaac");
        fatura.setStatusFatura(StatusFatura.NAO_PAGA);
        assertNotEquals(fatura, new Fatura());
    }

    @DisplayName("Test get Fatura")
    @Test
    public void testaGet() {
        fatura = new Fatura(DATA_ATUAL, 999.66, "Isaac", StatusFatura.NAO_PAGA);
        Assertions.assertAll("fatura",
                () -> assertEquals(DATA_ATUAL, fatura.getDate()),
                () -> assertEquals(999.66, fatura.getValorTotal(), 0),
                () -> assertEquals("Isaac", fatura.getNomeCliente()));
    }
}