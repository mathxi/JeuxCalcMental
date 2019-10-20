package bo;

public enum Operator {
    MINUS(2, 1, "-"), PLUS(2, 2, "+"), DIV(2, 4, "/"), MULT(2, 4, "/");

    private int type;
    private int poids;
    private String label;


    Operator(int type, int poids, String label) {
        this.type = type;
        this.poids = poids;
        this.label = label;
    }

    public static Operator valueOfLabel(String s) {

        Operator op = null;
        if ( s != null ) {
            switch (s) {
                case "-" :
                    op = MINUS;
                    break;
                case "+" :
                    op = PLUS;
                    break;
                case "/" :
                    op = DIV;
                    break;
                case "*" :
                    op = MULT;
                    break;
            }
        }
        return op;
    }

    public double eval(double... operands) {

        if ( operands.length != type ) {
            throw new RuntimeException("Erreur d'évaluation");
        }
        double result = 0;
        switch (this) {
            case MINUS:
                result = operands[0] - operands[1];
                break;
            case PLUS:
                result = operands[0] + operands[1];
                break;
            case DIV:
                result = operands[0] / operands[1];
                break;
            case MULT:
                result = operands[0] * operands[1];
                break;


        }
        return result;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
