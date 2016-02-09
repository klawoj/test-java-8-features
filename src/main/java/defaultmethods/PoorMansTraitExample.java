package defaultmethods;


public class PoorMansTraitExample {

    /**
     * Taken from
     * http://zeroturnaround.com/rebellabs/how-your-addiction-to-java-8-default-methods-may-make-pandas-sad-and-your-teammates-angry/
     */
    public interface Sortable<T> {

        <T> T get(int idx);

        <T> void set(T t, int idx);

        default void sort() {
            // here is an implementation of sort using get() and set()
            // maybe I need a size() as well, but that’s not the point
            return;
        }
    }

}
