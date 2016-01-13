package level;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import entities.DynObstacle;
import entities.FKey;
import entities.Player;
import obstacles.Exit;
import obstacles.StatObstacle;
import obstacles.Wall;

public class MenuKeys {

    private Terminal t;
    public MenuKeys(Terminal t){

        this.t = t;
        this.t.clearScreen();
    }

    public void createMenu(){

        t.applyForegroundColor(FKey.getColorcode());
        MessageManager.printText(t,0,0, FKey.getCharcode()+" = schlüssel");

        t.applyForegroundColor(Player.getColorcode());
        MessageManager.printText(t,0,1, Player.getPlayercode()+" = spieler");

        t.applyForegroundColor(Wall.getColorcode());
        MessageManager.printText(t,0,2, Wall.getCharcode()+" = wand");

        t.applyForegroundColor(Exit.getColorcode());
        MessageManager.printText(t,0,3, Exit.getCharcode()+" = ausgang");

        t.applyForegroundColor(StatObstacle.getColorcode());
        MessageManager.printText(t,0,4, StatObstacle.getCharcode()+" = statischer Gegner");

        t.applyForegroundColor(DynObstacle.COLORCODE);
        MessageManager.printText(t,0,5, DynObstacle.CHARCODE+" = dynamischer Gegner");
        MessageManager.printText(t,0,6, "drücke esc um wieder zum spiel zu kommen");
        leaveKeys(t);
    }

    private void leaveKeys(Terminal t){

        boolean readingIn = true;
        while(readingIn){
            Key key = t.readInput();
            try{

                if(key.getKind() != null){
                    if(key.getKind() == Key.Kind.Escape){
                        readingIn = false;
                    }
                }

            }catch(Exception e){}

        }
    }
}
