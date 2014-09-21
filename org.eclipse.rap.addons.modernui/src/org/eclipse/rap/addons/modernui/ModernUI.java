package org.eclipse.rap.addons.modernui;

import static org.eclipse.rap.addons.modernui.Widgets.createCheckBox;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.service.ResourceLoader;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


public class ModernUI {

  /**
   * Should always be called from the ApplicationConfiguration when ModernUI is to be used
   * @param application
   */
  public static void configureApplication( Application application ) {
    application.addStyleSheet( RWT.DEFAULT_THEME_ID, "resources/css/modern_rap.css", new ResourceLoader() {
      @Override
      public InputStream getResourceAsStream( String resourceName ) throws IOException {
        return ModernUI.class.getClassLoader().getResourceAsStream( resourceName );
      }
    } );
  }

  public static Widgets<Button> createSwitchButton( Composite parent, int fontSize ) {
    return createCheckBox( parent ).fontSize( fontSize ).variant( sizePostfix( "switch", fontSize ) );
  }

  public static Widgets<Button> createSwitchButton( Composite parent ) {
    Widgets<Button> check = createCheckBox( parent );
    return check.variant( sizePostfix( "switch", check.fontSize() ) );
  }

  private static String sizePostfix( String variant, int size ) {
    if( size <= 15 ) {
      return variant + "_xs";
    }
    if( size <= 18 ) {
      return variant + "_s";
    }
    if( size >= 22 ) {
      return variant + "_l";
    }
    if( size >= 26 ) {
      return variant + "_xl";
    }
    return variant;
  }

}
