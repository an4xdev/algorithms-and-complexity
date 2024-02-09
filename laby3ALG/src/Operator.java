public class Operator {
    public int priority;
    public char element;

    public Operator(int priority, char element) {
        this.priority = priority;
        this.element = element;
    }

    @Override
    public String toString() {
        return element + " ";
    }

}
