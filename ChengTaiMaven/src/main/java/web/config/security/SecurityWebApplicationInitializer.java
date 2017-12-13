package web.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

// This class is a MUST in order to have spring security kick in
// This class must be scan by the ServletXml
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}
