package adam.projekty.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {
    //nazywam servlet
private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("Start servletowy!");
        //tworze servlet kontekst zeby moc zarejestrowac.Servlet kontekt zapewnia metody dla komunikacji z servlet contenerem, ktorym jest w tym przypadku Tomcat
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();//tworze kontekt aplikacji

        //rejestruje webconfig.class
        context.register(WebConfig.class);//rejestruje klase konfiguraji

        //tworze dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        //rejestruje i configuruje dispatcher servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME,dispatcherServlet);

        registration.setLoadOnStartup(1); // konfiguruje startup loading . Cointainer stworzy instacje na startupie
        registration.addMapping("/"); // tutaj mapuje servlet na roota . Przeciazy tomcatowa sciezke na roota. Zamiast HomePage. Pojawi sie aplikacja
    }
}
