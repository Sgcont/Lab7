import java.awt.*;

public class Figurinha implements Colecionavel {

    private int posicao;

    private TipoDeColecionavel tipo;

    private String texto;  // o melhor seria imagem

    public Figurinha(int posicao, String texto, TipoDeColecionavel tipo) {
        this.posicao = posicao;
        this.texto = texto;
        this.tipo = tipo;
    }

    public int getPosicao() {
        return posicao;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public TipoDeColecionavel getTipo() {
        return tipo;
    }
}

