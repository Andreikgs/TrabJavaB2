class Laptop extends Computador {
    private double peso;

    public Laptop() {
        super();
    }

    public Laptop(int id, String marca, String modelo, double preco, double peso) {
        super(id, marca, modelo, preco);
        this.peso = peso;
    }

    public void exibirDetalhes() {
        System.out.println(this.toString() + ", Peso: " + this.peso + " kg");
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
