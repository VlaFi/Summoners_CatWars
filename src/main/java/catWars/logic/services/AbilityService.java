package catWars.logic.services;

import catWars.logic.abilities.Ability;
import catWars.logic.abilities.DamageAbility;
import catWars.logic.abilities.HealAbility;

import java.util.*;

public class AbilityService {

    private final Map<String, Ability> abilities = new HashMap<>();

    public AbilityService() {
        registerAbility(new DamageAbility());
        registerAbility(new HealAbility());
    }

    public void registerAbility(Ability ability) {
        abilities.put(ability.getName(), ability);
    }

    public Ability findByName(String name) {
        return abilities.get(name);
    }
}
