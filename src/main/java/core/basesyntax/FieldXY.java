package core.basesyntax;

/**
 * <p>На игровом поле находится робот. Позиция робота на поле описывается двумя
 * целочисленным координатами: X и Y.
 * Ось X смотрит слева направо, ось Y — снизу вверх.(Помните, как рисовали
 * графики функций в школе?)
 * В начальный момент робот находится в некоторой позиции на поле.
 * Также известно, куда робот смотрит: вверх, вниз, направо или налево.
 * Ваша задача — привести робота в заданную точку игрового поля.
 * Реализуйте метод moveRobot()</p>
 */
public class FieldXY {

    public void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() != toX) {
            moveRobotForX(robot, toX);
        }
        if (robot.getY() != toY) {
            moveRobotForY(robot, toY);
        }
    }

    private void moveRobotForY(Robot robot, int toY) {
        if (robot.getY() < toY && !robot.getDirection().equals(Direction.UP)) {
            turnRobot(robot, Direction.UP);
        } else if (!robot.getDirection().equals(Direction.DOWN)) {
            turnRobot(robot, Direction.DOWN);
        }
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }

    private void moveRobotForX(Robot robot, int toX) {
        if (robot.getX() < toX && !robot.getDirection().equals(Direction.RIGHT)) {
            turnRobot(robot, Direction.RIGHT);
        } else if (!robot.getDirection().equals(Direction.LEFT)) {
            turnRobot(robot, Direction.LEFT);
        }
        while (robot.getX() != toX) {
            robot.stepForward();
        }
    }

    private void turnRobot(Robot robot, Direction direction) {
        while (!robot.getDirection().equals(direction)) {
            robot.turnLeft();
        }
    }
}
