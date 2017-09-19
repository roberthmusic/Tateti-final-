

package Juego;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rob
 */
public class Vieja {
    
    //atributos
    JFrame ventana;
    //iniicio
    JPanel PanelInicio;
    JLabel fondo;
    JTextField jugador1;
    JTextField jugador2;
    JButton comenzar;
    //juego
    JPanel panelJuego;
    JLabel juga1;
    JLabel juga2;
    JLabel matriz [] [] = new JLabel [3][3];
    int mat [][] = new int [3][3];
    int turno = 1;
    JLabel labelTurno;
    int bandera=0;
    Vieja obj;
    
    public Vieja (){
        
        ventana = new JFrame ("JUEGO DE LA VIEJA");
        ventana.setSize(550, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout (null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        PanelInicio = new JPanel();
        PanelInicio.setSize(ventana.getWidth(), ventana.getHeight());
        PanelInicio.setLayout(null);
        PanelInicio.setVisible(true);
        //PanelInicio.setBackground(Color.red);
        
        fondo = new JLabel();
        fondo.setIcon(new ImageIcon("Imagenes/fondo.jpg"));
        fondo.setSize(ventana.getWidth(), ventana.getHeight());
        fondo.setVisible(true);
        PanelInicio.add(fondo,0);
        
        jugador1 = new JTextField("Ingrese nombre jugador1");
        jugador1.setBounds(175, 220, 100, 30);
        jugador1.setVisible(true);
        PanelInicio.add(jugador1,0);
        
        jugador2 = new JTextField("Ingrese nombre jugador1");
        jugador2.setBounds(175, 254, 100, 30);
        jugador2.setVisible(true);
        PanelInicio.add(jugador2,0);
        
        comenzar = new JButton("Comanzar");
        comenzar.setBounds(225, 288, 100, 30);
        comenzar.setVisible(true);
        comenzar.setBackground(Color.white);
        PanelInicio.add(comenzar,0);
        
        
        panelJuego = new JPanel();
        panelJuego.setSize(ventana.getWidth(), ventana.getHeight());
        panelJuego.setLayout(null);
        panelJuego.setVisible(true);
        //panelJuego.setBackground(Color.red);
        
        juga1 = new JLabel ();
        juga1.setSize(200, 30);
        juga1.setLocation(10, 10);
        juga1.setVisible(true);
        juga1.setForeground(Color.white);
        panelJuego.add(juga1,0);
        
        juga2 = new JLabel ();
        juga2.setSize(200, 30);
        juga2.setLocation(ventana.getWidth()-(10+juga2.getWidth()+10), 10);
        juga2.setVisible(true);
        juga2.setForeground(Color.white);
        panelJuego.add(juga2,0);
        
        labelTurno = new JLabel ();
        labelTurno.setSize(300, 30);
        labelTurno.setLocation(175, 500);
        labelTurno.setVisible(true);
        labelTurno.setForeground(Color.white);
        panelJuego.add(labelTurno,0);
        
        comenzar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                System.out.println("Presione el boton de comenzar");
                
                if(jugador1.getText().compareTo("Ingrese nombre jugador 1")!=0 && jugador2.getText().compareTo("Ingrese nombre jugador 2")!=0 ){
                    
                    PanelInicio.setVisible(false);
                    panelJuego.add(fondo);
                    juga1.setText("Jugador 1: "+jugador1.getText());
                    juga2.setText("Jugador 2: "+jugador2.getText());
                    labelTurno.setText("Turno del jugador: "+jugador1.getText()+" con la ficha circulo");
                    
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz.length; j++) {
                            mat[i][j] = 0;
                            matriz[i][j] = new JLabel ();
                            matriz[i][j].setIcon(new ImageIcon("imagenes/"+mat[i][j]+".png"));
                            matriz[i][j].setBounds(125+102*i, 150+102*j, 100, 100);
                            matriz[i][j].setVisible(true);
                            panelJuego.add(matriz[i][j],0);
                            
                        }
                        
                    }
                    
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz.length; j++) {
                            matriz[i][j].addMouseListener(new MouseAdapter() {
                                public void mouseClicked(MouseEvent e){
                                    for (int k = 0; k < matriz.length; k++) {
                                        for (int l = 0; l < matriz.length; l++) {
                                            
                                            if(e.getSource()==matriz[k][l]){
                                                System.out.println(k+""+l);
                                                if (mat[k][l]==0){
                                                    int jugador;
                                                    String nombre;
                                                    if (turno==1){
                                                    mat [k][l] = 1;
                                                    jugador =1;
                                                    nombre = jugador1.getText();
                                                    labelTurno.setText("Turno del jugador: "+jugador2.getText()+" con la ficha equis");
                                                    turno*=-1;
                                                    }
                                                    
                                                    else{
                                                    mat [k][l] = 2;
                                                    jugador = 2;
                                                    nombre = jugador2.getText();
                                                    labelTurno.setText("Turno del jugador: "+jugador1.getText()+" con la ficha circulo");   
                                                    turno*=-1;
                                                    }
                                                    matriz[k][l].setIcon(new ImageIcon("imagenes/"+mat[k][l]+".png"));
                                                    //Diagonal principal
        if (mat[0][0]==jugador && mat[1][1]== jugador && mat[2][2]== jugador)
            bandera=1;
        //Diagonal secundaria
        if (mat[2][0]==jugador && mat[1][1]== jugador && mat[0][2]== jugador)
            bandera=1;
        //Primera columna
        if (mat[0][0]==jugador && mat[0][1]== jugador && mat[0][2]== jugador)
            bandera=1;
        //Segunda columna
        if (mat[1][0]==jugador && mat[1][1]== jugador && mat[1][2]== jugador)
            bandera=1;
        //Tercera columna
        if (mat[2][0]==jugador && mat[2][1]== jugador && mat[2][2]== jugador)
            bandera=1;
        //Primera fila
        if (mat[0][0]==jugador && mat[1][0]== jugador && mat[2][0]== jugador)
            bandera=1;
        //Segunda fila
        if (mat[0][1]==jugador && mat[1][1]== jugador && mat[2][1]== jugador)
            bandera=1;
        //Tercera fila
        if (mat[0][2]==jugador && mat[1][2]== jugador && mat[2][2]== jugador)
            bandera=1;
        
        if ( bandera==1 ){
            JOptionPane.showMessageDialog(ventana, "GANÓ EL JUGADOR: "+nombre);
            bandera=0;
            turno=1;
            for (int m = 0; m < matriz.length; m++) {
                for (int n = 0; n < matriz.length; n++) {
                    mat [m][n] = 0;
                    matriz[m][n].setIcon(new ImageIcon("imagenes/"+mat[m][n]+".png"));
                    
                }
                
            }
            
        }
        int acumulador = 0;
                                                    for (int m = 0; m < matriz.length; m++) {
                                                        for (int n = 0; n < matriz.length; n++) {
                                                            if(mat [m][n]!=0)
                                                                acumulador++;
                                                        }
                                                        
                                                    }
                                                    if (acumulador == 9){
                                                        JOptionPane.showMessageDialog(ventana, "NO HUBO GANADOR");
                                                        acumulador = 0;
            bandera=0;
            turno=1;
            for (int m = 0; m < matriz.length; m++) {
                for (int n = 0; n < matriz.length; n++) {
                    mat [m][n] = 0;
                    matriz[m][n].setIcon(new ImageIcon("imagenes/"+mat[m][n]+".png"));
                    
                }
                
            }
                                                        
                                                        
                                                    }
                                                        
                                                }
                                                
                                            }
                                            
                                        }//fin for l
                                    }//fin for k
                                    
                                    
                                }
                                
                                });
                            
                            
                        }
                        
                    }
                    
                    
                    
                    
                    
                    ventana.add(panelJuego);
            
            }
                
            }
        
        });
        
        ventana.add(PanelInicio);
        
        ventana.setVisible(true);
    }//fin del constructor
    
    /**public void ganador(int jugador, String nombre){
        //Diagonal principal
        if (mat[0][0]==jugador && mat[1][1]== jugador && mat[2][2]== jugador)
            bandera=1;
        //Diagonal secundaria
        if (mat[2][0]==jugador && mat[1][1]== jugador && mat[0][2]== jugador)
            bandera=1;
        //Primera columna
        if (mat[0][0]==jugador && mat[0][1]== jugador && mat[0][2]== jugador)
            bandera=1;
        //Segunda columna
        if (mat[1][0]==jugador && mat[1][1]== jugador && mat[1][2]== jugador)
            bandera=1;
        //Tercera columna
        if (mat[2][0]==jugador && mat[2][1]== jugador && mat[2][2]== jugador)
            bandera=1;
        //Primera fila
        if (mat[0][0]==jugador && mat[1][0]== jugador && mat[2][0]== jugador)
            bandera=1;
        //Segunda fila
        if (mat[0][1]==jugador && mat[1][1]== jugador && mat[2][1]== jugador)
            bandera=1;
        //Tercera fila
        if (mat[0][2]==jugador && mat[1][2]== jugador && mat[2][2]== jugador)
            bandera=1;
        
        if ( bandera==1 ){
            JOptionPane.showMessageDialog(ventana, "GANÓ EL JUGADOR: "+nombre);
            
        }
        
    }*/



    
}
