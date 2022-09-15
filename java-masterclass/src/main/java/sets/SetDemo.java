package sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetDemo {
    private static Map<String, Planet> solarSystem = new HashMap<>();
    private static Set<Planet> planets = new HashSet<>();

    public static void main(String[] args) {

        Planet temp = new Planet("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Mars", 280);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        Planet moon = new Planet("Moon", 27);
        solarSystem.put(moon.getName(), moon);
        temp.addMoon(moon);

        moon = new Planet("Titan", 27);
        solarSystem.put(moon.getName(), moon);
        temp.addMoon(moon);

        System.out.println(planets);
        for (Planet planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        Planet planet = solarSystem.get("Venus");
        System.out.println("Moons of " + planet.getName());
        for (Planet p : planet.getSatellites()) {
            System.out.println("\t" + p.getName());
        }

        Set<Planet> moons = new HashSet<>();
        for (Planet p : planets) {
            moons.addAll(p.getSatellites());
        }

        System.out.println("All moons");
        for (Planet p : moons) {
            System.out.println("\t" + p.getName());
        }

        // Create an intersection demo
        Set<Integer> sqr = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();
        for (int i = 1; i <= 100; i++) {
            sqr.add(i*i);
            cubes.add(i*i*i);
        }
        System.out.println("Cubes: " + cubes.size() + ", squares: " + sqr.size());
        Set<Integer> intersection = new HashSet<>(sqr);
        intersection.retainAll(cubes);
        System.out.println(intersection.size());

    }
}
