package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM mensajes";
                ps = cnx.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()){
                    System.out.println("ID: "+rs.getInt("id_mensaje"));
                    System.out.println("Mensaje: "+rs.getString("mensaje"));
                    System.out.println("Autor: "+rs.getString("autor_mensaje"));
                    System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                    System.out.println("");
                }
            }catch (SQLException ex){
                System.out.println("No se pudieron recuperar los mensajes");
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void borrarMensajeDB(int id_mensaje){

    }

    public static void actualizarMensajesDB(Mensajes mensaje){

    }
}
