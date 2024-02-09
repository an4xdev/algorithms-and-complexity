import java.util.ArrayList;

public class TextSearch {
    private String text;
    private String find;

    private ArrayList<Integer> places;

    public TextSearch(String text, String find) {
        this.text = text;
        this.find = find;
        this.places = new ArrayList<>();
    }

    public void print() {
        if (places.size() > 0) {
            System.out.println("Text: " + find + ", founded on positions:");
            for (int place : places) {
                System.out.println(place);
            }
        } else {
            System.out.println("Text: " + find + ", isn't in text");
        }
    }

    public void search() {
        places.clear();
        for (int i = 0; i < text.length() - find.length() + 1; i++) {
            int j = 0;
            while (j < find.length() && find.charAt(j) == text.charAt(i + j)) {
                j++;
            }
            if (j == find.length())
                places.add(i);
        }
        print();
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFind(String find) {
        this.find = find;
    }

}
