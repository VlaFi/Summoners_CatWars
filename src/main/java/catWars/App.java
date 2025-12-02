package catWars;

import catWars.*;
import catWars.db.CreatureTemplateDao;
import catWars.model.cats.Creature;
import catWars.logic.battle.BattleEngine;
import catWars.model.cats.CreatureTemplate;
import catWars.model.runes.Rune;

public class App {
    public static void main(String[] args) {
        CreatureTemplateDao dao = new CreatureTemplateDao();
        CreatureTemplate template = dao.getAll().get(0);

        Creature player = new Creature(
                template.getName(),
                template.getBaseHp(),
                template.getBaseAtk(),
                template.getBaseDef(),
                template.getBaseSpeed()
        );

        Creature enemy = new Creature("КотИзКафе", 100, 20, 15, 15);

//        player.addAbility(new BasicAttack());
//        player.addAbility(new ToyAttack());
//        enemy.addAbility(new BasicAttack());
//        enemy.addAbility(new FurballAttack());

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