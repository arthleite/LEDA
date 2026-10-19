package problems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ATENÇÃO: Esta classe de teste cobre apenas o básico. 
 * Deixamos propositalmente vários cenários em aberto para você desenvolver seu aprendizado com JUnit. 
 * Crie novos testes para cobrir e blindar seu código.
 * 
 * DICA SOBRE OS ASSERTS:
 * - assertEquals(esperado, obtido): Verifica se o valor retornado é exatamente igual ao esperado.
 * - assertNull(valor): Garante que o retorno é nulo (null) (ideal para casos limites).
 * - assertNotNull(valor): Garante que o retorno não é nulo.
 * - assertTrue(condicao): Confirma se uma condição lógica é verdadeira.
 * - assertFalse(condicao): Confirma se uma condição lógica é falsa (ótimo para regras).
 */
public class StudentTestFloorCeilBinarySearch {

    private FloorCeil implementation;

    /**
     * A anotação @BeforeEach garante que este método execute ANTES de cada @Test.
     * É a melhor forma de garantir que a sua implementação seja instanciada "zerada" para cada cenário,
     * evitando que um teste interfira no resultado do outro.
     */
    @BeforeEach
    public void setUp() {
        implementation = new FloorCeilBinarySearchImpl();
    }
    
    // ==========================================
    // TESTES PARA FLOOR (PISO)
    // ==========================================

    // 1. Testa a busca exata de um floor presente no array.
    @Test
    public void testFloorBuscaBasica() {
        Integer[] array = {3, 11, 17, 24, 38, 45};
        assertEquals(Integer.valueOf(17), implementation.floor(array, 17));
    }

    // 2. Testa a busca de um floor para um valor intermediário ausente.
    @Test
    public void testFloorValorIntermediario() {
        Integer[] array = {2, 9, 14, 27, 35, 42, 50};
        Integer resultado = implementation.floor(array, 20);
        
        assertNotNull(resultado);

        // assertTrue é uma construção usada para verificar se um booleano é verdadeiro. Voce poderia usa-lo para 
        //verificar o valor do resultado retornado.
        assertTrue(resultado == 14);

        //Entretanto, como o método floor() retorna um numero, faz mais sentido verificar se o valor retornado é igual a
        // um valor esperado. Essa construção abaixo seria mais adequada neste caso.
        assertEquals(Integer.valueOf(14), resultado);
    }

    // 3. Testa o floor quando o alvo é menor que o menor elemento do array.
    @Test
    public void testFloorAbaixoDoLimite() {
        Integer[] array = {15, 23, 31, 42, 55, 68};
        assertNull(implementation.floor(array, 8));
    }

    // 4. Verifica se o resultado do floor respeita a regra lógica de não exceder o alvo.
    @Test
    public void testFloorPropriedadeLogica() {
        Integer[] array = {4, 12, 19, 28, 36, 44, 53, 61};
        Integer resultado = implementation.floor(array, 22);
        
        //o assertFalse é um examplo de testar se um valor é falso. Normalmente usamos ele quando o valor 
        //retornado por um método é booleano. Mas note que se o método floor() retornar outro valor que faz
        //o teste passar, por exemplo 12, o teste também passa, embora o valor para floor(22) seja 19.
        //Isso é um exemplo de teste que não possui a precisão para capturar a corretude por completo.
        assertFalse(resultado > 22);

        //a forma correta de capturar essa corertude seria como código abaixo. Ele é muito mais preciso.
        assertEquals(Integer.valueOf(19), resultado);
    }

    // 5. Testa a busca de um floor exatamente igual ao último elemento do array.
    @Test
    public void testFloorElementoNaBordaFinal() {
        Integer[] array = {7, 13, 20, 29, 34, 41};
        Integer resultado = implementation.floor(array, 41);
        assertTrue(resultado == 41);
    }

    // ==========================================
    // TESTES PARA CEIL (TETO)
    // ==========================================

    // 1. Testa a busca exata de um ceil presente no array.
    @Test
    public void testCeilBuscaBasica() {
        Integer[] array = {6, 14, 22, 31, 40, 48, 57};
        assertEquals(Integer.valueOf(22), implementation.ceil(array, 22));
    }

    // 2. Testa a busca de um ceil para um valor intermediário ausente.
    @Test
    public void testCeilValorIntermediario() {
        Integer[] array = {3, 8, 15, 26, 37, 49};
        Integer resultado = implementation.ceil(array, 18);
        
        assertNotNull(resultado);
        assertTrue(resultado == 26);
    }

    // 3. Testa o ceil quando o alvo é maior que o maior elemento do array.
    @Test
    public void testCeilAcimaDoLimite() {
        Integer[] array = {5, 12, 19, 30, 44};
        assertNull(implementation.ceil(array, 50));
    }

    // 4. Verifica se o resultado do ceil respeita a regra lógica de não ser menor que o alvo.
    @Test
    public void testCeilPropriedadeLogica() {
        Integer[] array = {2, 11, 18, 27, 39, 46, 54, 63};
        Integer resultado = implementation.ceil(array, 21);
        
        assertFalse(resultado < 21);
    }

    // 5. Testa a busca de um ceil exatamente igual ao primeiro elemento do array.
    @Test
    public void testCeilElementoNaBordaInicial() {
        Integer[] array = { 8, 17, 25, 34, 43, 52 };
        Integer resultado = implementation.ceil(array, 8);
        assertTrue(resultado == 8);
    }
    
     @Test
    public void testCeilElementoAntesDaBordaInicial() {
        Integer[] array = {8, 17, 25, 34, 43, 52};
        Integer resultado = implementation.ceil(array, 5);
        assertTrue(resultado == 8);
    }

    /**
     * O desafio agora é com você! Escreva novos testes explorando casos extremos (como 
     * elementos repetidos ou arrays unitários) para garantir que sua lógica seja infalível. 
     * Bons estudos e excelente código!
     */
}