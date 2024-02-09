/**
 * Element generycznej listy jednokierunkowej.
 * 
 * @param <T> typ elementow przechowywanych w liscie
 */
public class ElemOne<T extends Comparable<T>> {
    private T data;
    private ElemOne<T> next;

    public ElemOne(T data) {
        this.data = data;
    }

    public ElemOne(T data, ElemOne<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ElemOne<T> getNext() {
        return next;
    }

    public void setNext(ElemOne<T> next) {
        this.next = next;
    }

}
