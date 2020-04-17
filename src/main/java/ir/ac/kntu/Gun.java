package ir.ac.kntu;

public class Gun {
    private int damageRate ;
    private int contactRate ;
    private Bullet bullet ;

    public Gun(int damageRate, int contactRate, Bullet bullet) {
        this.damageRate = damageRate;
        this.contactRate = contactRate;
        this.bullet = bullet;
        bullet();
    }

    public int getDamageRate() {
        return damageRate;
    }

    public int getContactRate() {
        return contactRate;
    }

    public void setContactRate(int contactRate) {
        this.contactRate = contactRate;
    }

    void bullet (){
        if ( bullet == Bullet.CALIBER7){
            damageRate = damageRate+10 ;
            contactRate = contactRate-10;
        }else{
            contactRate = contactRate+15 ;
        }
    }

    @Override
    public String toString() {
        return "Gun{" +
                "damageRate=" + damageRate +
                ", contactRate=" + contactRate +
                ", bullet=" + bullet +
                '}';
    }
}
