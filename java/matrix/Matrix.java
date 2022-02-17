
class Matrix {

	int[][] matrix = null;

	Matrix(String matrixAsString) {
		int rowCount = (int) matrixAsString.chars().filter(ch -> ch == '\n').count();
		String[] allRows = matrixAsString.split("[\\n]");
		int columnCount = (int) allRows[0].chars().filter(ch -> Character.isWhitespace(ch)).count();
		matrix = new int[++rowCount][++columnCount];
		int i = 0, j = 0;
		for (String row : allRows) {
			String[] allCols = row.split("[\\s]");
			for (String s : allCols) {
				matrix[i][j] = Integer.valueOf(s);
				j++;
			}
			i++;
			j = 0;
		}
	}

	int[] getRow(int rowNumber) {
		return matrix[--rowNumber];
	}

	int[] getColumn(int columnNumber) {
		int[] col = new int[matrix.length];
		for(int i=0; i<matrix.length; i++) {
			col[i] = matrix[i][columnNumber-1];
		}
		return col;
	}

}

