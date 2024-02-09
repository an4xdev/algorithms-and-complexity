/**
 * Element generycznej listy jednokierunkowej.
 * 
 * @param <T> typ elementow przechowywanych w liscie
 */
public class ElemTwo<T> {
    private T data;
    private ElemTwo<T> next;
    private ElemTwo<T> prev;

    public ElemTwo(T data) {
        this.data = data;
    }

    public ElemTwo(T data, ElemTwo<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ElemTwo<T> getNext() {
        return next;
    }

    public void setNext(ElemTwo<T> next) {
        this.next = next;
    }

    public ElemTwo<T> getPrev() {
        return prev;
    }

    public void setPrev(ElemTwo<T> prev) {
        this.prev = prev;
    }

}
