class Venda extends Cliente {
    private int vendaId;
    private Computador computador;
    private String data;

    public Venda() {
        super();
    }

    public Venda(int vendaId, Computador computador, String data, int clienteId, String nome, String email) {
        super(clienteId, nome, email);
        this.vendaId = vendaId;
        this.computador = computador;
        this.data = data;
    }

    public int getVendaId() {
        return vendaId;
    }

    public Computador getComputador() {
        return computador;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Venda ID: " + this.vendaId + ", " + this.computador.toString() + ", Data: " + this.data + ", " + super.toString();
    }
}
