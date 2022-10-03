package S03T01N01AlbertMartin;

import java.util.ArrayList;
import java.util.List;

public class Comand{

    private List comands = null;

   // public Comand(String s) {
   // }

    public List getComands () {
        comands = new ArrayList();
        Comand c1 = new Comand("Action 1");
        Comand c2 = new Comand("Action 2");
        Comand c3 = new Comand("Action 3");

        comands.add(c1);
        comands.add(c2);
        comands.add(c3);
        
        return  comands;
    }


}
