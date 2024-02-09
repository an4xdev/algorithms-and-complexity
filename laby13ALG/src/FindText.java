import java.util.ArrayList;
import java.util.HashMap;

public class FindText {

    private String template;
    private String text;

    private int n;
    private int m;

    int[] tab;

    private HashMap<Character, Integer> map;

    public void setTemplate(String template) {
        this.template = template;
        m = this.template.length();
    }

    public void setText(String text) {
        this.text = text;
        n = this.text.length();
    }

    public boolean isEasy() {

        for (int i = 1; i < (template.length() / 3) + 1; i++) {
            String pre = "";
            for (int j = 0; j < 3; j++) {
                pre += template.substring(0, i);
            }
            if (template.startsWith(pre)) {
                return false;
            }
        }

        return true;
    }

    public void GS() {
        int i = 0;
        int j = 0;
        while (i <= n - m) {
            j = 0;
            while (j < template.length() && template.charAt(j) == text.charAt(i + j)) {
                j++;
            }
            if (j == m)
                System.out.print(i + ", ");
            i += Math.max(1, (j / 3));
        }
        System.out.println();
    }

    public void setTableKMP() {
        tab = new int[template.length() + 1];
        tab[0] = 0;
        tab[1] = 0;
        int t = 0;
        for (int j = 2; j < m; j++) {
            t = tab[j - 1];
            while (t > 0 && template.charAt(t) != template.charAt(j)) {
                t = tab[t];
            }
            if (template.charAt(t) == template.charAt(j)) {
                t++;
            }
            tab[j] = t;
        }

        System.out.println("KMP tablica:");
        for (int i = 0; i < tab.length; i++) {
            System.out.println(i + ": " + tab[i]);
        }
        System.out.println();
    }

    public void KMP() {
        int i = 0, j = 0;
        setTableKMP();
        System.out.println("Indeksy w tekście:");
        while (i <= n - m) {
            j = tab[j];
            while (j < template.length() && template.charAt(j) == text.charAt(i + j)) {
                j++;
            }
            if (j == m) {
                System.out.print(i + ", ");
            }
            i += Math.max(1, j - tab[j]);
        }
    }

    public void BM() {
        setTableBM();
        int i = 0, j = 0;
        while (i <= n - m) {
            j = m - 1;
            while (j >= 0 && template.charAt(j) == text.charAt(i + j)) {
                j--;
            }
            if (j == -1) {
                System.out.print(i + ", ");
            }
            i += Math.max(1, j - map.get(text.charAt(i + j)));
        }
    }

    private void setTableBM() {
        var characters = new ArrayList<Character>();

        for (int i = 0; i < text.length(); i++) {
            if (!characters.contains(text.charAt(i))) {
                characters.add(text.charAt(i));
            }
        }

        map = new HashMap<Character, Integer>();

        for (int i = 0; i < characters.size(); i++) {
            map.put(characters.get(i), -1);
        }

        for (int i = 0; i < template.length(); i++) {
            map.replace(template.charAt(i), i);
        }

        // System.out.println(map);

    }
}
