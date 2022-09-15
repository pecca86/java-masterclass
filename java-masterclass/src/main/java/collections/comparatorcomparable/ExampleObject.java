package collections.comparatorcomparable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExampleObject {
    private String value;
    private boolean isFlagged = false;
    private List<InnerObject> innerObjectList;

    // COMPARATOR AS ANONYMOUS INNER CLASS
    static final Comparator<InnerObject> STRING_ORDER;
    static {
        System.out.println("STATIC STRING ORDER INITIALIZED");
        STRING_ORDER = new Comparator<InnerObject>() {
            @Override
            public int compare(InnerObject o1, InnerObject o2) {
                return o1.getValue().compareToIgnoreCase(o2.getValue());
            }
        };
    }

    public ExampleObject(String value) {
        this.value = value;
        innerObjectList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.value;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged() {
        isFlagged = !isFlagged;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addInnerObject(String value, int rank) {
        this.innerObjectList.add(new InnerObject(value, rank));
    }

    public List<InnerObject> getInnerObjectList() {
        return innerObjectList;
    }

    private class InnerObject implements Comparable<InnerObject> {
        private String value;
        private int rank;

        public InnerObject(String value, int rank) {
            this.value = value;
            this.rank = rank;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return value +  " - rank:" + rank;
        }

        @Override
        public int compareTo(InnerObject i) {
            return this.rank - i.getRank();
        }
    }
}
