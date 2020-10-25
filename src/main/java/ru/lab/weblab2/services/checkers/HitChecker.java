package ru.lab.weblab2.services.checkers;


import ru.lab.weblab2.model.entities.Point;

//TODO a you sure, that this interface is model? Maybe this is service?
//TODO strange name. Maybe (baby) change to HitChecker or same?
//TODO move to another package
public interface HitChecker {
    boolean isHit(Point point);
}
