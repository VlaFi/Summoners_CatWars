package catWars.logic.abilities;

public class AbilityFactory {
    public static Ability create(String type, double power) {
        return switch (type) {
            case "DAMAGE" -> new DamageAbility(power);
            case "HEAL"   -> new HealAbility(power);
            case "BUFF"   -> new BuffAbility(power);
            case "DEBUFF" -> new DebuffAbility(power);
            default -> throw new IllegalArgumentException("Unknown ability type: " + type);
        };
    }
}
