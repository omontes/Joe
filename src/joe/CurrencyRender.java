/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Oscar Montes
 */
public class CurrencyRender extends DefaultTableCellRenderer {

    public CurrencyRender() {
        this.setHorizontalAlignment(JLabel.RIGHT);
    }

    @Override
    public void setValue(Object value) {
        Object result = value;
        if ((value != null) && (value instanceof Number)) {
            Number numberValue = (Number) value;
            Locale l = new Locale("es", "CR");
            NumberFormat formatter = NumberFormat.getCurrencyInstance(l);
            result = formatter.format(numberValue.doubleValue());
                    }
        super.setValue(result);
    }
}