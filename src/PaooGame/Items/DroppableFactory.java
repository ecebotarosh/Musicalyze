package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Settings.Difficulty;

import java.util.Random;

public class DroppableFactory {
    private double bombRange;
    private final double bonusRange=0.2;
    private double decision;
    private String type;


    public Droppable generate(RefLinks reflink, Random randomizer, Difficulty difficulty)
    {
        switch(difficulty)
        {
            case EASY:
                bombRange=0.05;
                break;
            case MEDIUM:
                bombRange=0.1;
                break;
            case HARD:
                bombRange=0.15;
                break;
        }

        decision = randomizer.nextDouble();

        if(decision<=bombRange)
        {
            type="Bomb";
        }
        else if(decision>bombRange && decision <=bonusRange)
        {
            type="Bonus";
        }
        else
        {
            type=Assets.possiblePayloads.get(randomizer.nextInt(Assets.possiblePayloads.size()));
        }


        switch(type)
        {
            case "Do":
            case "Re":
            case "Mi":
            case "Fa":
            case "Sol":
            case "La":
            case "Si":
                return new Droppable(reflink, type);
            case "Bomb":
                return new Bomb(reflink);
            case "Bonus":
                return new Bonus(reflink);
            default:
                return null;
        }
    }
}
