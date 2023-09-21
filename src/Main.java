import java.util.Scanner;
import java.util.Vector;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Vector<Alunno> classe = new Vector<>();

    public static void main(String[] args) {

        int scelta;

        do {
            System.out.println("\n== MENU ==");
            System.out.println("""
                1. Inserisci anagrafica dello studente
                2. Stampa la classe
                3. Ricerca
                0. Esci""");

            System.out.print("\nScelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> AggiungiAlunno();
                case 2 -> StampaClasse();
                case 3 -> {System.out.print("\nInserisci il nome dell'alunno da cercare: ");
                    String NomeAlunno = scanner.next().toLowerCase();
                    RicercaAlunno(NomeAlunno);}
                case 0 -> System.out.println("Arrivederci!");
                default -> System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        scanner.close();
    }

    private static void AggiungiAlunno() {
        System.out.print("\nInserisci il nome: ");
        String nome = scanner.next().toLowerCase();

        System.out.print("Inserisci il cognome: ");
        String cognome = scanner.next().toLowerCase();

        classe.add(new Alunno(nome, cognome));

        System.out.println("\nAlunno registrato.");
    }

    private static void StampaClasse() {
        System.out.print("\nNella classe sono presenti:\n");

        int i=0;
        for (Alunno alunno : classe) {
            System.out.println(i+1 + ". " + alunno.nome() + " " + alunno.cognome());
            i++;
        }
    }

    private static void RicercaAlunno(String NomeAlunno) {
        boolean trovato = false;

        for (Alunno alunno : classe) {
            if (alunno.nome().equals(NomeAlunno)) {
                System.out.println(alunno.nome() + " " + alunno.cognome());

                trovato = true;
            }
        }

        if (!trovato) {
            System.out.println("Non ci sono persone con quel nome.");
        }
    }
}