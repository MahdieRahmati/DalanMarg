package ir.ac.kntu.gamelogic;

import java.util.ArrayList;

public class HandleGame {

    static Gun randomGun (){
        Gun [] gun = {
                new SniperRifle(20 , 60 , Bullet.CALIBER5 , true),
                new SniperRifle(20 , 60 , Bullet.CALIBER5 , false),
                new AssaultRifle(10 , 50 , Bullet.CALIBER5),
                new SniperRifle(20 , 60 , Bullet.CALIBER7 , true),
                new SniperRifle(20 , 60 , Bullet.CALIBER7 , false),
                new AssaultRifle(10 , 50 , Bullet.CALIBER7),
        };

        return gun[RandomHelper.nextInt(6)] ;
    }


    public static ArrayList<Soldier> randomGroup(int length){
        ArrayList<Soldier> group = new ArrayList<>() ;
        for ( int i =0 ; i < length ; i++ ){
            Soldier soldier = new Soldier("S"+i , 50 , randomGun());
            group.add(soldier);
        }

        return group ;
    }

    static Soldier randomSoldier(ArrayList<Soldier> group ){
        return group.get(RandomHelper.nextInt(group.size()));
    }


    static void print ( ArrayList<Soldier> soldiers){
        for ( Soldier soldier : soldiers ){
            System.out.println(soldier);
        }

    }

    static void battle( Soldier attacker , Soldier defeater , ArrayList<Soldier>defeaters , ArrayList<Soldier> dead ){
        if (Soldier.gunshot(attacker)) {
            defeater.setChance(defeater.getChance() - attacker.getGun().getDamageRate());
            if (defeater.getChance() <= 0) {
                dead.add(defeater);
                defeaters.remove(defeater);
            }
        }
    }


    public static void game(ArrayList<Soldier> gp1, ArrayList<Soldier> gp2, ArrayList<Soldier> dead){
        int i = 1 ;
        while ( true ) {
            Soldier soldier1 = randomSoldier(gp1);
            Soldier soldier2 = randomSoldier(gp2);
            System.out.println("################ROUND"+i+"####################");
            System.out.println("The chosen soldiers from both groups :");
            System.out.println(soldier1);
            System.out.println(soldier2);
            System.out.println("--------------------------------------------------------------------");
            int random = RandomHelper.nextInt(2);
            if (random == 1) {
                System.out.println("The starter is the first group !");
                battle(soldier1, soldier2, gp2, dead);
                if (soldier2.getChance() > 0) {
                    battle(soldier2, soldier1, gp1, dead);
                }
            } else {
                System.out.println("The starter is the second  group !");
                battle(soldier2, soldier1, gp1, dead);
                if (soldier1.getChance() > 0) {
                    battle(soldier1, soldier2, gp2, dead);
                }
            }

            if ( gp1.size()==0){
                System.out.println("THE SECOND GROUP WON !");
                System.out.println("the killed soldiers :");
                print(dead);
                System.out.println("the survivors");
                print(gp2);
                break ;
            }else if (  gp2.size()==0){
                System.out.println("THE FIRST GROUP WON !");
                System.out.println("the killed soldiers :");
                print(dead);
                System.out.println("the survivors");
                print(gp1);
                break ;
            }

            print(gp1);
            System.out.println();
            print(gp2);
            System.out.println();
            i++;

        }
}

}

