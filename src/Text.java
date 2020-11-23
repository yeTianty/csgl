import com.dao.StudentDaoImpl;

/**
 * @Author: Tanoty
 * @Date: 2020/11/23 14:56
 */
public class Text {
    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        int i = studentDao.storageUser("123", "123", "123", "123");
        if (i == 1) {
            System.out.println("1");
        } else if (i == 2) {
            System.out.println("2");
        } else if (i == 0) {
            System.out.println("0");
        }
    }
}
