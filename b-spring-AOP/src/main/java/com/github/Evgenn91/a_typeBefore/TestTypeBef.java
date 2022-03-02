package com.github.Evgenn91.a_typeBefore;

import com.github.Evgenn91.a_typeBefore.objects.Library;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTypeBef {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Library library = context.getBean("LibraryBean", Library.class);
        library.getBook();

        context.close();
    }
}
