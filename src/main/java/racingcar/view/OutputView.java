package racingcar.view;

import racingcar.domain.Car;

import java.util.Iterator;
import java.util.List;

public final class OutputView {
  private final String Header = "실행 결과";

  public void printHeader() {
    System.out.println(Header);
  }

  public void printRoundResult(List<Car> cars) {
    StringBuilder sb = new StringBuilder();
    for (Car car : cars) {
      sb.append(car.getName()).append(" : ");
      sb.append("-".repeat(car.getPosition()));
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public void printWinnerResult(List<Car> winners) {
    StringBuilder sb = new StringBuilder();
    sb.append("최종 우승자 : ");

    Iterator<Car> winners_iterator = winners.iterator();
    while (winners_iterator.hasNext()) {
      Car winner = winners_iterator.next();
      sb.append(winner.getName());
      if (winners_iterator.hasNext()) {
        sb.append(", ");
      }
    }
    System.out.println(sb);
  }
}
