package Go.records;

import Go.GoPosition;

import java.util.Set;

public record GoShape(Set<GoPosition> liberties, Set<GoPosition> stones) {
}
