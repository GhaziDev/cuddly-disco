/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystemgui;

/**
 *
 * @author ghazi
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;


//CUSTOM JAVA SWING TEXT FIELD, TO ADD PLACEHOLDERS, SINCE THE DEFAULT JTextField DO NOT PROVIDE A PLACEHOLDER FEATURE.
@SuppressWarnings("serial")
public class JCustomTextField extends JTextField {

	private String placeholder;

	public JCustomTextField(String ph) {
		this.placeholder = ph;
	}
	
	public JCustomTextField() {
		this.placeholder = null;
	}

	/*
	 Gets text, returns placeholder if nothing specified
	 */
	@Override
	public String getText() {
		String text = super.getText();

		if (text.trim().length() == 0 && placeholder != null) {
			text = placeholder;
		}

		return text;
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		if (super.getText().length() > 0 || placeholder == null) {
			return;
		}
		
		Graphics2D graphics2 = (Graphics2D) graphics;

		graphics2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2.setColor(super.getDisabledTextColor());
		graphics2.drawString(placeholder, getInsets().left, graphics.getFontMetrics().getMaxAscent() + getInsets().top);
	}
}
