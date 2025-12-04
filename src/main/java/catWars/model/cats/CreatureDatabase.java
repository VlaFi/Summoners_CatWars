package catWars.model.cats;

import catWars.logic.abilities.Ability;

import java.util.ArrayList;
import java.util.List;

public class CreatureDatabase {
    private static final List<CreatureTemplate> TEMPLATES = new ArrayList<>();

    public static List<CreatureTemplate> getAllTemplates() {
        return List.copyOf(TEMPLATES);
    }

    public static CreatureTemplate findByName(String name) {
        return TEMPLATES.stream().filter(t -> t.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
