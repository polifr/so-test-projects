package it.poli.configuration;

import it.poli.interceptor.OsivProcedureInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OsivWebConfiguration implements WebMvcConfigurer {

  @Autowired OsivProcedureInterceptor osivProcedureInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(osivProcedureInterceptor).order(Ordered.LOWEST_PRECEDENCE);
  }
}
