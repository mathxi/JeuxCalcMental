package bo;

public class Equation {
    private String equation;
    private String trueEquation;


    public String getTrueEquation() {
        return trueEquation;
    }

    public void setTrueEquation(String trueEquation) {
        this.trueEquation = trueEquation;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public Equation() {
    }

    public Equation(String equation, String trueEquation) {
        this.equation = equation;
        this.trueEquation = trueEquation;
    }
}
