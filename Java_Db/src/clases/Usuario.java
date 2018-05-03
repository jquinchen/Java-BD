package clases;

import Ventana.*;
import db.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Usuario {
    Conexion cl=new Conexion();
    Connection cn=cl.Conexion();
    String nombre;
    String usuario;
    String clave;
    int id_usuario;

    public Usuario() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    

    
 
    
 
    
    
     public void validarIngreso(){
        String nombre="";
        
        String sql="Select * from Usuarios where usuario='"+this.getUsuario()+"' && clave='"+this.getClave()+"'";
          try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                nombre=rs.getString("nombre");
            }
            
            if(nombre.equals("")){
                System.out.println("no existe registro");
                Log login = new Log();
                login.setVisible(true);
            }else{
                Home ent = new Home();
                ent.setVisible(true);
            }
           
            
        } catch (SQLException ex) {
           System.out.println("error");
        }       
    }
    
    /*
     public void Crear_Usuario(){
   String sql= "insert into Usuario(rut, password, nombre, id_perfil) values('"+this.getRut()+"', '"+this.getPassword()+"', '"+this.getNombre()+"', "+this.getId_perfil()+")";
         cl.setExecuteUpdate(sql);
     }
   public void Actualizar(){
       String sql ="update Usuario set  password= '"+this.getPassword()+"' , nombre= '"+this.getNombre()+"' , id_perfil="+this.getId_perfil()+" where rut = '"+this.getRut()+"'  ";
     cl.setExecuteUpdate(sql);
}
   public void Eliminar(){
       String sql="delete from Usuario where rut='"+this.getRut()+"' ";
       cl.setExecuteUpdate(sql);
   }
*/
}
