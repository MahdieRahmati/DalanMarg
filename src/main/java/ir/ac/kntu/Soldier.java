package ir.ac.kntu;

public class Soldier {
    protected String name ;
    protected int chance ;
    protected Gun gun ;

    public Gun getGun() {
        return gun;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public Soldier(String name, int chance, Gun gun) {
        this.name = name;
        this.chance = chance;
        this.gun = gun;
    }


    static boolean gunshot(Soldier solider ){
        return RandomHelper.nextInt(100) < solider.gun.getContactRate();
    }

    @Override
    public String toString() {
        return "Solider{" +
                "name='" + name + '\'' +
                ", chance=" + chance +
                ", gun=" + gun +
                '}';
    }
}
