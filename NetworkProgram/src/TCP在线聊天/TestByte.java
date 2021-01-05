package TCP在线聊天;

/**
 * @Author Zyfgoup
 * @Date 2020/4/3 17:39
 */
public class TestByte {
    public static void main(String[] args) {
        byte[] bytes = "你是谁?".getBytes();
        System.out.println((char)63);
        for (int i = 0; i <bytes.length ; i++) {
            System.out.println(bytes[i]);
        }
    }
}
