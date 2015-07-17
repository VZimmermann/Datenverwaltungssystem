# Datenverwaltungssystem

Aufbau:
1ic_kartenKundenDaten
  1 src/main/java
  
    1 org.intercard.template.aop
    
    2 org.intercard.template.data.db
    
    3 org.intercard.template.data.db.dao
    
    4 org.intercard.template.data.db.dao.impl
    
    5 org.intercard.template.data.db.domain
    
    6 org.intercard.template.data.db.domain.enums
    
    7 org.intercard.template.data.db.ex
    
    8 org.intercard.template.ex
    
    9 org.intercard.template.service
    
    10 org.intercard.template.service.impl
    
    11 org.intercard.template.ui.jsf.controller.impl
    
    12 org.intercard.template.ui.jsf.controller
    
    13 org.intercard.template.util
    
  2 src/main/resources
  
    1 context
    
      1 spring-config-aop.xml
      
    
      2 spring-config-data.xml
      
      3 spring-config-datasource.xml
      
      4 spring-config-service-web.xml
      
      5 spring-config-service.xml
      
      6 springconfig.xml
      
    2 default.icd
    
    3 default.icl
    
    4 Bild
    
    5 logback.xml
    
    6 persisense.xml
    
  3 src/test/java
  
    1 org.intercard.template
    
      SpringTestBase.java
      
    2 org.intercard.template.data
    
      TestDBSchemaService.java
      
      TestGuiUserService.java
      
  4 src/test/resources
  
    -persistense.xml
    
