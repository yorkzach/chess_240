package chess;

/**
 * This class represents the chessboard in our chess game. It has a 8x8 array of chessPieces.
 */
public class ChessBoardImp implements ChessBoard {


    private ChessPiece[][] chessBoard = new ChessPiece[8][8];

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position A ChessPosition object that represents where to add the piece on board
     * @param piece A ChessPiece object.
     */
    @Override
    public void addPiece(ChessPosition position, ChessPiece piece) {
        var row = position.getRow();
        var column = position.getColumn();
        chessBoard[row][column] = piece;
    }

    /**
     * Removes a chessPiece from the board.
     *
     * @param position position of current piece to be removed.
     */
    public void removePiece(ChessPosition position) {
        var row = position.getRow();
        var column = position.getColumn();
        chessBoard[row][column] = null;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position position of something on board we want returned. May be null
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    @Override
    public ChessPiece getPiece(ChessPosition position) {
        var row = position.getRow();
        var column = position.getColumn();
        return chessBoard[row][column];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    @Override
    public void resetBoard() {
        ChessGame.TeamColor color = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Set up chess.Rook-chess.King
                if ((i == 0) || (i == 7)) {
                    if (i == 0) {
                        color = ChessGame.TeamColor.WHITE;
                    }
                    if (i == 7) {
                        color = ChessGame.TeamColor.BLACK;
                    }
                    if ((j == 0) || (j == 7)) {chessBoard[i][j] = new Rook(color);}
                    if ((j == 1) || (j == 6)) {chessBoard[i][j] = new Knight(color);}
                    if ((j == 2) || (j == 5)) {chessBoard[i][j] = new Bishop(color);}
                    if (j == 3) {chessBoard[i][j] = new Queen(color);}
                    if (j == 4) {chessBoard[i][j] = new King(color);}

                }
                // Set up Pawns
                else if ((i == 1) || (i == 6)) {
                    if (i == 1) {
                        color = ChessGame.TeamColor.WHITE;
                    }
                    if (i == 6) {
                        color = ChessGame.TeamColor.BLACK;
                    }
                    chessBoard[i][j] = new Pawn(color);
                }
                // Set all else to null.
                else {
                    chessBoard[i][j] = null;
                }
            }
        }
    }
}
