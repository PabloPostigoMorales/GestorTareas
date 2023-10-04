package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame{
    private JPanel panel;
    private JTable table1;
    private JTextField txtTarea;
    private JButton addButton;
    private JComboBox comboPrio;
    private JTextField txtEsta;
    private JTextArea txtdescrip;
    DefaultTableModel datos;

    public Principal(){
        this.setContentPane(panel);
        setResizable(false);
        setSize(800,300);
        setLocationRelativeTo(null);
        setTitle("Pagina Principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        datos = (DefaultTableModel) table1.getModel();
        datos.addColumn("Tarea");
        datos.addColumn("Prioridad");
        datos.addColumn("Estado");
        datos.addColumn("Descripcion");
        addButton.addActionListener(e ->addToTable());

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                readTable();
            }
        });
    }

    private void readTable() {
        var selected = table1.getSelectedRow();
        System.out.println(selected);
        System.out.println(datos.getValueAt(selected,0));
        System.out.println(datos.getValueAt(selected,1));
        System.out.println(datos.getValueAt(selected,2));
        System.out.println(datos.getValueAt(selected,3));

    }

    private void addToTable() {
        String tarea = txtTarea.getText();
        String prioridad =(String) comboPrio.getSelectedItem();
        String estado = txtEsta.getText();
        String descripcion = txtdescrip.getText();
        System.out.println(prioridad);
        System.out.println(estado);

        String[] dato = {tarea,prioridad,estado,descripcion};
        datos.addRow(dato);
    }

    public void load(){
        setVisible(true);
    }
}
