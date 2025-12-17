package io.github.rubenurena.manager.services.Listener;

public abstract class Listenable {
    public  abstract void apply();

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Listenable s)) return false;
        return this.toString().equals(s.toString());
    }
}
