package leetcode.beginning2021;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhushang
 * @create: 2021-04-16 13:18
 */
public class L242 {
  public boolean isAnagram(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (char c : t.toCharArray()) {
      if (map.get(c) <= 0) {
        return false;
      } else {
        map.put(c, map.getOrDefault(c, 0) - 1);
      }
    }
    return true;
  }
}
