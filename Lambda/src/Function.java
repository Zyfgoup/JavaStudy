/**
 * @Author Zyfgoup
 * @Date 2020/7/31 18:05
 * @Description
 */
@FunctionalInterface
public interface Function<T,R> {

    R apply(T t);
}
