import java.util.Random;

/**
 * Class Game is the logic behind the game of life.
 *  The next gen calculations and randomizing a matrix at the start happens here.
 */
public class Game {
    private int[][] _matrix;//the matrix of the game 1-black, 0-white
    private int _size;//the size of the matrix
    private int _gen;//the gen number.

    /**
     * starts a Game object.
     * @param size the size of the matrix (10)
     */
    public Game(int size) {
        _size = size;
        _gen = 0;
        //init matrix to random values;
        _matrix = new int[size][size];
        Random rnd = new Random();
        for(int i = 0; i < _size; i++) {
            for(int j = 0; j < _size; j++) {
                _matrix[i][j] = rnd.nextInt(2);
            }
        }
    }

    /**
     * this func returns the game matrix.
     * @return the game matrix.
     */
    public int[][] getMatrix(){
        return _matrix;
    }

    /**
     * returns the size of the matrix.
     * @return the size of the matrix.
     */
    public int getSize() {
        return _size;
    }

    /**
     * returns the gen number.
     * @return the gen number.
     */
    public int getGen(){ return _gen; }

    /**
     * this function calculating the next gen.
     */
    public void nextGen() {
        _gen+=1;
        int[][] newMat = new int[_size][_size];
        for(int i = 0; i < _size; i++) {
            for(int j = 0; j <_size; j++) {
                int neighbors = neighbors(i, j);
                if(_matrix[i][j] == 0) {
                    if(neighbors == 3) newMat[i][j] = 1;
                    else newMat[i][j] = 0;
                }
                else {
                    if(neighbors<=1 || neighbors >= 4) newMat[i][j] = 0;
                    else newMat[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < _size; i++) {
            for(int j = 0; j < _size; j++) {
                _matrix[i][j] = newMat[i][j];
            }
        }

    }

    /**
     * this function calculates how many living(1) neighbors there are for the cell [i][j] in the matrix.
     * @param i
     * @param j
     * @return how many living neighbors there are for mat[i][j]
     */
    public int neighbors(int i, int j) {
        int no = 0;
        //checks all of the possible situations.
        if(i>0) {
            if(_matrix[i-1][j] == 1) no++;
        }
        if(i<_size-1) {
            if(_matrix[i+1][j] == 1) no++;
        }
        if(j>0) {
            if(_matrix[i][j-1] == 1) no++;
        }
        if(j<_size-1) {
            if(_matrix[i][j+1] == 1) no++;
        }

        if(i > 0 && j > 0) {
            if(_matrix[i-1][j-1] == 1) no++;
        }
        if(i < _size-1 && j < _size-1) {
            if(_matrix[i+1][j+1] == 1) no++;
        }
        if(i > 0 && j < _size-1) {
            if(_matrix[i-1][j+1] == 1) no++;
        }
        if(i < _size-1 && j > 0) {
            if(_matrix[i+1][j-1] == 1) no++;
        }
        return no;
    }
}
