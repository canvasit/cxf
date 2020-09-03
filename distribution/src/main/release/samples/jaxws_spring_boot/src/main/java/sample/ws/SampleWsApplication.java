/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package sample.ws;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//CHECKSTYLE:OFF
@SpringBootApplication
@Configuration
//@ImportResource({ "classpath:META-INF/cxf/cxf.xml", "classpath:beans.xml" })
@ImportResource({ "classpath:beans.xml" })
public class SampleWsApplication extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleWsApplication.class, args);
    }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SampleWsApplication.class);
	}	  


    // Replaces the need for web.xml
	// Overwrites the application property: cxf.path=/Service
    @Bean
    public ServletRegistrationBean<CXFServlet> servletRegistrationBean(ApplicationContext context) {
    	ServletRegistrationBean<CXFServlet> bean = new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/api/*");
    	bean.setLoadOnStartup(1);
    	return bean;
    }

	
}
