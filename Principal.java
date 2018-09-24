import java.util.Scanner;
public class Principal {
    public static Scanner tc = new Scanner(System.in);
    public static void main(String args[]){
        
        Sala s = new Sala();
        Cliente c = new Cliente();
        
        String help = "show: mostra as cadeiras disponiveis \n"+
                "reservar: reserva uma cadeira repassando nome, ID e numero da caeira \n"+
                "sair: sai do sistema";
        
        System.out.print("Olá, inicialise uma sala digitanto o numero de lugares: ");
        int tamanho = tc.nextInt();
        s.setTam(tamanho);
        s.setAssentos(new Cliente[tamanho]);
        s.setShow(new String[tamanho]);
        tc.nextLine();
        System.out.println("Sala iniciada!");
        
        while (true){
            
            System.out.println("\n"+
            "O que deseja fazer agora? \n"+
            "(digite help para mostar as opções)");
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
                    System.out.print("Digite o nome: ");
                    String nome = tc.nextLine();
                    System.out.print("Digite o ID: ");
                    String id = tc.nextLine();
                    System.out.print("Digite a cadeira: ");
                    int cadeira = tc.nextInt()-1;
                    tc.nextLine();
                   
                    boolean sai = false;
               
                    for(int i=0;i<tamanho;i++){
                        if(s.getAssentos()[i]!=null && s.getAssentos()[i].getId().equals(id)){
                            sai=true;
                        }
                    }
                    
                    if (s.getAssentos()[cadeira]==null && sai==false){
                        c.setNome(nome);
                        c.setId(id);
                        s.setId(id);
                        c.setCadeira(cadeira);
                        s.getAssentos()[cadeira]=c;
                        s.getShow()[cadeira]= c.getNome()+"   ";
                       
                        System.out.println("Cadeira reservada com sucesso!");   
                    }else if(sai==true){
                        System.out.println("ID já existente");
                    }else{
                        System.out.println("Cadeira já está reservada");
                    }
                    break;
                case "cancelar":
                    System.out.print("Digite o ID: ");
                    String cod = tc.nextLine();
                    for (int i = 0; i < tamanho;i++){
                        if(s.getAssentos()[i]!=null && s.getAssentos()[i].getId().equals(cod)){
                            s.getAssentos()[i] = null;
                            s.getShow()[i] = "-   ";
                        }
                    }
                    break;
                default:
                    System.out.print("Comando invalido");
                    break;   
            }
        }
    }       
}
