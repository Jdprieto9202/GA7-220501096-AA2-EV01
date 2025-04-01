
package Clases;
import java.sql.*;
public class Conexion {

   Connection cn;
   PreparedStatement ps;
   ResultSet rs;
   
   public Conexion(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgiv", "root", "12345");
           System.out.println("Conectado BD");
       } catch (Exception e) {
           System.out.println("Error al conectar BD");
       }
   }
   public int reusuario(String cod_cliente, String nombre, String direccion,String telefono, String documento,String correo, String cod_factura){
       int res = 0;
       try {
           ps = cn.prepareStatement("insert into cliente(cod_cliente, nombre, direccion, telefono, documento, correo, cod_factura)values(?,?,?,?,?,?,?) ");
           ps.setString(1, cod_cliente);
           ps.setString(2, nombre);
           ps.setString(3, direccion);
           ps.setString(4, telefono);
           ps.setString(5, documento);
           ps.setString(6, correo);
           ps.setString(7, cod_factura);
           res = ps.executeUpdate();
           System.out.println("Usuario Registrado correctamente");
       } catch (Exception e) {
           System.out.println("Error al registrar el usuario");
       }
      
       return res;
   }
     public int acusuario(String cod_cliente, String nombre, String direccion,String telefono, String documento,String correo, String cod_factura, String id){
         int res = 0;
         try {
             ps = cn.prepareStatement("update cliente set cod_cliente=?, nombre=?, direccion=?, telefono=?, documento=?, correo=?, cod_factura=? where id=?");
             ps.setString(1, cod_cliente);
             ps.setString(2, nombre);
             ps.setString(3, direccion);
             ps.setString(4, telefono);
             ps.setString(5, documento);
             ps.setString(6, correo);
             ps.setString(7, cod_factura);
             ps.setString(8, id);
             res=ps.executeUpdate();
             System.out.println("Datos actualizados correctamente");
         } catch (Exception e) {
             System.out.println("Error al modificar datos");
         }
         return res;
         
     }
     
     public int elusuario( String id){
         int res = 0;
         try {
             ps = cn.prepareStatement("delete from cliente where id=?");
             ps.setString(1, id);
             res=ps.executeUpdate();
             System.out.println("Datos eliminados correctamente");
         } catch (Exception e) {
             System.out.println("Error al eliminar datos");
         }
         return res;
         
         
     }
}
