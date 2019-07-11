package cs544;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(Config.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

//		ServletRegistration.Dynamic hello = container.addServlet("Hello", new Hello());
//		hello.addMapping("/hello");
//		System.out.println("Test: " + hello);
    }
}





//package cs544;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
//public class MyWebAppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext container) throws ServletException {
//        // Create the Spring 'root' application context
//        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//        rootContext.register(Config.class);
//
//        // Manage the lifecycle of the root application context
//        container.addListener(new ContextLoaderListener(rootContext));
//
////        ServletRegistration.Dynamic appServlet = container.addServlet("mvc",
////                new DispatcherServlet(new GenericWebApplicationContext()));
////        appServlet.setLoadOnStartup(1);
////        appServlet.addMapping("/");
//
//    }
//}