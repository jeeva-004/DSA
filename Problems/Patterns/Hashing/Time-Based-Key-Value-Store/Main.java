import java.util.*;

class TimeMap {
    HashMap<String, List<TimeValue>> data;
    TimeMap() {
        data = new HashMap<>();
    }
    class TimeValue {
        int timestamp;
        String value;

        TimeValue(int time, String val) {
            timestamp = time;
            value = val;
        }
    }

    public void set(String key, int timestamp, String value) {
        TimeValue tm = new TimeValue(timestamp, value);
        List<TimeValue> tv = new ArrayList<>();
        if (data.isEmpty() || !data.containsKey(key)) {
            tv.add(tm);
            data.put(key, tv);
            return;
        }

        tv = data.get(key);
        tv.add(tm);
        data.put(key, tv);
    }

    public String get(String key, int timestamp) {
        if (!data.containsKey(key))
            return "";

        String pre = "";

        List<TimeValue> tm = data.get(key);

        int left = 0, right = tm.size() - 1, mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (tm.get(mid).timestamp > timestamp) {
                right = mid - 1;
            } else if (tm.get(mid).timestamp < timestamp) {
                left = mid + 1;
                pre = tm.get(mid).value;
            } else
                return tm.get(mid).value;

        }

        return pre;
    }

}

public class Main {
    public static void main(String[] args) {
        TimeMap tm = new TimeMap();

        tm.set("foo", 1, "bar");
        tm.set("foo", 4, "bar2");
        System.out.println(tm.get("foo", 1)); // Prints: bar
        System.out.println(tm.get("foo", 3)); // Prints: bar
        System.out.println(tm.get("foo", 5)); // Prints: bar2

    }
}
