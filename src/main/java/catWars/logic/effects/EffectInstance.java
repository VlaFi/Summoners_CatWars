package catWars.logic.effects;

public class EffectInstance {
    private final String targetStat;
    private final double value;
    private int remainingTurns;

    public EffectInstance(String targetStat, double value, int duration) {
        this.targetStat = targetStat;
        this.value = value;
        this.remainingTurns = duration;
    }

    public void tick() {
        remainingTurns--;
    }

    public String getTargetStat() {
        return targetStat;
    }

    public double getValue() {
        return value;
    }

    public int getRemainingTurns() {
        return remainingTurns;
    }
}
