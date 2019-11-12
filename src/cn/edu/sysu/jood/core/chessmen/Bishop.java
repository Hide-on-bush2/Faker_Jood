package cn.edu.sysu.jood.core.chessmen;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sysu.jood.core.Chessboard;
import cn.edu.sysu.jood.core.Chessman;
import cn.edu.sysu.jood.core.Position;

public class Bishop extends Chessman {
   
	@Override
    public boolean canGo(Position to) {
		Position cur = super.getPosition();
		int col = cur.getCol();
		int row = cur.getRow();
        if(to.col > to.COL || to.col < 1 || to.row > to.ROW || to.row < 1 || (to.col == col && to.row == row)){return false;}
        return Math.abs(to.col - col) == Math.abs(to.row - row);
    }

    @Override
    public Status status() {
        return Status.Bishop;
    }

    @Override
    public List<Position> path(Position to) {
    	Position cur = super.getPosition();
		int col = cur.getCol();
		int row = cur.getRow();
        List<Position> thePath = new ArrayList<Position>();
        if(!canGo(to)){return thePath;}
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
        return thePath;
	}

}