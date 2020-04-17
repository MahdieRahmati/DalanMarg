package ir.ac.kntu;

public class AssaultRifle extends Gun {
    public AssaultRifle(int damageRate, int contactRate, Bullet bullet) {
        super(damageRate, contactRate, bullet);
    }

    @Override
    public String toString() {
        return "AssaultRifle{} " + super.toString();
    }
}
