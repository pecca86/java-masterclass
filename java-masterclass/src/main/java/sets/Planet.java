package sets;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Planet {
    private final String name;
    private final double orbitalPeriod;
    private final Set<Planet> satellites;

    public Planet(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<Planet> getSatellites() {
        // Returning a new hashset, so the user can't modify the object's own, for security reasons
        return new HashSet<>(this.satellites);
    }

    public boolean addMoon(Planet planet) {
        return this.satellites.add(planet);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Double.compare(planet.getOrbitalPeriod(), this.getOrbitalPeriod()) == 0 && this.getName().equals(planet.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, orbitalPeriod);
    }
}
