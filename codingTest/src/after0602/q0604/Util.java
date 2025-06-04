package after0602.q0604;

import java.util.Objects;

public class Util {
    public static <K, V, T_Pair extends Pair<K, V>> V getValue(T_Pair pairInstance, K key) {
        if (pairInstance.getKey().equals(key)) {
            return pairInstance.getValue();
        }

        return null;

    }
}
