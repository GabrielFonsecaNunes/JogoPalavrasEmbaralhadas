package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import embaralhar.*;


public class EmbaralhadorSimplesTest {

    @Test
    public void testEmbaralhar() {
        // Arrange
        EmbaralhadorSimples embaralhador = new EmbaralhadorSimples();
        String palavraOriginal = "teste";

        // Act
        String palavraEmbaralhada = embaralhador.embaralhar(palavraOriginal);
        System.out.println(palavraEmbaralhada);
        // Neste exemplo, espera-se que a palavra seja invertida e em maiúsculas.
        assertEquals("STETE", palavraEmbaralhada);
    }

    @Test
    public void testEmbaralharComPalavraVazia() {
        // Arrange
        EmbaralhadorSimples embaralhador = new EmbaralhadorSimples();
        String palavraOriginal = "";

        // Act
        String palavraEmbaralhada = embaralhador.embaralhar(palavraOriginal);

        // Assert
        assertEquals("", palavraEmbaralhada);
    }
}
