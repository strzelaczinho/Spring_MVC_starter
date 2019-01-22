package adam.projekty.config;

import adam.projekty.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="adam.projekty")
public class WebConfig implements WebMvcConfigurer { //webmvcconfigurer posiada metody ktore moga pomoc w ustawieniu roota . Czyli mapowaniu strony startowej oraz inne

    //tworze ViewResolverBean

    public static final String RESOLVER_PREFIX="/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX =".jsp";

    //metoda ktora tworzy VIewResolver
    @Bean
    public ViewResolver viewResolver()
    {
        //tutaj tworze internal view resolver. Mieszanka prefiksu oraz sufiksu
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();

        //ustawiam prefix i sufix
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        return viewResolver;
    }
    // korzystam z webmvcconfigurer domyslnej metody aby zconfigurowac "/" czyli roota. Renderuje response body :) path to home view . Bez kontrolera :))
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewNames.HOME); // specjalny kontroler ktory wypierdziela nas na homepage roota :)
    }
}
