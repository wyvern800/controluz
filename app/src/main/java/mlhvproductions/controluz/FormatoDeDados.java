package mlhvproductions.controluz;

public class FormatoDeDados {
    String exemplo;
    String dataEHora;


    public FormatoDeDados(String exemplo, String dataEHora) {
        this.exemplo = exemplo;
        this.dataEHora = dataEHora;
    }

    public String getExemplo() {
        return exemplo;
    }

    public void setExemplo(String exemplo) {
        this.exemplo = exemplo;
    }

    public String getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(String dataEHora) {
        this.dataEHora = dataEHora;
    }

    @Override
    public String toString() {
        return "FormatoDeDados{" +
                "exemplo='" + exemplo + '\'' +
                ", dataEHora='" + dataEHora + '\'' +
                '}';
    }
}
