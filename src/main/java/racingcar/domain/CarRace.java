package racingcar.domain;

import racingcar.policy.MovePolicy;
import racingcar.view.OutputView;

import java.util.*;

public class CarRace {
  private List<Car> cars;
  private int rounds;
  private MovePolicy policy;
  private OutputView outputView;

  public CarRace(List<Car> cars, int rounds, MovePolicy policy, OutputView outputView) {
    this.cars = cars;
    this.rounds = rounds;
    this.policy = policy;
    this.outputView = outputView;
  }

  public void play() {
    outputView.printHeader();
    for (int i = 0; i < rounds; i++) {
      for (Car car : cars) {
        car.moveForward(policy);
      }
      outputView.printRoundResult(cars);
    }
    outputView.printWinnerResult(getWinners());
  }

  public List<Car> getWinners() {
    int max_position = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    return cars.stream().filter(c -> c.getPosition() == max_position).toList();
  }
}

