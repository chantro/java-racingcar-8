package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public final class InputView {
  private final String readCarNamesText = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private final String readRoundsText = "시도할 횟수는 몇 회인가요?";
  private final String regex = ",";

  public List<String> readCarNames() {
    System.out.println(readCarNamesText);
    List<String> names = Arrays.stream(Console.readLine().split(regex))
            .map(String::trim)
            .toList();
    return names;
  }

  public int readRounds() {
    System.out.println(readRoundsText);
    String rounds_string = Console.readLine().trim();
    return Integer.parseInt(rounds_string);
  }
}
