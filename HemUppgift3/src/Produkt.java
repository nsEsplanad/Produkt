

//  Serialization implementation.

public class Produkt implements java.io.Serializable {

    private int produkt_id;
    private String produkt_name;
    private int  antal;
    private int  pris;

    public Produkt(int produkt_id, String produkt_name, int antal, int pris) {
        this.produkt_id = produkt_id;
        this.produkt_name = produkt_name;
        this.antal = antal;
        this.pris = pris;
    }

    public int getProdukt_id() {
        return produkt_id;
    }

    public void setProdukt_id(int produkt_id) {
        this.produkt_id = produkt_id;
    }

    public String getProdukt_name() {
        return produkt_name;
    }

    public void setProdukt_name(String produkt_name) {
        this.produkt_name = produkt_name;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "produkt_id=" + produkt_id +
                ", produkt_name='" + produkt_name + '\'' +
                ", antal=" + antal +
                ", pris=" + pris +
                '}';
    }
}
