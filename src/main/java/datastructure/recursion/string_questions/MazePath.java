package datastructure.recursion.string_questions;

public class MazePath {
    public static void main(String[] args) {
        path(0, 0, 2, 2, "");
    }

    private static void path(int currentRow, int currentColumn,
                             int destinationRow, int destinationColumn,
                             String result) {

        if(currentRow > destinationRow || currentColumn > destinationColumn)
            return;

        if(currentRow == destinationRow && currentColumn == destinationColumn) {
            System.out.println(result);
            return;
        }

        path(currentRow, currentColumn+1, destinationRow, destinationColumn, result+"H");
        path(currentRow+1, currentColumn, destinationRow, destinationColumn, result+"V");
        path(currentRow+1, currentColumn+1, destinationRow, destinationColumn, result+"D");
    }
}
