package src.entities;

import src.abilities.Ability;
import src.abilities.BaseAttack;
import src.abilities.FurballAttack;
import src.abilities.ToyAttack;

import java.util.ArrayList;
import java.util.List;

public class CreatureDatabase {
    private static final List<CreatureTemplate> TEMPLATES = new ArrayList<>();

    static {
        TEMPLATES.add(new CreatureTemplate("КотВлафи", 3, 120, 25, 10, 18, new Ability[]{ new BaseAttack(), new FurballAttack(), new ToyAttack()}));
        TEMPLATES.add(new CreatureTemplate("КотИзКафе", 2, 100, 20, 15, 15, new Ability[]{ new FurballAttack(), new FurballAttack(), null}));
        TEMPLATES.add(new CreatureTemplate("КотПират", 3, 110, 28, 8, 17, new Ability[]{ new BaseAttack(), new ToyAttack(), null}));
        TEMPLATES.add(new CreatureTemplate("КотМурзик", 2, 90, 18, 12, 14, new Ability[]{ new BaseAttack(), new FurballAttack(), null}));
        TEMPLATES.add(new CreatureTemplate("КотБотан", 3, 105, 22, 9, 13, new Ability[]{ new BaseAttack(),  new ToyAttack(), null}));
        TEMPLATES.add(new CreatureTemplate("КотНиндзя", 4, 95, 24, 7, 20, new Ability[]{ new BaseAttack(), new FurballAttack(), null}));
        TEMPLATES.add(new CreatureTemplate("КотРыцарь", 4, 130, 21, 18, 10, new Ability[]{ new BaseAttack(), new ToyAttack(), null}));
        TEMPLATES.add(new CreatureTemplate("КотСказ", 5, 85, 30, 5, 16, new Ability[]{ new BaseAttack(), new FurballAttack(), null}));
        TEMPLATES.add(new CreatureTemplate("КотПух", 2, 140, 16, 20, 9, new Ability[]{ new BaseAttack(), new ToyAttack(), null}));
    }

    public static List<CreatureTemplate> getAllTemplates() {
        return List.copyOf(TEMPLATES);
    }

    public static CreatureTemplate findByName(String name) {
        return TEMPLATES.stream().filter(t -> t.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
