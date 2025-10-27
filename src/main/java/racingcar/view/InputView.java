package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class InputView {
  private final String readCarNamesText = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private final String readRoundsText = "시도할 횟수는 몇 회인가요?";
  private final String regex = ",";

  public List<String> readCarNames() {
    System.out.println(readCarNamesText);
    List<String> names = Arrays.stream(Console.readLine().split(regex, -1))
            .map(String::trim)
            .toList();
    validateNames(names);
    return names;
  }

  public int readRounds() {
    System.out.println(readRoundsText);
    String rounds_string = Console.readLine().trim();
    return validateRounds(rounds_string);
  }

  private int validateRounds(String rounds_string) {
    try {
      int rounds = Integer.parseInt(rounds_string);
      if (rounds <= 0) {
        throw new IllegalArgumentException("round는 양수여야 합니다.");
      }
      return rounds;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("round는 int형 정수여야 합니다.");
    }
  }

  private void validateNames(List<String> names) {
    Set<String> existNames = new HashSet<>();
    for (String name : names) {
      if (name.isEmpty()) {
        throw new IllegalArgumentException("처음 또는 쉼표(,) 다음에는 이름이 한 글자 이상 있어야 합니다.");
      }
      if (name.length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다");
      }
      if (!existNames.add(name)) {
        throw new IllegalArgumentException("중복된 자동차 이름이 있습니다");
      }
    }
  }
}
