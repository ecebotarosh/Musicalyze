package PaooGame.Items;

import PaooGame.RefLinks;

public class DroppableFactory {
    public Droppable generate(RefLinks reflink, String type)
    {
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
