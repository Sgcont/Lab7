import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Album<T extends Colecionavel> {

    //    Figurinha[] itens;
    private Map<Integer, T> itemPorPosicao;
    private Map<Integer, Integer> contRepetidasPorPosicao;
    private int tamanho;

    public Album(int tamanho) {
//        itens = new Figurinha[tamanho + 1];  // end direto, sem usar a posição 0
        this.itemPorPosicao = new HashMap<>();
        this.tamanho = tamanho;
        this.contRepetidasPorPosicao = new HashMap<>();
    }

    public int getQuantasFaltamParaCompletar() {
        return tamanho - itemPorPosicao.size();
    }

    public void receberNovoItem(T item) {
        int posicao = item.getPosicao();
        if(itemPorPosicao.containsKey(posicao)){
            int qtd = contRepetidasPorPosicao.getOrDefault(posicao, 0);
            contRepetidasPorPosicao.put(posicao, qtd + 1);
        }else {
            itemPorPosicao.put(posicao, item);
        }
    }

    public T getItemDaPosicao(int posicao) {
        return itemPorPosicao.get(posicao);
    }

    //void ou float a ver
    public float venderRepetidos(int posicao, int quantidade) {
        int qtdRepetidas = contRepetidasPorPosicao.getOrDefault(posicao, 0);

        if (quantidade > qtdRepetidas){
            throw new RuntimeException("Quantidade informada maior que disponivel");
        }

        T item = getItemDaPosicao(posicao);

        float valorVenda = (float) (item.getTipo().getPreco() * quantidade);

        if (quantidade == qtdRepetidas){
            contRepetidasPorPosicao.remove(posicao);
        }
        else{
            contRepetidasPorPosicao.put(posicao, qtdRepetidas - quantidade);
        }
        return valorVenda;
    }

    public float venderRepetidos(int posicao){
        int quantidadeRepetida = contRepetidasPorPosicao.getOrDefault(posicao, 0);
        if (quantidadeRepetida == 0){
            return 0;
        }
        return venderRepetidos(posicao, quantidadeRepetida);
    }

    public float venderRepetidos(){
        float valorTotal = 0;
        List<Integer> posicoes = new ArrayList<>(contRepetidasPorPosicao.keySet());
        for (int posicao : posicoes){
            valorTotal += venderRepetidos(posicao);
        }
        return valorTotal;
    }
    public float venderRepetidos(TipoDeColecionavel tipo){
        float valorTotal = 0;
        List<Integer> posicoes = new ArrayList<>(contRepetidasPorPosicao.keySet());
        for (int posicao : posicoes){
            T item = getItemDaPosicao(posicao);
            if (item != null && item.getTipo() == tipo){
                valorTotal += venderRepetidos(posicao);
            }
        }
        return valorTotal;
    }

}
