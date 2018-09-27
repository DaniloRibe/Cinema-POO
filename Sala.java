
public class Sala {
    private int tam;
    private Cliente assentos[]= new Cliente[tam];
    private String show[] = new String[tam];



    public void estado(){
        System.out.println("\n");
        for(int i = 0; i<tam;i++){
            if (show[i]==null){
                show[i] = "-   ";
            }
        }
        for(String a: show){
            System.out.print(a);    
        }
        System.out.println("\n");    
    }
    
    public void reservar(String nome, String id, int cadeira){
        boolean sai = false;
        //verificando id
        for(int i=0;i<show.length;i++){
            if(assentos[i]!=null && assentos[i].getId().equals(id)){
                sai=true;
            }
        }
        if (assentos[cadeira-1]==null && sai==false){
            show[cadeira-1]= nome+"   ";
            assentos[cadeira-1] = new Cliente(nome,id,cadeira);
            System.out.println("\n"+"Cadeira reservada com sucesso!");
        }else if(sai==true){
            System.out.println("\n"+"ALERTA: ID já existente");
        }else{
            System.out.println("\n"+"ERRO: Cadeira já está reservada");
        }
    }
    
    public void cancelar(String id){
        boolean sai = false;
        String p = null;
        for (int i = 0; i < assentos.length;i++){
            if(assentos[i]!=null && assentos[i].getId().equals(id)){
                p = assentos[i].getNome();
                assentos[i]=null;
                show[i]="-   ";
                sai = true;
                
            }
        }
        if (sai==false){
            System.out.println("\n"+"ERRO: ID não encontrado");
        }else{
            System.out.println("\n"+"Reserva de "+p+" cancelada com sucesso");
        }
    }
    /*para verificar se há alguma cadeira reservada,
    antes de chamar o método reservar*/
    public boolean temReservas(){
        boolean s = false;
        for (Cliente assento : assentos) {
            if (assento != null) {
                s=true;
            }
        }
        return s;
    }
    
    //método para verificar se a sala está cheia
    public boolean estaCheia(){
        boolean r = false;
        int cont = 0;
        for (Cliente assento : assentos) {
            if (assento != null) {
                cont++;
            }
        }
        if(cont==tam){
            r=true;
        }
        return r;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public Cliente[] getAssentos() {
        return assentos;
    }

    public void setAssentos(Cliente[] assentos) {
        this.assentos = assentos;
    }

    public String[] getShow() {
        return show;
    }

    public void setShow(String[] show) {
        this.show = show;
    }

}
