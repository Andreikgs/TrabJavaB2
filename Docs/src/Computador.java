abstract class Computador {
    protected int id;
    protected String marca;
    protected String modelo;
    protected double preco;

    public Computador() {}

    public Computador(int id, String marca, String modelo, double preco) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }

    public abstract void exibirDetalhes();

    // Sobrescrita
    @Override
    public String toString() {
        return "ID: " + this.id + ", Marca: " + this.marca + ", Modelo: " + this.modelo + ", Preço: R$ " + this.preco;
    }
}
