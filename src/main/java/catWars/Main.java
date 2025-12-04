import catWars.db.CreatureTemplateDao;
import catWars.logic.abilities.Ability;
import catWars.model.cats.CreatureInstance;
import catWars.model.cats.CreatureTemplate;

public static void main(String[] args) {
    CreatureTemplateDao dao = new CreatureTemplateDao();

    CreatureTemplate t1 = dao.loadById(1); // CatVlaFi
    CreatureTemplate t2 = dao.loadById(2); // CatStreet

    CreatureInstance c1 = new CreatureInstance(t1);
    CreatureInstance c2 = new CreatureInstance(t2);

    System.out.println("Начинаем бой!");
    System.out.println(c1);
    System.out.println(c2);

    Ability a1 = c1.getAbilities()[0];
    Ability a2 = c2.getAbilities()[0];

    a1.use(c1, c2);
    a2.use(c2, c1);

    System.out.println("После ударов:");
    System.out.println(c1);
    System.out.println(c2);
}
