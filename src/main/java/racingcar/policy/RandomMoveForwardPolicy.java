package racingcar.policy;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomMoveForwardPolicy implements MovePolicy {
  private final int threshold;

  public RandomMoveForwardPolicy(int threshold) {
    if (threshold < 0 || threshold > 9) {
      throw new IllegalArgumentException("threshold는 0~9 사이의 값이어야 합니다.");
    }
    this.threshold = threshold;
  }

  @Override
  public int step() {
    int random_value = Randoms.pickNumberInRange(0, 9);
    if (random_value >= threshold) {
      return 1;
    } else {
      return 0;
    }
  }
}

