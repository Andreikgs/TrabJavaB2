class Desktop extends Computador {
    private boolean temGabinete;

    public Desktop() {
        super();
    }

    public Desktop(int id, String marca, String modelo, double preco, boolean temGabinete) {
        super(id, marca, modelo, preco);
        this.temGabinete = temGabinete;
    }

    public void exibirDetalhes() {
        System.out.println(this.toString() + ", Gabinete: " + (this.temGabinete ? "Sim" : "Não"));
    }

    public void setTemGabinete(boolean temGabinete) {
        this.temGabinete = temGabinete;
    }
}
