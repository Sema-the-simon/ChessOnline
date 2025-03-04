package org.spbstu.ysa.chessonline.model.pieces;

import org.spbstu.ysa.chessonline.model.Board;
import org.spbstu.ysa.chessonline.model.Pair;

import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {
    Knight(boolean color) {
        super(color);
    }

    @Override
    public Set<Pair<Integer, Integer>> allowedMove(int x, int y) {
        Set<Pair<Integer, Integer>> res = new HashSet();

        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                int curX = (int) (x + i * Math.pow(-1.0, j));
                int curY = y + i - 3;
                if (coordinatesAllow(curX, curY)) res.add(Pair.pairOf(curX, curY));
                curY = y - i + 3;
                if (coordinatesAllow(curX, curY)) res.add(Pair.pairOf(curX, curY));
            }
        }

        return res;
    }

    private boolean coordinatesAllow(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7
                && (Board.getData()[x][y].takePiece() == null
                || Board.getData()[x][y].takePiece().getColor() != this.getColor());
    }
}
