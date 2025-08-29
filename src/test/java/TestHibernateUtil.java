
import com.mycompany.projectone.util.HibernateUtil;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Gaudomun
 */
public class TestHibernateUtil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFatory().openSession()) {
            try {
                System.setOut(new PrintStream(System.out, true, "UTF-8"));
            }catch(UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
           
            System.out.println("Kết nối Hibernate thành công!");
        }catch(HibernateException he) {
            he.printStackTrace();
        }
    }
    
}
