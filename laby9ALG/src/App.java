
public class App {
    public static void main(String[] args) throws Exception {
        BST<Integer> bst = new BST<Integer>(8);
        bst.addBSTRec(10);
        bst.addBSTRec(3);
        bst.addBSTRec(14);
        bst.addBSTRec(13);
        bst.addBSTRec(6);
        bst.addBSTRec(1);
        bst.addBSTRec(4);
        bst.addBSTRec(7);
        System.out.println("BST:");
        bst.print(0);
        System.out.println();
        int find = 1;
        Pair<BST<Integer>, BST<Integer>> pair = bst.searchBST(find);
        if (pair.second != null) {
            if (pair.first != null) {
                System.out.println("Poprzednik elementu " + find + ": " + pair.first.dane);
            } else {
                System.out.println("Poprzednik elementu " + find + ": nie istnieje");
            }

            System.out.println("Element " + find + ": " + pair.second.dane);

        } else {
            System.out.println("Element " + find + ": nie występuje w drzewie");
        }

        System.out.println(
                "Element " + find + ": " + (bst.searchBSTRec(find) ? "jest w drzewie" : "nie ma go w drzewie"));

        int in = 9;
        bst.insertBTS(in);
        System.out.println("BST after inserted " + in + ":");
        bst.print(0);
        int del = 6;
        bst.deleteBST(del);
        System.out.println("BSF after delete " + del + ":");
        bst.print(0);
    }
}
