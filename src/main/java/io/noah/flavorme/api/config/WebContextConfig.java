package io.noah.flavorme.api.config;

import framewise.dustview.ClasspathSupportFileSystemDustTemplateLoader;
import framewise.dustview.DustTemplateEngine;
import framewise.dustview.SimpleDustTemplateView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chanwook on 2014. 7. 29..
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"io.noah.flavorme.api"},
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(value = {RestController.class, Controller.class})})
public class WebContextConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
        configurer.favorParameter(false);
        configurer.favorPathExtension(false);
        configurer.ignoreAcceptHeader(false);
    }

    @Bean
    public ViewResolver getCnvr() {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();

        // Setting to ViewResolver List
        ArrayList<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
        viewResolvers.add(new BeanNameViewResolver());
        viewResolvers.add(getJspViewResolver());
        viewResolver.setViewResolvers(viewResolvers);

        // Setting to Default View
        ArrayList<View> defaultViews = new ArrayList<View>();
        defaultViews.add(new MappingJackson2JsonView());
        viewResolver.setDefaultViews(defaultViews);

        return viewResolver;
    }

    @Bean
    public ViewResolver getJspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);

        HashMap<String, Object> attributesMap = new HashMap<>();
        attributesMap.put(SimpleDustTemplateView.VIEW_PATH_PREFIX, "../view/");
        attributesMap.put(SimpleDustTemplateView.VIEW_PATH_SUFFIX, "");
        attributesMap.put(SimpleDustTemplateView.MULTI_LOAD, true);
        attributesMap.put(SimpleDustTemplateView.DUST_ENGINE_OBJECT, dustEngine());
        viewResolver.setAttributesMap(attributesMap);

        return viewResolver;
    }

    @Bean
    public DustTemplateEngine dustEngine() {
        DustTemplateEngine engine = new DustTemplateEngine();
        engine.setViewTemplateLoader(new ClasspathSupportFileSystemDustTemplateLoader());
        engine.setCompiled(false);
        return engine;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
