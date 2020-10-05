package processador;

import boleto.Boleto;
import fatura.Fatura;
import fatura.StatusFaturaEnum.StatusFatura;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ProcessadorTest {

    private static final Date DATA_ATUAL = new Date(System.currentTimeMillis());
    private static final double VALOR_TOTAL_FATURA_PAGA = 1500;
    private static final double VALOR_TOTAL_FATURA_NAO_PAGA = 2000;
    private List<Boleto> listBoletos = new ArrayList<>();

    @BeforeEach
    public void inicializa() {
        listBoletos = new ArrayList<>();
        Date date = new Date(System.currentTimeMillis());
        Boleto boleto1 = new Boleto("A000271", date, 1400);
        Boleto boleto2 = new Boleto("B000272", date, 1000);
        listBoletos.addAll(Arrays.asList(boleto1, boleto2));
    }

    @DisplayName("Testa a verificação correta de uma Fatura paga")
    @Test
    public void testVerificaFaturaPaga() {
        Fatura fatura = inicializaFatura(VALOR_TOTAL_FATURA_PAGA);
        assertTrue(Processador.verificaFaturaPaga(listBoletos, fatura));
        assertEquals(StatusFatura.PAGA, fatura.getStatusFatura());
    }

    @DisplayName("Testa a verificação correta de uma Fatura não paga")
    @Test
    public void testVerificaFaturaEmAberto() {
        Fatura fatura = inicializaFatura(VALOR_TOTAL_FATURA_NAO_PAGA);
        assertFalse(Processador.verificaFaturaPaga(listBoletos, fatura));
        assertEquals(StatusFatura.NAO_PAGA, fatura.getStatusFatura());
    }

    @DisplayName("Testa se o processador está criando pagamentos relacionados a fatura")
    @Test
    public void testCriaPagamento() {
        Fatura fatura = inicializaFatura(VALOR_PAGO_FATURA_NAO_PAGA);
        Processador.criaPagamentos(listBoletos, fatura);
        assertEquals(listBoletos.size(), fatura.getPagamentoList().size());
    }

    private Fatura inicializaFatura(double valorPago) {
        return new Fatura(DATE, valorPago, "Isaac", StatusFatura.NAO_PAGA);
    }

}
