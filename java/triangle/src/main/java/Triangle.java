/**
 * Created by anicholson on 5/23/17.
 */
public class Triangle {
    private TriangleKind kind;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) throws TriangleException {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        if (anySideIs0orNegative()||violatesTriangleInequality())
            throw new TriangleException();
        this.kind = calculateKind();
    }

    private boolean anySideIs0orNegative() {
        return sideA <= 0 || sideB <= 0 || sideC <= 0;
    }
    private boolean violatesTriangleInequality() {
        return sideA + sideB <= sideC ||
            sideA + sideC <= sideB ||
            sideB + sideC <= sideA;
    }

    private TriangleKind calculateKind() {
        TriangleKind kind;
        if (allSidesAreEqual()) {
            kind = TriangleKind.EQUILATERAL;
        } else if (twoSidesAreEqual()) {
            kind = TriangleKind.ISOSCELES;
        } else {
            kind = TriangleKind.SCALENE;
        }
        return kind;
    }

    private boolean allSidesAreEqual() {
        return sideA == sideB && sideB == sideC;
    }

    private boolean twoSidesAreEqual() {
        return sideB == sideC && sideA != sideB ||
                sideA == sideC && sideB != sideC ||
                sideA == sideB && sideA != sideC;
    }

    public TriangleKind getKind() {
        return kind;
    }
}
