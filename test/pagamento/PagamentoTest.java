package pagamento;

import org.junit.jupiter.api.*;
import pagamento.TipoPagamentoEnum.TipoPagamento;
import java.util.Date;
import static org.junit.Assert.*;

public class PagamentoTest {

    private static final Date DATA_ATUAL = new Date(System.currentTimeMillis());
    private Pagamento pagamento;

    public void inicializaTest() {
        pagamento = new Pagamento();
    }

    @DisplayName("Test set Pagamento")
    @Test
    public void testaSetters() {
        pagamento.setValorPago(666.33);
        pagamento.setDate(DATA_ATUAL);
        pagamento.setTipoPagamento(TipoPagamento.BOLETO);
        assertNotEquals(pagamento, new Pagamento());
    }

    @DisplayName("Test get Pagamento")
    @Test
    public void testaGetters() {
        pagamento = new Pagamento(666.33, DATA_ATUAL, TipoPagamento.BOLETO);
        Assertions.assertAll("pagamento",
                () -> assertEquals(666.33, pagamento.getValorPago(), 0),
                () -> assertNotNull(pagamento.getDate()),
                () -> assertEquals(TipoPagamento.BOLETO, pagamento.getTipoPagamento()));
    }


}


