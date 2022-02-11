import java.util.*;
public class PythagoreanTriplet {
    private int a, b, c;
    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PythagoreanTriplet that = (PythagoreanTriplet) o;
        if (a != that.a) return false;
        if (b != that.b) return false;
        return c == that.c;
    }
    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }
    public static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTripletBuilder();
    }
}
class PythagoreanTripletBuilder {
    private int bound;
    private int sum;
    public PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int bound) {
        this.bound = bound;
        return this;
    }
    public PythagoreanTripletBuilder thatSumTo(int sum) {
        this.sum = sum;
        return this;
    }
    public List<PythagoreanTriplet> build() {
        List<PythagoreanTriplet> results = new ArrayList<>();
        for (int a = 3; a <= bound; a++) {
            for (int b = a; b <= bound; b++) {
                int c = sum - a - b;
                if (a * a + b * b == c * c) {
                    results.add(new PythagoreanTriplet(a, b, c));
                }
            }
        }
        return results;
    }
}