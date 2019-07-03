package cs544.application05;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

//public class MyWebAppInitializer implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext container) throws ServletException {
//		// Create the 'root' Spring application context
//		AnnotationConfigWebApplicationContext rootContext = 
//				new AnnotationConfigWebApplicationContext();
//		rootContext.register(Config.class);
//
//		// Manage the lifecycle of the root application context
//		container.addListener(new ContextLoaderListener(rootContext));
//
//		
//		FilterRegistration.Dynamic openInView = 
//				container.addFilter("OpenInView", new OpenEntityManagerInViewFilter());
//		openInView.addMappingForUrlPatterns(null, true, "/*");		
//	}
//}
