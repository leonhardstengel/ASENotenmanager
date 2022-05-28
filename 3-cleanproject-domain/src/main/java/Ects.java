public class Ects {
    private final int value;

    Ects(int ects) throws InvalidEctsException {
        if(ects < 1) {
            throw new InvalidEctsException("'"+ects+"' is too low");
        }
        if(ects > 210) {
            throw new InvalidEctsException("'"+ects+"' is too high");
        }
        this.value = ects;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ects ects = (Ects) o;
        return value == ects.value;
    }

    @Override
    public String toString() {
        return ""+this.value;
    }
}
