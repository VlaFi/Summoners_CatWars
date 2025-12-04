package catWars;

import catWars.db.CreatureTemplateDao;
import catWars.logic.battle.BattleEngine;
import catWars.logic.services.CreatureFactory;
import catWars.model.cats.CreatureInstance;

public class App {
    public static void main(String[] args) {
        CreatureTemplateDao dao = new CreatureTemplateDao();
        CreatureFactory factory = new CreatureFactory(dao);

        CreatureInstance c1 = factory.createInstanceFromTemplateName("CatVlaFi");
        CreatureInstance c2 = factory.createInstanceFromTemplateName("CatStreet");

        if (c1 == null || c2 == null) {
            System.out.println("Ошибка загрузки шаблонов из БД. Проверь названия в таблице creature_templates.");
            return;
        }

        BattleEngine engine = new BattleEngine(c1, c2);
        engine.start();
    }
}
