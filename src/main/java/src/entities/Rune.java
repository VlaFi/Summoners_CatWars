package src.entities;

public class Rune {
    public enum Type {
        HP, DEFENSE, ATTACK, SPEED
    }

    private final Type type;

    public Rune(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}