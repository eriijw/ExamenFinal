/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MetodosNodos;
import Vista.FRM_Migracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Erika
 */
public class Controlador implements ActionListener {

    MetodosNodos metodos;
    FRM_Migracion ventana;
   // int tipoPlataforma=1;
    
    public Controlador(FRM_Migracion ventana)
    {
       this.ventana=ventana;
       metodos= new MetodosNodos();
       ventana.setCita(ventana.aumento());
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Entrar"))
        { 
            this.ventana.setVisible(true);
        }
        
        if (e.getActionCommand().equals("NuevaFicha"))
        {
           metodos.crear(ventana.enviarInformacionNombre(),ventana.enviarInformacionCedula(),Integer.parseInt(ventana.enviarInformacionEdad()),ventana.enviarInformacionFecha(),Integer.parseInt(ventana.getFicha()),ventana.enviarPrioridad(), null);
           ventana.setCita(ventana.aumento());
           ventana.imprimirArea(metodos.imprimir());
           ventana.limpiarDatos();
    }
         if (e.getActionCommand().equals("<"))
         {
            metodos.menorMayor();
            ventana.imprimirArea(metodos.imprimir());
         }
          if (e.getActionCommand().equals(">"))
         {
            metodos.mayorMenor();
            ventana.imprimirArea(metodos.imprimir());
         }
          if (e.getActionCommand().equals("Promedio"))
         {
            metodos.promedio();
            ventana.imprimirArea(metodos.imprimir());
         }
          
           if (e.getActionCommand().equals("Eliminar"))
         {
            metodos.eliminar(ventana.enviarInformacionCedula());
            ventana.imprimirArea(metodos.imprimir());
         }
             if (e.getActionCommand().equals("Siguiente"))
         {
            ventana.imprimirArea(""+metodos.imprimirPrimerNodo());
            metodos.eliminarPrimero();
         }
                 if (e.getActionCommand().equals("Modificar"))
         {
            metodos.modificar(ventana.enviarInformacionCedula(),ventana.enviarInformacionNombre(),Integer.parseInt(ventana.enviarInformacionEdad()),ventana.enviarInformacionFecha());
            ventana.imprimirArea(metodos.imprimir());
         }
        
    
}
}