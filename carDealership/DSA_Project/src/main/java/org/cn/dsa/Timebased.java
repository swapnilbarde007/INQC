package org.cn.dsa;
/*
    Your Timebased object will be instantiated and called as such:

    Timebased obj = new Timebased();
    obj.setKey(key,value,timestamp);
    String ans = obj.getValue(targetKey,targetTimestamp);
*/
import java.util.HashMap;
import java.util.TreeMap;

public class Timebased {
    // A HashMap to store each key and its corresponding TreeMap of timestamp-value pairs.
    private HashMap<String, TreeMap<Integer, String>> map;

    // Constructor to initialize the data structure.
    public Timebased() {
        map = new HashMap<>();
    }

    // Function to store the key, value, and timestamp.
    public void setKey(String key, String val, int timestamp) {
        // If the key doesn't exist, create a new TreeMap for it.
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        // Store the value with the corresponding timestamp in the TreeMap.
        map.get(key).put(timestamp, val);
    }

    // Function to retrieve the value associated with the key at or before the target timestamp.
    public String getValue(String targetKey, int targetTimestamp) {
        // Check if the key exists in the map.
        if (!map.containsKey(targetKey)) {
            return "-1";
        }
        // Use the TreeMap to find the highest timestamp less than or equal to the target timestamp.
        TreeMap<Integer, String> treeMap = map.get(targetKey);
        Integer closestTimestamp = treeMap.floorKey(targetTimestamp);

        // If there is no valid timestamp, return "-1".
        if (closestTimestamp == null) {
            return "-1";
        }
        // Return the value associated with the closest timestamp.
        return treeMap.get(closestTimestamp);
    }
}
