class Cliente {
    private int id;
    private String nome;
    private String email;

    public Cliente() {}

    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Cliente ID: " + this.id + ", Nome: " + this.nome + ", Email: " + this.email;
    }
}
