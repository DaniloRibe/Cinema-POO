import java.util.Scanner;
public class Principal {
    public static Scanner tc = new Scanner(System.in);
    public static void main(String args[]){
        
        Sala s = new Sala();
        
        String help = "==================================================================== \n"+
                      "show: mostra as cadeiras disponíveis \n"+
                      "reservar: reserva uma cadeira repassando nome, ID e número da cadeira \n"+
                      "sair: sai do sistema \n"+
                      "====================================================================";
        
        System.out.print("Olá, inicialize uma sala digitanto o número de lugares: ");
        int tamanho = tc.nextInt();
        s.setTam(tamanho);
        s.setAssentos(new Cliente[tamanho]);
        s.setShow(new String[tamanho]);
        tc.nextLine();
        System.out.println("Sala iniciada!");
        
        
        while (true){
            
            System.out.println("\n"+
            "O que deseja fazer agora? \n"+
            "(Digite help para mostar as opções)");
            String comando = tc.nextLine();
            if (comando.equals("sair")){
                break;
            }
            switch (comando){
                case "help":
                    System.out.println(help);
                    break;
                case "show":
                    s.estado();
                    break;
                case "reservar":
                    if(!s.estaCheia()){
                        System.out.print("Digite o nome: ");
                        String nome = tc.nextLine();
                        System.out.print("Digite o ID: ");
                        String id = tc.nextLine();
                        System.out.print("Digite a cadeira: ");
                        int cadeira = tc.nextInt();
                        tc.nextLine();
                        if (cadeira<=0||cadeira>tamanho){
                            System.out.println("\n"+"ERRO! Cadeira inexistente.");
                        }else{
                            s.reservar(nome, id, cadeira);
                        }
                    }else{
                        System.out.println("\n"+"ALERTA: Impossível reservar! A sala está cheia.");
                    }
                    break;
                case "cancelar":
                    if(!s.temReservas()){
                        System.out.println("\n"+"ALERTA! Não há ninguém na sala");
                    }else{
                        System.out.print("Digite o ID: ");
                        String cod = tc.nextLine();
                        s.cancelar(cod);
                    }
                    break;
                default:
                    System.out.print("Comando invalido");
                    break;   
            }
        }
    }       
}
