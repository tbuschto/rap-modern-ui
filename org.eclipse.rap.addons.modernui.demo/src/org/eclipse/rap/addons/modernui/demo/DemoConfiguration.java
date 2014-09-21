package org.eclipse.rap.addons.modernui.demo;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rap.addons.modernui.ModernUI;
import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.client.WebClient;


public class DemoConfiguration implements ApplicationConfiguration {

  @Override
  public void configure( Application application ) {
    Map<String, String> properties = new HashMap<String, String>();
    properties.put( WebClient.PAGE_TITLE, "RAP Modern-UI Demo" );
    application.addEntryPoint( "/", DemoEntryPoint.class, properties );
    ModernUI.configureApplication( application );
  }

}
