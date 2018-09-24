


public class Sala {
    private int tam;
    private String id;
    private Cliente assentos[];
    private String show[] = new String[tam];



    public void estado(){
        for(int i = 0; i<tam;i++){
            if (show[i]==null){
                show[i] = "-   ";
            }
        }
        for(String a: show){
            System.out.print(a);
        }
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
