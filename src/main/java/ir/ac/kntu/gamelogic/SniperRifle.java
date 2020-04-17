package ir.ac.kntu.gamelogic;

public class SniperRifle extends Gun {

    private boolean zoom ;
    void addZoom(){
        if ( zoom ){
            setContactRate(getContactRate()+ 5 + (int)(Math.random() * (11)));
        }
    }

    public SniperRifle(int damageRate, int contactRate, Bullet bullet, boolean zoom) {
        super(damageRate, contactRate, bullet);
        this.zoom = zoom;
        addZoom();
    }

    @Override
    public String toString() {
        return "SniperRifle{" +
                "zoom=" + zoom +
                "} " + super.toString();
    }
}
