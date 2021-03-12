package com.ncr.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

	private Pawn[][] pieces;

    public ChessBoard() {
    	
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

	public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
		if (null != pawn && null != pieceColor) {
			if (checkForValues(xCoordinate, yCoordinate, pieceColor)) {
				if (isLegalBoardPosition(xCoordinate, yCoordinate)) {
							pawn.setXCoordinate(xCoordinate);
							pawn.setYCoordinate(yCoordinate);
							pieces[xCoordinate][yCoordinate] = pawn;					
				}else {
					pawn.setXCoordinate(-1);
					pawn.setYCoordinate(-1);
				}
			}else {
				pawn.setXCoordinate(-1);
				pawn.setYCoordinate(-1);
			}
		} 
	}

	private boolean checkForValues(int xCoordinate, int yCoordinate, PieceColor pieceColor) {

        for(int i = 0; i < pieces.length; i++){
            for(int j = 0; j < pieces.length; j++){
                if(null != pieces[i][j] && pieces[i][j].getPieceColor().equals(pieceColor) && pieces[i][j].getXCoordinate() == xCoordinate && pieces[i][j].getYCoordinate() == yCoordinate)
                	return false;
            }
        }
    
		return true;
	}
    
    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
    	if((xCoordinate >= 0 && xCoordinate <= 6) && (yCoordinate >=0 && yCoordinate <= 6)) {
    		return true;
    	}else {
    		return false;
    	}
    }

}
