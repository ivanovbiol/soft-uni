public class Cell {
    private int row;
    private int col;
    private long value;
    private boolean isEvilPath;

    public Cell(int row, int col, long value) {
        this.setRow(row);
        this.setCol(col);
        this.setValue(value);
        this.setIsEvilPath(false);
    }

    // Getters
    private int getRow() {
        return this.row;
    }
    private int getCol() {
        return this.col;
    }
    public long getValue() {
        return this.value;
    }
    public boolean getIsEvilPath() {
        return this.isEvilPath;
    }

    // Setters
    private void setRow(int row) {
        this.row = row;
    }
    private void setCol(int col) {
        this.col = col;
    }
    private void setValue(long value) {
        this.value = value;
    }
    public void setIsEvilPath(boolean isEvilPath) {
        this.isEvilPath = isEvilPath;
    }
}
