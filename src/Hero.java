public class Hero {
    String name;
    int hitPoints;

    public Hero (String n) {
        name = n;
        hitPoints = 100;
    }

    public String getName() {
        return name;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    @Override
    public String toString() {
        return "Hero{name='"+name+"', hitPoints=" + hitPoints + "}";
    }
    public void senzuBean() {
        hitPoints = 100;
    }

    void attack (Hero opp) {
        if (Math.random()<0.5) {
            opp.hitPoints = opp.hitPoints-10;
        }
        else hitPoints = hitPoints -10;
    }
    private void fightUntilTheDeathHelper(Hero opp) {
        for (int i = 20; i >0; i--) {
            attack(opp);
            if (hitPoints >= opp.getHitPoints()) {
                i = opp.getHitPoints();
            }
            else i = hitPoints;
        }
    }
    public String fightUntilTheDeath(Hero opp) {
        fightUntilTheDeathHelper(opp);
        String oppname = opp.getName();
        int oppHP = opp.getHitPoints();
        return name + ": " + hitPoints + " "+oppname+": "+oppHP;
    }
    private int[] nFightsToTheDeathHelper(Hero opp, int n) {
        int[] wl = new int[2];
        int wins = 0;
        for (int num=n; num>0; num--) {
            for (int i = 20; i >0; i--) {
                attack(opp);
                if (hitPoints >= opp.getHitPoints()) {
                    i = opp.getHitPoints();
                }
                else i = hitPoints;
            }
            if (hitPoints!=0) {
                 wins++;
            }
            opp.senzuBean();
            hitPoints = 100;
        }
        wl[0] = wins;
        wl[1] = n-wins;
        return wl;
    }
    public String nFightsToTheDeath(Hero opp, int n) {
        String oppname = opp.getName();
        int[] w = nFightsToTheDeathHelper(opp, n);
        if (w[0] == n/2) {
            return (name+": " + w[0] + " wins\n" + oppname+": "+w[1] +" wins\n" + "OMG! It was actually a draw!");
        }
        else if (w[0]< n/2) return (name+": " + w[0] + " wins\n" + oppname+": "+w[1] +" wins\n" + oppname +" wins!");
        else return (name+": " + w[0] + " wins\n" + oppname+": "+w[1] +" wins\n" + name +" wins!");
    }
    public void dramaticFightToTheDeath(Hero opp) {
        String oppname = opp.getName();
        int oppHP = opp.getHitPoints();
        for (int i = 20; i >0; i--) {
            attack(opp);
            if (hitPoints >= opp.getHitPoints()) {
                i = opp.getHitPoints();
            }
            else i = hitPoints;
            System.out.println(name + ": " + hitPoints + " "+oppname+": "+oppHP);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (oppHP>hitPoints) {
            System.out.println(oppname + " wins!");
        }
        else System.out.println(name + " wins!");
    }

}
