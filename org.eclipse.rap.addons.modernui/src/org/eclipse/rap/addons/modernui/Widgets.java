package org.eclipse.rap.addons.modernui;


import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;


public class Widgets<T extends Widget> {

  public static <T extends Widget> Widgets<T> on( T widget ) {
    return new Widgets<T>( widget );
  }

  public static Widgets<Button> createPushButton( Composite parent ) {
    return on( new Button( parent, SWT.PUSH | SWT.WRAP ) );
  }

  public static Widgets<Button> createCheckBox( Composite parent ) {
    return on( new Button( parent, SWT.CHECK | SWT.WRAP  ) );
  }

  public static Widgets<Button> createToggleButton( Composite parent ) {
    return on( new Button( parent, SWT.TOGGLE | SWT.WRAP  ) );
  }

  public static Widgets<Button> createRadioItem( Composite parent ) {
    return on( new Button( parent, SWT.RADIO | SWT.WRAP  ) );
  }

  private final T widget;

  private Widgets( T widget ) {
    this.widget = widget;
  }

  public T get() {
    return widget;
  }

  public Widgets<T> variant( String variant ) {
    widget.setData( RWT.CUSTOM_VARIANT, variant );
    return this;
  }

  public Widgets<T> fontSize( int fontSize ) {
    Control control = ( Control )widget;
    FontData font = control.getFont().getFontData()[ 0 ];
    control.setFont( new Font( control.getDisplay(), font.getName(), fontSize, font.getStyle() ) );
    return this;
  }

  public int fontSize() {
    Control control = ( Control )widget;
    return control.getFont().getFontData()[ 0 ].getHeight();
  }

  public Widgets<T> text( String... string ) {
    return this.repack( "text" ).text( string );
  }

  public String text() {
    return this.repack( "text" ).text();
  }

  @SuppressWarnings("unchecked")
  private Widgets<T> repack( String forMethod ) {
    if( widget instanceof Button && !( this instanceof ButtonWidgets ) ) {
      return ( Widgets<T> )new ButtonWidgets( ( Button )widget );
    }
    throw new IllegalStateException( "Method " + forMethod  + " not supported for widget of type " + widget.getClass().getName() );
  }

  private static class ButtonWidgets extends Widgets<Button> {

    private final Button button;

    public ButtonWidgets( Button widget ) {
      super( widget );
      this.button = widget;
    }

    @Override
    public ButtonWidgets text( String... text ) {
      button.setText( text[ 0 ] );
      return this;
    }

    @Override
    public String text() {
      return button.getText();
    }

  }

}
