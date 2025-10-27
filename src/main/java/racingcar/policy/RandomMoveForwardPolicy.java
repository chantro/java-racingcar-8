package racingcar.policy;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomMoveForwardPolicy implements MovePolicy {
  private final int threshold;

  public RandomMoveForwardPolicy(int threshold) {
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

