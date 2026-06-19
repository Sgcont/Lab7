public class Selo implements Colecionavel {

    private String pais;

    private int posicao;

    public Selo(int posicao, String pais) {
        this.posicao = posicao;
        this.pais = pais;
    }

    @Override
    public int getPosicao() {
        return posicao;  // faz-se uma conta envolvendo o país do selo, etc.
    }

    @Override
    public TipoDeColecionavel getTipo() {
        return TipoDeColecionavel.COMUM;
    }

    public String getTexto() {
        return "Selo de " + pais + " (R$ " + getValorMonetario() + ")";
    }

    public double getValorMonetario() {
        return getTipo().getPreco();
    }
}