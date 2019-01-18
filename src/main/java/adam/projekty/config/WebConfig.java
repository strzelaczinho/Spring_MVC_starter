package adam.projekty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="adam.projekty")
public class WebConfig {

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
}
