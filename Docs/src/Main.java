import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Computador> computadores = new ArrayList<>();
    private static ArrayList<Venda> vendas = new ArrayList<>();
    private static int computadorIdCounter = 1;
    private static int vendaIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean ativo = true;
        while (ativo) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Computador");
            System.out.println("2. Listar Computadores");
            System.out.println("3. Visualizar Computador Específico");
            System.out.println("4. Excluir Computador");
            System.out.println("5. Editar Computador");
            System.out.println("6. Registrar Venda");
            System.out.println("7. Listar Vendas");
            System.out.println("8. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    cadastrarComputador();
                    break;
                case 2:
                    listarComputadores();
                    break;
                case 3:
                    visualizarComputadorEspecifico();
                    break;
                case 4:
                    excluirComputador();
                    break;
                case 5:
                    editarComputador();
                    break;
                case 6:
                    registrarVenda();
                    break;
                case 7:
                    listarVendas();
                    break;
                case 8:
                    ativo = false;
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private static void cadastrarComputador() {
        System.out.println("Digite o tipo de computador (1. Desktop, 2. Laptop):");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a marca:");
        String marca = scanner.nextLine();
        System.out.println("Digite o modelo:");
        String modelo = scanner.nextLine();
        System.out.println("Digite o preço:");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.println("Tem gabinete? (true/false):");
            boolean temGabinete = scanner.nextBoolean();
            scanner.nextLine();
            computadores.add(new Desktop(computadorIdCounter++, marca, modelo, preco, temGabinete));
        } else if (tipo == 2) {
            System.out.println("Digite o peso:");
            double peso = scanner.nextDouble();
            scanner.nextLine();
            computadores.add(new Laptop(computadorIdCounter++, marca, modelo, preco, peso));
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void listarComputadores() {
    	System.out.println("Computadores:");
        if (computadores.isEmpty()) {
            System.out.println("Nenhum computador cadastrado.");
        } else {
            for (Computador comp : computadores) {
                comp.exibirDetalhes();
            }
        }
    }

    private static void visualizarComputadorEspecifico() {
        System.out.println("Digite o ID do computador:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Computador comp = findComputadorById(id);
        if (comp != null) {
            comp.exibirDetalhes();
        } else {
            System.out.println("Computador não encontrado.");
        }
    }

    private static void excluirComputador() {
        System.out.println("Digite o ID do computador:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Computador comp = findComputadorById(id);
        if (comp != null) {
            computadores.remove(comp);
            System.out.println("Computador excluído com sucesso.");
        } else {
            System.out.println("Computador não encontrado.");
        }
    }

    private static void editarComputador() {
        System.out.println("Digite o ID do computador:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Computador comp = findComputadorById(id);
        if (comp != null) {
            System.out.println("Digite a nova marca:");
            String marca = scanner.nextLine();
            System.out.println("Digite o novo modelo:");
            String modelo = scanner.nextLine();
            System.out.println("Digite o novo preço:");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            comp.marca = marca;
            comp.modelo = modelo;
            comp.preco = preco;

            if (comp instanceof Desktop) {
                System.out.println("Tem gabinete? (true/false):");
                boolean temGabinete = scanner.nextBoolean();
                scanner.nextLine();
                ((Desktop) comp).setTemGabinete(temGabinete);
                
                System.out.println("Digite o novo peso:");
                double peso = scanner.nextDouble();
                scanner.nextLine();
                ((Laptop) comp).setPeso(peso);
            }

            System.out.println("Computador atualizado com sucesso.");
        } else {
            System.out.println("Computador não encontrado.");
        }
    }

    private static void registrarVenda() {
        System.out.println("Digite o ID do computador:");
        int compId = scanner.nextInt();
        scanner.nextLine();

        Computador comp = findComputadorById(compId);
        if (comp == null) {
            System.out.println("Computador não encontrado.");
            return;
        }

        System.out.println("Digite o ID do cliente:");
        int clienteId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o email do cliente:");
        String email = scanner.nextLine();
        System.out.println("Digite a data da venda:");
        String data = scanner.nextLine();

        vendas.add(new Venda(vendaIdCounter++, comp, data, clienteId, nome, email));
        System.out.println("Venda registrada com sucesso.");
    }

    private static void listarVendas() {
    	System.out.println("Vendas:");
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Venda venda : vendas) {
                System.out.println(venda);
            }
        }
    }

    private static Computador findComputadorById(int id) {
        for (Computador comp : computadores) {
            if (comp.id == id) {
                return comp;
            }
        }
        return null;
    }
}
