package com.github.Evgenn91.e_JointPoin;



import com.github.Evgenn91.e_JointPoin.objects.Book;
import com.github.Evgenn91.e_JointPoin.objects.UniversityLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * JointPoint (точка наблюдения)
 * это точка/момент в выполняемой программе,
 * когда следует применять Advice.
 * Тоесть это точка переплетения метода с бизнес логикой и
 * метода со служебным функционалом
 */
public class TestJointPoint {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniversityLibrary universityLibrary = context.getBean("universityLibrary",UniversityLibrary.class);
        Book book = context.getBean("book", Book.class);

        System.out.println("метод addBook: ");
        universityLibrary.addBook("Анна каренина");
        System.out.println("--------------");
        System.out.println("метод getMagazine: ");
        universityLibrary.getMagazine();
        System.out.println("--------------");
        System.out.println("метод getName: ");
        book.getName();
        System.out.println("--------------");

        context.close();

    }
}
