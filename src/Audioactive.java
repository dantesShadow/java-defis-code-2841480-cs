import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Audioactive {

  public static long valeurSuivante(long valeur) {
    List<Long> result = new ArrayList<>();

    Optional<Long> previousDigit = Optional.empty();
    long count = 1;

    do {
      Long currentDigit = valeur % 10;
      valeur /= 10;

      if (previousDigit.isPresent()) {
        if (currentDigit.equals(previousDigit.get())) {
          count++;
        } else {
          result.add(concatenateLongs(count, previousDigit.get()));
          count = 1;
        }
      }

      previousDigit = Optional.of(currentDigit);
    } while (valeur > 0);
    result.add(concatenateLongs(count, previousDigit.get()));

    return concatenateLongs(result);
  }

  private static long concatenateLongs(List<Long> result) {
    List<Long> reversed = new ArrayList<>(result);
    Collections.reverse(reversed);

    return reversed.stream()
        .reduce(Audioactive::concatenateLongs)
        .orElseThrow(() -> new IllegalArgumentException("The list should not be empty"));
  }

  private static Long concatenateLongs(long first, long second) {
    if (second == 0)
      return first * 10;

    long numDigits = (long) Math.log10(second) + 1;
    return first * (long) Math.pow(10, numDigits) + second;
  }
}
