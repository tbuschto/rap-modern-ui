package org.eclipse.rap.addons.modernui.demo;

import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.swt.widgets.Composite;


public class DemoEntryPoint extends AbstractEntryPoint {

  @Override
  protected void createContents( Composite parent ) {
    new DemoUI( parent );
  }
}
