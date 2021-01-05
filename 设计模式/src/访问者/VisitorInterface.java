package 访问者;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 19:23
 *
 */
public interface VisitorInterface {
    void visit(NonCaliforniaOrder nco);
    void visit(CaliforniaOrder co);
    void visit(OverseasOrder oo);
}
