package ru.lab.weblab2.services.checkers;

import ru.lab.weblab2.model.entities.Point;

public interface HitChecker {
    boolean isHit(Double x, Double y, Double r);
}
