package cn.edu.sysu.jood.core.chessmen;

import java.util.List;
import java.util.ArrayList;

import cn.edu.sysu.jood.core.Chessboard;
import cn.edu.sysu.jood.core.Chessman;
import cn.edu.sysu.jood.core.Position;

public class Queen extends Chessman {
    @Override
    public boolean canGo(Position to) {
    	Position cur = super.getPosition();
		int col = cur.getCol();
		int row = cur.getRow();
        if(to.col > to.COL || to.col < 1 || to.row > to.ROW || to.row < 1 || (to.col == col && to.row == row)){return false;}
        return to.col == col || to.row == row || Math.abs(to.col - col) == Math.abs(to.row - row);
    }

    @Override
    public Status status() {
        return Status.Queen;
    }

    @Override
    public List<Position> path(Position to) {
    	Position cur = super.getPosition();
		int col = cur.getCol();
		int row = cur.getRow();
        List<Position> thePath = new ArrayList<Position>();
        if(!canGo(to)){return thePath;}
        if(to.col == col){
            if(to.row > row){
                for(int i = row + 1;i < to.row;i++){thePath.add(new Position(i, col));}
            }
            else{
                for(int i = row - 1;i > to.row;i--){thePath.add(new Position(i, col));}
            }
        }
        else if(to.row == row){
            if(to.col > col){
                for(int i = col + 1;i < to.col;i++){thePath.add(new Position(row, i));}
            }
            else{
                for(int i = col - 1;i > to.col;i--){thePath.add(new Position(row, i));}
            }
        }
        else{
            if(to.col > col){
                if(to.row > row){
                    for(int i = 1;i < to.col - col;i++){thePath.add(new Position(row + i, col + i));}
                }
                else{
                    for(int i = 1;i < to.col - col;i++){thePath.add(new Position(row - i, col + i));}
                }
            }
            else{
                if(to.row > row){
                    for(int i = 1;i < col - to.col;i++){thePath.add(new Position(row + i, col - i));}
                }
                else{
                    for(int i = 1;i < col - to.col;i++){thePath.add(new Position(row - i, col - i));}
                }
            }
        }
		return thePath;
	}
}