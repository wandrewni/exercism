/**
 * Created by anicholson on 5/14/17.
 */
public class Matrix {
    private int rowsCount;
    private int columnsCount;
    private int[][] matrix;


    public Matrix(String matrixAsString) {
        final String[] rows = matrixAsString.split("\n");
        this.rowsCount = rows.length;
        this.matrix = new int[rows.length][rows[0].split(" ").length];
        for (int i = 0; i < rows.length; i++) {
        final String[] columns = rows[i].split(" ");
            for (int j = 0; j < columns.length; j++) {
                this.matrix[i][j] = Integer.valueOf(columns[j]);
            }
        }
        this.columnsCount = this.matrix[0].length;
    }

    public int getRowsCount() {
        return rowsCount;
    }

    public int getColumnsCount() {
        return columnsCount;
    }

    public int[] getRow(int row) {
        return matrix[row];
    }

    public int[] getColumn(int col) {
        int[] column = new int[rowsCount];
        for (int i = 0; i < column.length; i++) {
            column[i] = matrix[i][col];
        }
        return column;
    }
}
