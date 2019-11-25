package all.aa;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class hashMap  {

    public static void main(String[] args) {
        //泛型起到约束输入的参数的目的。
        final Map<String, String> map = new HashMap<String, String>(13);



        map.put("dd", "4");
        map.put("wy", "3");
        map.put("wy", "4");


        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();

            System.out.println(key);
            System.out.println(val);

        }

        System.out.println(map);
    }}
