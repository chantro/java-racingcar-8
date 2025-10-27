package racingcar.domain;

import racingcar.policy.MovePolicy;

public class Car {
  private final String name;
  private int position = 0;

  public Car(String name) {
    this.name = name;
  }

  public int moveForward(MovePolicy policy) {
    position += policy.step();
    return position;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }
}

