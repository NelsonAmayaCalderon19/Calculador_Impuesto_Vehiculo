import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import java.awt.Container;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.*;
import java.lang.*;
import javax.swing.border.*;

public class ImpuestoVehiculo extends JFrame implements ActionListener
{
    Concesionario concesionario;
    Vehiculo vehiculo;
    int cont=0;
    JLabel l1 = new JLabel("Marca");
    JLabel l2 = new JLabel("Línea");
    JLabel l3 = new JLabel("Modelo");
    JLabel l4 = new JLabel("Valor");
    JLabel l5 =  new JLabel("Total a Pagar ");
    JLabel l6 = new JLabel("");
    JLabel l7 = new JLabel("");
    //JLabel l8 = new JLabel("");
    JTextArea list = new JTextArea("");
    JCheckBox cbPPago = new JCheckBox("Pronto Pago");
    JCheckBox cbSPublico = new JCheckBox("Servicio Publico");
    JCheckBox cbTCuenta = new JCheckBox("Traslado de Cuenta");

    JButton b1 = new JButton("Buscar Vehiculo");
    JButton b2 = new JButton("Limpiar");
    JButton b3 = new JButton("Calcular");
    JButton b4 = new JButton("Almacenar Vehiculo");
    JButton b5 = new JButton("Ver Vehiculos Registrados");

    JTextField t1 = new JTextField("");
    JTextField t2 = new JTextField("");
    JTextField t3 = new JTextField("");
    JTextField t4 = new JTextField("");
    JTextField t5 = new JTextField("");

    JPanel p1 =  new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    public ImpuestoVehiculo(){
        concesionario =new Concesionario();
        componentes();
    }

    public void componentes (){
        getContentPane().setLayout(new GridLayout(3,1));
        setSize(550,600);

        setTitle("Cálculo impuestos");
        setResizable(false);  
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo( null );

        p1.setLayout(new GridLayout(5,2));
        p1.setPreferredSize(new Dimension(0,130));

        p1.setBorder(javax.swing.BorderFactory.createTitledBorder("titulo"));
        p1.setBorder(((javax.swing.BorderFactory.createTitledBorder(null, "Datos del Vehículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(0, 0, 255)))));

        p2.setLayout(new GridLayout(2,2));

        p3.setLayout(new GridLayout(2,4));
        p2.setPreferredSize(new Dimension(0,65));

        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        p1.add(b4);
        p1.add(b1);
        add(p1);

        p2.setBorder(javax.swing.BorderFactory.createTitledBorder("titulo"));
        p2.setBorder(((javax.swing.BorderFactory.createTitledBorder(null, "Descuentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(0, 0, 255)))));

        p2.add(cbPPago);
        p2.add(cbTCuenta);
        p2.add(cbSPublico);
        add(p2);

        //p3.add(list);
        p3.add(l6);
        p3.add(b5);
        p3.add(b2);
        p3.add(l5);
        p3.add(t5);
        p3.add(b3);

        add(p3);

        list.setEditable(false);
        t4.setForeground(Color.BLUE);
        t4.setBackground(Color.WHITE);

        t5.setEditable(false);
        t5.setForeground(Color.BLUE);
        t5.setBackground(Color.WHITE);

        p3.setBorder(javax.swing.BorderFactory.createTitledBorder("titulo"));
        p3.setBorder(((javax.swing.BorderFactory.createTitledBorder(null, "Resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(0, 0, 255)))));

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()== b4){
            concesionario.guardarCarro(t1.getText(),t2.getText(),t3.getText(),Double.parseDouble(t4.getText()));
           
            JOptionPane.showMessageDialog(null,"Se Almaceno Correctamente");
            Limpiar();
            cont++;
        }
        else
        if(e.getSource()== b5){
            CargarCarros();
            t4.setEditable(false);
        }
        else
        if(e.getSource()== b1){
            vehiculo=concesionario.buscarCarro(t1.getText(),t2.getText(),t3.getText());
            if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() ){
                JOptionPane.showMessageDialog(this, "Por favor llene todos los datos"  , "Cálculo de Impuestos" , JOptionPane.ERROR_MESSAGE);
                
            } 
            else if(vehiculo==null){
                JOptionPane.showMessageDialog(null,"El Vehiculo no se Encuentra Registrado ","Informacion",JOptionPane.ERROR_MESSAGE);
            t4.setText("");
            }
            else
            t1.setText(vehiculo.getMarca());
            t2.setText(vehiculo.getLinea());
            t3.setText(vehiculo.getModelo());
            Double n= Double.valueOf(vehiculo.getPrecio());
            t4.setText(Integer.valueOf(n.intValue()).toString());
            t4.setEditable(false);
        }
        if(e.getSource()==b2){
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t4.setEditable(true);
        }  
        for(int i=0;i< concesionario.vehiculos.size();i++){
                if(e.getSource()== b1){
                    vehiculo=concesionario.buscarCarro(t1.getText(),t2.getText(),t3.getText());
                    DecimalFormat n = new DecimalFormat("$ ###,###,###");
                    
                    t4.setText(n.format(vehiculo.precio));
                    //auto1=vehiculos[i];
                    t4.setEditable(false);
                    return;
                }
            }
            
        for(int i=0;i< concesionario.vehiculos.size();i++){
            if(e.getSource()==b3){            
                CalculadorImpuestos c = new CalculadorImpuestos(vehiculo=concesionario.buscarCarro(t1.getText(),t2.getText(),t3.getText()));
                DecimalFormat n = new DecimalFormat("$ ###,###,###");
                t5.setText(n.format(c.descuentos(this)));

            }
        }

    }

    public void CargarCarros(){
        System.out.println("Marcas Registradas Hasta el Momento: "+cont);
        list.setText(concesionario.verCarros()); 
        System.out.println(list.getText());
    }

    public void Limpiar(){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
    }

    public static void main(String [] args){
        ImpuestoVehiculo imp = new ImpuestoVehiculo();
    }
}

