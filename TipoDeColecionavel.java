public enum TipoDeColecionavel {

    COMUM(1.00),
    RARO(2.00),
    BRILHANTE(3.00);

    private final double preco;

    TipoDeColecionavel(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}

