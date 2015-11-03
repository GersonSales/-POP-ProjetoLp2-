package projeto.maispop.postagem;

import java.util.Comparator;
import java.util.Map;

class ComparadorValor implements Comparator<Object> {
    Map<HashTag, Integer> base;

    public ComparadorValor(Map<HashTag, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(Object a, Object b) {
    	if (a.equals(b)) {
    		return 0;
    	}
    	
    	if (base.get(a) > base.get(b)) {
    		return 1;
    	}else {
    		return -1;
    	}
    }

}
