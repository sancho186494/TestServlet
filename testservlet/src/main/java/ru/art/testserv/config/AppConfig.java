package ru.art.testserv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("ru.art.testserv")
public class AppConfig implements WebMvcConfigurer {
	
	private final ApplicationContext ctx;
	
	@Autowired
	public AppConfig(ApplicationContext ctx) {
		this.ctx = ctx;
	}
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/firstServletJsp").setViewName("firstServlet");
		registry.addViewController("/dataPlaceHolderJsp").setViewName("dataPlaceHolder");
		System.out.println("addViewControllers ok");
	}
	/*
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/").setCachePeriod(31556926);
		 System.out.println("addResourceHandlers ok");
    }*/

	@Bean
	public InternalResourceViewResolver resolver() {
		System.out.println("InternalResourceViewResolver ok");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	
}