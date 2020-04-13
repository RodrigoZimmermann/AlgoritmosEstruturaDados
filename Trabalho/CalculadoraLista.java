
/**
 *
 * @author Rodrigo Lu�s Zimmermann
 */
public class CalculadoraLista {

    PilhaLista<String> pilha = new PilhaLista<>();
    private int count = 0;
    private boolean fim = false;
    PilhaLista<String> resultadoExpressao = new PilhaLista<>();
    private int retorno = 0;
    private String sinal;
    private String segundoCalculo;
    private String primeiroCalculo;
    private int resultado;

    public void pegaValor(String entrada) throws Exception {
    	entrada.trim();
        for (int i = 0; i < entrada.length() - 1;) {
            String concatena = null;
            while (entrada.charAt(i) != ' ') {
                concatena = String.valueOf(entrada.charAt(i));
                i++;
            }
            if (concatena == null) {
                i++;
            }
            if (!(concatena == null)) {
                pilha.push(concatena);
            }
            switch (pilha.peek()) {
                case "*":
                    sinal = pilha.pop();
                    segundoCalculo = pilha.pop();
                    primeiroCalculo = pilha.pop();
                    resultado = Integer.parseInt(primeiroCalculo) * Integer.parseInt(segundoCalculo);
                    resultadoExpressao.push(Integer.toString(resultado));
                    break;
                case "/":
                    sinal = pilha.pop();
                    segundoCalculo = pilha.pop();
                    primeiroCalculo = pilha.pop();
                    resultado = Integer.parseInt(primeiroCalculo) / Integer.parseInt(segundoCalculo);
                    resultadoExpressao.push(Integer.toString(resultado));
                    break;
                case "-":
                    sinal = pilha.pop();
                    segundoCalculo = pilha.pop();
                    primeiroCalculo = pilha.pop();
                    resultado = Integer.parseInt(primeiroCalculo) - Integer.parseInt(segundoCalculo);
                    resultadoExpressao.push(Integer.toString(resultado));
                    break;
                case "+":
                    sinal = pilha.pop();
                    segundoCalculo = pilha.pop();
                    primeiroCalculo = pilha.pop();
                    resultado = Integer.parseInt(primeiroCalculo) + Integer.parseInt(segundoCalculo);
                    resultadoExpressao.push(Integer.toString(resultado));
                    break;
            }
            if (entrada.length() == i + 1) {
                resultadoExpressao.push(Integer.toString(entrada.charAt(i)));
            }
        }

    }

    public String passaValor() throws Exception {
            sinal = resultadoExpressao.peek();
            while (resultadoExpressao.vazia()) {
                segundoCalculo = resultadoExpressao.pop();
                primeiroCalculo = resultadoExpressao.pop();
                resultado = Integer.parseInt(primeiroCalculo) + Integer.parseInt(sinal) + Integer.parseInt(segundoCalculo);
                retorno = retorno + resultado;
            }
        return Integer.toString(retorno);
    }

}
