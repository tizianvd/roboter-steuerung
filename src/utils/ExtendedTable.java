package utils;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class ExtendedTable extends JTable
{
    HashMap<Integer, Color> rowColor = new HashMap<Integer, Color>();

    public ExtendedTable(TableModel model)
    {
        super(model);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
    {
            Component c = super.prepareRenderer(renderer, row, column);

            if (!isRowSelected(row))
            {
                    Color color = rowColor.get( row );
                    c.setBackground(color == null ? getBackground() : color);
            }

            return c;
    }

    public void setRowColor(int row, Color color)
    {
        rowColor.put(row, color);
    }
}