package src;

import src.abilities.FurballAttack;
import src.abilities.ToyAttack;
import src.entities.Creature;
import src.entities.BasicAttack;
import src.battle.BattleEngine;
import src.entities.Rune;

public class Main {
    public static void main(String[] args) {
        Creature player = new Creature("КотВлафи", 120, 25, 10, 18);
        Creature enemy = new Creature("КотИзКафе", 100, 20, 15, 15);

        player.addAbility(new BasicAttack());
        player.addAbility(new ToyAttack());
        enemy.addAbility(new BasicAttack());
        enemy.addAbility(new FurballAttack());

        player.addRune(new Rune(Rune.Type.ATTACK));
        player.addRune(new Rune(Rune.Type.ATTACK));
        player.addRune(new Rune(Rune.Type.ATTACK));
        player.addRune(new Rune(Rune.Type.ATTACK));
        player.addRune(new Rune(Rune.Type.HP));
        player.addRune(new Rune(Rune.Type.HP));

        BattleEngine battle = new BattleEngine(player, enemy);
        battle.start();
    }
}