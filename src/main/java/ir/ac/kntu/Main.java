package ir.ac.kntu;

import ir.ac.kntu.gamelogic.HandleGame;
import ir.ac.kntu.gamelogic.Soldier;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Soldier> dead = new ArrayList<>();
        System.out.println("ENTER THE LENGTH : ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        ArrayList<Soldier> firstGroup = HandleGame.randomGroup(length);
        ArrayList<Soldier> secondGroup= HandleGame.randomGroup(length);
        HandleGame.game(firstGroup , secondGroup , dead);
        scanner.close();
    }
}

