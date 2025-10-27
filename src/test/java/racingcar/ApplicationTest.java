package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
  private static final int MOVING_FORWARD = 4;
  private static final int STOP = 3;

  @Test
  void 기능_테스트() {
    assertRandomNumberInRangeTest(
            () -> {
              run("pobi,woni", "1");
              assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
    );
  }

  @Test
  void 기능_여러라운드_공동우승_검증() {
    // 라운드 3, 참가자 3 → 총 9번 난수
    assertRandomNumberInRangeTest(
            () -> {
              run("pobi,woni,jun", "3");
              String out = output();
              assertThat(out).contains("최종 우승자 : pobi, woni, jun");
            },
            5, 2, 7, 9, 4, 0, 0, 6, 8
    );
  }

  @Test
  void 예외_이름_길이초과() {
    assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  void 예외_중복_이름() {
    assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  void 예외_라운드_0은_불가() {
    assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("round는 양수여야 합니다.")
    );
  }

  @Test
  void 입력_앞뒤공백_허용() {
    assertRandomNumberInRangeTest(
            () -> {
              run("  pobi ,   woni  ", "1");
              String out = output();
              assertThat(out).contains("pobi :");
              assertThat(out).contains("woni :");
              assertThat(out).contains("최종 우승자 :");
            },
            MOVING_FORWARD, MOVING_FORWARD
    );
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}