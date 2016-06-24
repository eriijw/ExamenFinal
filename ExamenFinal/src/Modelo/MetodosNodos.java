/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Erika
 */
public class MetodosNodos {
    
    Nodo cita;
    int numCita=0;
    int total=0;
    
    public MetodosNodos()
    {
        
    }
    //Verifica si existe o no una lista ya creada
    public boolean verificarCita()
    {
        boolean existe=true;

            if(cita==null)
            {
                existe=false;
            } 
        return existe;
    }
    
    public void crear (String nombre, String cedula, int edad, String fecha, int ficha, int prioridad, Nodo siguiente)
    {
            if(cita==null)
            {
            cita=new Nodo(nombre,cedula,edad,fecha,ficha,prioridad,null);
            numCita=(001);
            }
            else
            {
                if(prioridad==1)
                {
                    agregarAlFinal(nombre,cedula,edad,fecha,ficha,prioridad,null);
                }
                if(prioridad==2)
                {
                    Nodo temporal=new Nodo(nombre,cedula,edad,fecha,ficha,prioridad,null);
                    temporal.setSiguiente(cita);
                    cita=temporal;
                }
            }
    }
    
     public void agregarAlFinal(String nombre, String cedula, int edad, String fecha, int ficha, int prioridad, Nodo siguiente)
    {
            Nodo temporal=devolverUltimoNodo();
            Nodo nuevoNodo=new Nodo(nombre,cedula,edad,fecha,ficha,prioridad,null);
            temporal.setSiguiente(nuevoNodo);
            numCita=temporal.getSiguiente().getFicha();
    }
    
    
    public Nodo devolverUltimoNodo()
    {
        Nodo temporal=cita;
        total=0;
        while(temporal.getSiguiente()!=null)
        {
            temporal=temporal.getSiguiente();
            total++;
        }
        total++;
        System.out.println(temporal.getFicha());
        return temporal;   
        
    }
    
    
    public void eliminarPrimero()
    {
        System.out.print("EliminarPrimero");
            Nodo temporal=cita.getSiguiente();
            cita=temporal;
        
    }
    
    public int imprimirPrimerNodo()
    {
        int primero=0;
        Nodo temporal=cita;
        
        if(temporal.getSiguiente()!=null)
        {
            primero=temporal.getFicha();
        }
        return primero;
    }
    
    public void eliminar(String cedula)
    {
        Nodo temporal=cita;
        boolean eliminado=false;
        if(temporal.cedula.equals(cedula))
        {
            cita=cita.siguiente;
            eliminado=true;
        }
        else
        {
            temporal=devolverUltimoNodo();
            if(temporal.cedula.equals(cedula))
            {
                temporal=devolverAntepenultimoNodo();
                temporal.siguiente=null;
                eliminado=true;
            }
        }
        
        if(!eliminado)
        {
            Nodo aux;
            temporal=devolverNodoAnterior(cedula);
            aux=temporal.siguiente.siguiente;
            temporal.siguiente=temporal;
            
        }
    }
    
    public Nodo devolverAntepenultimoNodo()
    {
        Nodo temporal=cita;
        while(temporal.siguiente.siguiente!=null)
        {
            temporal=temporal.siguiente;
        }
        
        return temporal;
    }
    
    public Nodo devolverNodoAnterior(String cedula)
    {
        Nodo temporal=cita;
        while(!temporal.siguiente.cedula.equals(cedula))
        {
            temporal=temporal.siguiente;
        }
        return temporal;
    }
    
    
    public String imprimir()
    {
        String texto="";
        Nodo temporal=cita;
        while(temporal.getSiguiente()!=null)
        {
            texto+="Ficha: "+temporal.getFicha()+" Nombre: "+temporal.getNombre()+" Edad: "+temporal.getEdad()+" Cedula: "+temporal.getCedula()+"\n";
            temporal=temporal.getSiguiente();
        }
       texto+="Ficha: "+temporal.getFicha()+" Nombre: "+temporal.getNombre()+" Edad: "+temporal.getEdad()+" Cedula: "+temporal.getCedula()+"\n";
       
        return texto;
        
    }
    
     public int promedio()
    {
        int suma=0;
        int contador=0;
        Nodo auxiliar=cita;
        while(auxiliar.siguiente!=null)
        {
            suma+=auxiliar.edad;//
            contador++;
            auxiliar=auxiliar.siguiente;
        }
        return suma/contador;
    }
    
    
    
    public void mayorMenor()
    {
        int cantidadNodos=devolverCitas();
        int edadTemporal;
        String cedulaTemporal;
        String nombreTemporal;
        String fechaTemporal;
        Nodo temporal=cita;
        for(int contador=0;contador<cantidadNodos;contador++)
        {
            temporal=cita;
            while(temporal.siguiente!=null)
            {
                if(temporal.getEdad()>temporal.siguiente.getEdad())
                {
                    edadTemporal=temporal.getEdad();
                    cedulaTemporal=temporal.getCedula();
                    nombreTemporal=temporal.getNombre();
                    fechaTemporal=temporal.getFecha();
                    temporal.edad=temporal.siguiente.edad;
                    temporal.cedula=temporal.siguiente.cedula;
                    temporal.nombre=temporal.siguiente.nombre;
                    temporal.fecha=temporal.siguiente.fecha;
                    temporal.siguiente.edad=edadTemporal;
                    temporal.siguiente.cedula=cedulaTemporal;
                    temporal.siguiente.nombre=nombreTemporal;
                    temporal.siguiente.fecha=fechaTemporal;
                }
                temporal=temporal.siguiente;
            }
        }
    }
    
    
    public void menorMayor()
    {
             int cantidadNodos=devolverCitas();
        int edadTemporal;
        String cedulaTemporal;
        String nombreTemporal;
        String fechaTemporal;
        Nodo temporal=cita;
        for(int contador=0;contador>cantidadNodos;contador++)
        {
            temporal=cita;
            while(temporal.siguiente!=null)
            {
                if(temporal.getEdad()>temporal.siguiente.getEdad())
                {
                    edadTemporal=temporal.getEdad();
                    cedulaTemporal=temporal.getCedula();
                    nombreTemporal=temporal.getNombre();
                    fechaTemporal=temporal.getFecha();
                    temporal.edad=temporal.siguiente.edad;
                    temporal.cedula=temporal.siguiente.cedula;
                    temporal.nombre=temporal.siguiente.nombre;
                    temporal.fecha=temporal.siguiente.fecha;
                    temporal.siguiente.edad=edadTemporal;
                    temporal.siguiente.cedula=cedulaTemporal;
                    temporal.siguiente.nombre=nombreTemporal;
                    temporal.siguiente.fecha=fechaTemporal;
                }
                temporal=temporal.siguiente;
            }
        }
    }
    
      public int devolverCitas()
    {
        int contador=1;
        Nodo temporal=cita;
        while(temporal.siguiente!=null)
        {
            contador++;
            temporal=temporal.siguiente;
        }
        
        return contador;
    }
    
    public void modificar(String cedula,String nombre,int edad,String fecha)
    {
        Nodo temporal;
        temporal=buscarCita(cedula);
        temporal.nombre=nombre;
        temporal.edad=edad;
        temporal.fecha=fecha;
        
    }
    
    public Nodo buscarCita(String cedula)
    {
        Nodo temporal=cita;
        while(temporal.cedula==cedula)
        {
            temporal=temporal.siguiente;
        }
        
        return temporal;
    }
}
