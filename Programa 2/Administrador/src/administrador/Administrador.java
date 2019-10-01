
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.NumberFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

//import swingtest.SaldoIncorrecto;
//import swingtest.SaldoNegativo;


public class Administrador extends JFrame {
    
    private static String  selected = "";
    
    public static void main (String [] args) {
            Map<String,ArrayList> dato = new HashMap<>();
            ArrayList<Map<String,ArrayList>> listaCuentas = new ArrayList<>();
            JList<String> cuentas;	         
            DefaultListModel<String> listModel = new DefaultListModel();
            cuentas= new JList(listModel);
            cuentas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            cuentas.setLayoutOrientation(JList.VERTICAL);
            cuentas.setVisibleRowCount(-1);
/////////////////////////Clientes Bancopel
            CuentadeCheques c0= new CuentadeCheques(1);
            CuentaHabiente h1= new CuentaHabiente (11,"Juan");
            Map<CuentadeCheques,CuentaHabiente> c1 = new HashMap<CuentadeCheques,CuentaHabiente> ();
            c1.put(c0, h1);
            for (Entry<CuentadeCheques,CuentaHabiente> jugador : c1.entrySet()){
                CuentadeCheques clave = jugador.getKey();
                CuentaHabiente valor = jugador.getValue();
                System.out.println(clave.toString()+"  ->  "+valor.toString());
            }
            ArrayList<Map<CuentadeCheques,CuentaHabiente>> Bancopel =new ArrayList<>();
            Bancopel.add(c1);
            
            dato.put("Bancopel", Bancopel);
            listaCuentas.add(dato);
            System.out.println("Lista: "+Bancopel);
///////////////////////////////////////////////////////////////////
	 
////////////////////////////////////Clientes BBVA
	 	
            CuentadeCheques c2= new CuentadeCheques(1);
            CuentaHabiente h2= new CuentaHabiente (11,"Juan");
            CuentadeCheques c3= new CuentadeCheques(2);
            CuentaHabiente h3= new CuentaHabiente (22,"Luis");
            CuentadeCheques c4= new CuentadeCheques(3);
            CuentaHabiente h4= new CuentaHabiente (33,"Carlos");
                
            Map<CuentadeCheques,CuentaHabiente> cl2 = new HashMap<CuentadeCheques,CuentaHabiente> ();
            Map<CuentadeCheques,CuentaHabiente> cl3 = new HashMap<CuentadeCheques,CuentaHabiente> ();
            Map<CuentadeCheques,CuentaHabiente> cl4 = new HashMap<CuentadeCheques,CuentaHabiente> ();
            
            cl2.put(c2, h2);
            cl3.put(c3, h3);
            cl4.put(c4, h4);
                	
            for (Entry<CuentadeCheques,CuentaHabiente> cliente : c1.entrySet()){
                CuentadeCheques clave = cliente.getKey();
                CuentaHabiente valor = cliente.getValue();
                System.out.println(clave.toString()+"  ->  "+valor.toString());
            }
            ArrayList<Map<CuentadeCheques,CuentaHabiente>> BBVA = new ArrayList <>();
            BBVA.add(cl2);
            BBVA.add(cl3);
            BBVA.add(cl4);
            System.out.println("Lista: "+BBVA);
            dato = new HashMap<>();
            dato.put("BBVA", BBVA);
            listaCuentas.add(dato);
            
////////////////////////////////////////////////////////////////////////////////////////////	 
            ArrayList Chafamex = new ArrayList ();
            //Construccion del arbol
            DefaultMutableTreeNode Bancos = new DefaultMutableTreeNode ("Bancos");
            DefaultTreeModel modelo = new DefaultTreeModel (Bancos);
            JTree tree = new JTree (modelo);
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            tree.addTreeSelectionListener(new TreeSelectionListener() {
            	
            	
                public void valueChanged(TreeSelectionEvent e) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                            /* if nothing is selected */ 
                                if (node == null) return;
                            /* retrieve the node that was selected */ 
                                Object nodeInfo = node.getUserObject();
                            /* React to the node selection. */
                                switch(nodeInfo.toString()){
                                    case "BBVA":{
                                        listModel.clear();
                                        selected = nodeInfo.toString();
                                        for(Object obj : BBVA){
                                            for(Entry<CuentadeCheques,CuentaHabiente>cuenta : ((Map<CuentadeCheques,CuentaHabiente>)obj).entrySet()){
                                                  System.out.println(cuenta.getKey());
                                                  listModel.addElement(String.valueOf(cuenta.getKey()));
                                            }
                                        }
                                        break;
                                    }
                                    case "Bancopel":{
                                        listModel.clear();
                                        selected = nodeInfo.toString();
                                        for(Object obj : Bancopel){
                                            for(Entry<CuentadeCheques,CuentaHabiente>cuenta : ((Map<CuentadeCheques,CuentaHabiente>)obj).entrySet()){
                                                  listModel.addElement(String.valueOf(cuenta.getKey()));
                                            }
                                        }
                                        break;
                                    }
                                    default:listModel.clear();break;
                                }
                            }
                     });
	
	 //Construccion de los datos del arbol 
	 DefaultMutableTreeNode Banco1 = new DefaultMutableTreeNode ("Bancopel");
		 
	 DefaultMutableTreeNode Banco2 = new DefaultMutableTreeNode ("BBVA");
                      modelo.insertNodeInto(Banco1, Bancos, 0);
	 modelo.insertNodeInto(Banco2, Bancos, 0);

	 DefaultMutableTreeNode cliente1= new DefaultMutableTreeNode (c1);
	 modelo.insertNodeInto(cliente1, Banco1, 0);
	 DefaultMutableTreeNode cliente2= new DefaultMutableTreeNode (cl2);
	 modelo.insertNodeInto(cliente2, Banco2, 0);
                      DefaultMutableTreeNode cliente3= new DefaultMutableTreeNode (cl3);
	 modelo.insertNodeInto(cliente3, Banco2, 0);
                      DefaultMutableTreeNode cliente4= new DefaultMutableTreeNode (cl4);
	 modelo.insertNodeInto(cliente4, Banco2, 0);
	 //Botones
	
	initComponents(tree,cuentas,listaCuentas);
    }
    
    public static void initComponents(JTree tree,JList cuentas,ArrayList<Map<String,ArrayList>> listaCuentas ){
        JButton Consultar,Depositar,Retirar,Salir;	 
        Consultar = new JButton ("Consultar");
        Depositar = new JButton ("Depositar");
        Retirar = new JButton ("Retirar");
        Salir = new JButton ("Salir");
        
        //Construccion y visualizacion del la ventana
        JFrame v = new JFrame("Administrador de cuentas");
        v.setSize(850,500);
        v.setLayout(new BorderLayout());             
        JScrollPane scroll = new JScrollPane(tree);
        
        //panel para el contenido principal
        JPanel principal = new JPanel(new GridLayout(1,2));
        v.add(principal,BorderLayout.CENTER);
                     
        principal.add(scroll);
        //panel derecho para la lista de valores
        JPanel panel_cuentas = new JPanel(new BorderLayout());
        panel_cuentas.add(new JLabel("Cuentas Disponibles"),BorderLayout.NORTH);
        JScrollPane scroll2 =new JScrollPane(cuentas);
        panel_cuentas.add(scroll2,BorderLayout.CENTER);
        cuentas.addListSelectionListener(e->{
            System.out.println(cuentas.getSelectedIndex()+" actual");
        });
        JPanel espacioabajo = new JPanel(new GridLayout(1,4));
        Depositar.addActionListener(ActionEvent e->{
                if(cuentas.getSelectedIndex()!=-1){
                    for(int i = 0; i<listaCuentas.size(); i++){
                           for(Entry entry : listaCuentas.get(i).entrySet()){
                               if(entry.getKey().equals(selected)){
                                   for (Map.Entry<String, ArrayList> entrada : listaCuentas.get(i).entrySet()){
                                        ArrayList<Map<CuentadeCheques,CuentaHabiente>> li = entrada.getValue();
                                        for(int k=0; k < li.size();k++){
                                            for(Map.Entry<CuentadeCheques,CuentaHabiente> entrada2 : li.get(k).entrySet()){
                                                if(Integer.parseInt(entrada2.getKey().toString().split(":")[1])==cuentas.getSelectedIndex()+1){
                                                	NumberFormat format = NumberFormat.getInstance();
                                            	    NumberFormatter formatter = new NumberFormatter(format);
                                            	    formatter.setValueClass(Integer.class);
                                            	    formatter.setMinimum(0); //valor m�nimo
                                            	    formatter.setMaximum(Integer.MAX_VALUE); //valor m�ximo
                                            	    formatter.setAllowsInvalid(false);
                                            	    // Si quieres comprobar que sea v�lido, cada vez que se pulse una tecla
                                            	    formatter.setCommitsOnValidEdit(true);
                                            	    JFormattedTextField field = new JFormattedTextField(formatter);

                                            	    JOptionPane.showMessageDialog(null, field,"Ingrese cantidad a depositar",JOptionPane.DEFAULT_OPTION);
                                            	
                                            	
                                               //int saldo=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad que deseas retirar."));
                                            	int saldo=(int) field.getValue();;
                                                	
                                                	
                                                	//int saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad que deseas depositar."));
                                                
														entrada2.getKey().setSaldo(saldo);
										
                                                }
                                            }
                                        }
                                   }
                               }
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(panel_cuentas, "No haz seleccionado una cuenta valida.");
                    System.out.println(cuentas.getSelectedIndex());
                    System.out.println(selected);
                }
        });
        espacioabajo.add(Depositar);
        Consultar.addActionListener(e->{
            if(cuentas.getSelectedIndex()!=-1){
                System.out.println("x111111");
                    for(int i = 0; i<listaCuentas.size(); i++){
                           for(Entry entry : listaCuentas.get(i).entrySet()){
                               if(entry.getKey().equals(selected)){
                                   System.out.println("x222222");
                                   for (Map.Entry<String, ArrayList> entrada : listaCuentas.get(i).entrySet()){
                                        ArrayList<Map<CuentadeCheques,CuentaHabiente>> li = entrada.getValue();
                                        for(int k=0; k < li.size();k++){
                                            System.out.println("x3333");
                                            for(Map.Entry<CuentadeCheques,CuentaHabiente> entrada2 : li.get(k).entrySet()){
                                                if(Integer.parseInt(entrada2.getKey().toString().split(":")[1])==cuentas.getSelectedIndex()+1){
                                                    JOptionPane.showMessageDialog(panel_cuentas, "Tu saldo es : "+String.valueOf(entrada2.getKey().Saldo));                  
                                                }
                                            }
                                        }
                                   }
                               }
                        }
                    }
                }
        });
        espacioabajo.add(Consultar);
        Retirar.addActionListener(e->{
            if(cuentas.getSelectedIndex()!=-1){
                 if(cuentas.getSelectedIndex()!=-1){
                    for(int i = 0; i<listaCuentas.size(); i++){
                           for(Entry entry : listaCuentas.get(i).entrySet()){
                               if(entry.getKey().equals(selected)){
                                   for (Map.Entry<String, ArrayList> entrada : listaCuentas.get(i).entrySet()){
                                        ArrayList<Map<CuentadeCheques,CuentaHabiente>> li = entrada.getValue();
                                        for(int k=0; k < li.size();k++){
                                            for(Map.Entry<CuentadeCheques,CuentaHabiente> entrada2 : li.get(k).entrySet()){
                                                if(Integer.parseInt(entrada2.getKey().toString().split(":")[1])==cuentas.getSelectedIndex()+1){
                                                	    NumberFormat format = NumberFormat.getInstance();
                                                	    NumberFormatter formatter = new NumberFormatter(format);
                                                	    formatter.setValueClass(Integer.class);
                                                	    formatter.setMinimum(0); //valor m�nimo
                                                	    formatter.setMaximum(Integer.MAX_VALUE); //valor m�ximo
                                                	    formatter.setAllowsInvalid(false);
                                                	    // Si quieres comprobar que sea v�lido, cada vez que se pulse una tecla
                                                	    formatter.setCommitsOnValidEdit(true);
                                                	    JFormattedTextField field = new JFormattedTextField(formatter);

                                                	    JOptionPane.showMessageDialog(null, field,"Ingrese cantidad a retirar",JOptionPane.DEFAULT_OPTION);
                                                	
                                                	
                                                   //int saldo=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad que deseas retirar."));
                                                	int saldo=(int) field.getValue();;
                                                	
                                                	try {
													 entrada2.getKey().Retiro(saldo);
													} catch (SaldoNegativo e1) {
														// TODO Auto-generated catch block
														//e1.printStackTrace();
														 System.out.println(e1.getMessage());
														 String error = e1.getMessage();
														 JOptionPane.showMessageDialog(null, error, "Error en la transaccion", JOptionPane.WARNING_MESSAGE);
													}
                                                }
                                            }
                                        }
                                   }
                               }
                        }
                    }
                 }
            }else{
                    JOptionPane.showMessageDialog(panel_cuentas, "No haz seleccionado una cuenta valida.");
                    System.out.println(cuentas.getSelectedIndex());
                    System.out.println(selected);
                }
        }
        );
        espacioabajo.add(Retirar);
        Salir.addActionListener(e->{
            System.out.println("Salir");
            v.dispose(); 

        });
        espacioabajo.add(Salir);
        v.add(espacioabajo,BorderLayout.SOUTH);
        principal.add(panel_cuentas);       
        v.pack();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}