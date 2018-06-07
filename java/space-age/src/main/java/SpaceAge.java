/**
 * Created by anicholson on 5/11/17.
 */
public class SpaceAge {
    public static final double EARTH_ORBITAL_PERIOD = 31557600.00;
    private long seconds;
    public SpaceAge(long seconds) {
        this.seconds = seconds;
    }

    public long getSeconds() {
        return seconds;
    }

    public double onEarth() {
        return seconds / EARTH_ORBITAL_PERIOD;
    }

    public double onMercury() {
        return seconds / (EARTH_ORBITAL_PERIOD * 0.2408467);
    }

    public double onVenus() {
        return seconds / (EARTH_ORBITAL_PERIOD * 0.61519726);
    }

    public double onMars() {
        return seconds / (EARTH_ORBITAL_PERIOD * 1.8808158);
    }

    public double onJupiter() {
        return seconds / (EARTH_ORBITAL_PERIOD * 11.862615);
    }

    public double onSaturn() {
        return seconds / (EARTH_ORBITAL_PERIOD * 29.447498);
    }

    public double onUranus() {
        return seconds / (EARTH_ORBITAL_PERIOD * 84.016846);
    }

    public double onNeptune() {
        return seconds / (EARTH_ORBITAL_PERIOD * 164.79132);
    }
}
