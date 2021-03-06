package com.aor.ghostrumble.play.model;

import static java.lang.Math.abs;

public class FreeMovement extends MovementStrategy {

    public FreeMovement() { super(); }

    @Override
    public void updateDirection(Position position1, Position position2) {
        int horOffset = position1.getX() - position2.getX();
        int vertOffset = position1.getY() - position2.getY();

        if(horOffset == 0)
            deltaX = 0;
        else deltaX = horOffset / abs(horOffset);

        if(vertOffset == 0)
            deltaY = 0;
        else deltaY = vertOffset / abs(vertOffset);
    }
}
