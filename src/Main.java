import model.Paciente;
import model.Profissional;
import model.Agendamento;
import repository.PacienteRepositoryLista;
import repository.ProfissionalRepositoryLista;
import repository.AgendamentoRepositoryLista;
import service.PacienteService;
import service.ProfissionalService;
import service.AgendamentoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


        PacienteService pacienteService = new PacienteService(new PacienteRepositoryLista());
        ProfissionalService profissionalService = new ProfissionalService(new ProfissionalRepositoryLista());
        AgendamentoService agendamentoService = new AgendamentoService(new AgendamentoRepositoryLista());

        boolean running = true;

        while (running) {
            System.out.println("\n=== ETE CICERO DIAS ===");
            System.out.println("\n=== Sistema de Clínica ===");
            System.out.println("1 - Adicionar Paciente");
            System.out.println("2 - Listar Pacientes");
            System.out.println("3 - Adicionar Profissional");
            System.out.println("4 - Listar Profissionais");
            System.out.println("5 - Adicionar Agendamento");
            System.out.println("6 - Listar Agendamentos");
            System.out.println("7 - Buscar Paciente por ID");
            System.out.println("8 - Remover Paciente por ID");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // consumir o ENTER

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do paciente: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    pacienteService.adicionar(new Paciente(nome, cpf, id, telefone));
                    System.out.println("Paciente adicionado!");
                }

                case 2 -> {
                    System.out.println("\n=== Lista de Pacientes ===");
                    pacienteService.listar().forEach(System.out::println);
                }

                case 3 -> {
                    System.out.print("Nome do profissional: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidade = sc.nextLine();
                    System.out.print("CRM: ");
                    String crm = sc.nextLine();

                    profissionalService.adicionar(new Profissional(nome, cpf, id, especialidade, crm));
                    System.out.println("Profissional adicionado!");
                }

                case 4 -> {
                    System.out.println("\n=== Lista de Profissionais ===");
                    profissionalService.listar().forEach(System.out::println);
                }

                case 5 -> {
                    System.out.print("ID do paciente: ");
                    int idPaciente = sc.nextInt();
                    sc.nextLine();
                    System.out.print("ID do profissional: ");
                    int idProf = sc.nextInt();
                    sc.nextLine();

                    LocalDateTime dataHora = null;
                    boolean inputValido = false;
                    while (!inputValido) {
                        System.out.print("Data no formato (dd/MM/yyyy): ");
                        String dataStr = sc.nextLine();
                        System.out.print("Hora no formato (HH:mm): ");
                        String horaStr = sc.nextLine();

                        try {

                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate data = LocalDate.parse(dataStr, dateFormatter);


                            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                            LocalTime hora = LocalTime.parse(horaStr, timeFormatter);

                            dataHora = LocalDateTime.of(data, hora);

                            
                            if (dataHora.isBefore(LocalDateTime.now())) {
                                System.out.println("A data e hora do agendamento não podem ser anteriores à data e hora atuais. Por favor, insira novamente.");
                            } else {
                                inputValido = true;
                            }
                        } catch (java.time.format.DateTimeParseException e) {
                            System.out.println("Formato de data ou hora inválido. Por favor, use dd/MM/yyyy para a data e HH:mm para a hora.");
                        }
                    }

                    System.out.print("Observações: ");
                    String obs = sc.nextLine();

                    Paciente paciente = pacienteService.buscar(idPaciente);
                    Profissional profissional = profissionalService.buscar(idProf);

                    if (paciente != null && profissional != null) {
                        agendamentoService.adicionar(new Agendamento(paciente, profissional, dataHora, obs, idPaciente));
                        System.out.println("Agendamento adicionado!");
                    } else {
                        System.out.println("Paciente ou Profissional não encontrado!");
                    }
                }


                case 6 -> {
                    System.out.println("\n=== Lista de Agendamentos ===");
                    agendamentoService.listar().forEach(System.out::println);
                }

                case 7 -> {
                    System.out.print("ID do paciente: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Paciente paciente = pacienteService.buscar(id);
                    if (paciente != null) System.out.println(paciente);
                    else System.out.println("Paciente não encontrado!");
                }

                case 8 -> {
                    System.out.print("ID do paciente a remover: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    pacienteService.remover(id);
                    System.out.println("Paciente removido!");
                }

                case 0 -> {
                    running = false;
                    System.out.println("Saindo...");
                }

                default -> System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}