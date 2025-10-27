package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarRace;
import racingcar.policy.MovePolicy;
import racingcar.policy.RandomMoveForwardPolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
    //입력값 받기
    InputView inputView = new InputView();
    List<Car> cars = inputView.readCarNames().stream().map(Car::new).toList();
    int rounds = inputView.readRounds();

    //move 정책 생성
    int threshold = 4;
    MovePolicy policy = new RandomMoveForwardPolicy(threshold);
    OutputView outputView = new OutputView();
    CarRace race = new CarRace(cars, rounds, policy, outputView);

    //경기 시작
    race.play();
  }
}

