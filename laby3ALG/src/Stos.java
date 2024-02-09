public class Stos<T> implements IStos<T> {

    private Element<T> top;

    @Override
    public void push(T i) {
        Element<T> newElement = new Element<T>();
        newElement.dane = i;
        newElement.next = null;
        if (top == null) {
            top = newElement;
        } else {
            newElement.next = top;
            top = newElement;
        }
    }

    @Override
    public T pop() {
        T value = null;
        if (top != null) {
            Element<T> temp = top.next;
            value = top.dane;
            top = temp;
        }
        return value;
    }

    @Override
    public T peek() {
        T value = null;
        if (top != null)
            value = top.dane;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void print(boolean withComa) {
        if (top != null) {
            Element<T> temp = top;
            while (temp != null) {
                if (withComa)
                    System.out.print(temp.dane + ", ");
                else
                    System.out.print(temp.dane);
                temp = temp.next;
            }
        }
    }

    @Override
    public void clear() {
        if (top != null) {
            Element<T> temp = top;
            top = null;
            while (temp != null) {
                top = temp;
                temp = temp.next;
                top = null;
            }
        }
    }

}
