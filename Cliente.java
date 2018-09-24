
public class Cliente {
    private String nome;
    private String telefone;
    private String id;
    private int cadeira;

    public Cliente(String nome, String telefone, String id, int cadeira) {
        this.nome = nome;
        this.telefone = telefone;
        this.id = id;
        this.cadeira = cadeira;
    }

    Cliente() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCadeira() {
        return cadeira;
    }

    public void setCadeira(int cadeira) {
        this.cadeira = cadeira;
    }
    
   
    public String toString(){
        String s = nome;
        return s;
    }    
}
