public class CatchedCoins {
    private float brl;
    private float usd;
    private float eur;

    public CatchedCoins(UsableData data){
        this.brl = Float.parseFloat(data.brl());
        this.usd = Float.parseFloat(data.usd());
        this.eur = Float.parseFloat(data.eur());
    }
    public CatchedCoins () {

    }

    public float getBrl() {
        return brl;
    }

    public float getUsd() {
        return usd;
    }

    public float getEur() {
        return eur;
    }

    @Override
    public String toString() {
        return "Real: R$ "+brl+" | Dólar: U$ "+usd+" | Euro: EU "+eur;
    }
}
