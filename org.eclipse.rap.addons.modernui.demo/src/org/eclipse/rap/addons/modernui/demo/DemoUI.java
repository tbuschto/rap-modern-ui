package org.eclipse.rap.addons.modernui.demo;

import static org.eclipse.rap.addons.modernui.ModernUI.createSwitchButton;

import org.eclipse.swt.widgets.Composite;


public class DemoUI {

  public DemoUI( Composite parent ) {
    createSwitchButton( parent ).text( "Optional Feature 1" );
    createSwitchButton( parent, 16 ).text( "Optional Feature 2" );
    createSwitchButton( parent, 18 ).text( "Optional Feature 3" );
    createSwitchButton( parent, 20 ).text( "Optional Feature 4" );
    createSwitchButton( parent, 22 ).text( "Optional Feature 5" );
    createSwitchButton( parent, 24 ).text( "Optional Feature 6" );
  }

}
