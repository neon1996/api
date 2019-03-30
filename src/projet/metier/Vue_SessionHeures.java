package projet.metier;

public class Vue_SessionHeures {

    protected int idsesscours;
    protected int totalHeures;

    public Vue_SessionHeures() {
    }

    public Vue_SessionHeures(int idsesscours, int totalHeures) {
        this.idsesscours = idsesscours;
        this.totalHeures = totalHeures;
    }

    public int getIdsesscours() {
        return idsesscours;
    }

    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
    }

    public int getTotalHeures() {
        return totalHeures;
    }

    public void setTotalHeures(int totalHeures) {
        this.totalHeures = totalHeures;
    }

    @Override
    public String toString() {
        return "Vue_SessionHeures{" + "idsesscours=" + idsesscours + ", totalHeures=" + totalHeures + '}';
    }

}
