package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje, fecha_mensaje) VALUES (?, ?, CURRENT_DATE())";
                ps = cnx.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje fue creado");
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void leerMensajesDB(){

    }

    public static void borrarMensajeDB(int id_mensaje){

    }

    public static void actualizarMensajesDB(Mensajes mensaje){

    }
}
